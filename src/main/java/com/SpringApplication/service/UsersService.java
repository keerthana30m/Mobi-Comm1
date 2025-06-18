package com.SpringApplication.service;

import com.SpringApplication.config.TwilioConfig;
import com.SpringApplication.entity.Users;
import com.SpringApplication.repository.UsersRepository;
import com.SpringApplication.security.JwtUtil;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private TwilioConfig twilioConfig;

    @Autowired
    private JwtUtil jwtUtil;

    public String requestOtp(String mobileNumber) {
        // Validate phone number exists
        Users user = userRepository.findByMobileNumber(mobileNumber);
        if (user == null) {
            throw new IllegalArgumentException("Phone number not found");
        }

        // Send OTP via Twilio Verify
        Verification verification = Verification.creator(
                twilioConfig.getVerifyServiceSid(),
                "+91" + mobileNumber,
                "sms"
        ).create();
        
        if ("pending".equals(verification.getStatus())) {
            return "OTP sent successfully to " + mobileNumber;
        } else {
            throw new IllegalStateException("Failed to send OTP");
        }
    }

    public Map<String, Object> verifyOtp(String mobileNumber, String otp) {
        VerificationCheck verificationCheck = VerificationCheck.creator(twilioConfig.getVerifyServiceSid())
                .setTo("+91" + mobileNumber)
                .setCode(otp)
                .create();

        if ("approved".equals(verificationCheck.getStatus())) {
            Users user = userRepository.findByMobileNumber(mobileNumber);
            String jwt = jwtUtil.generateToken(user.getUserName(), "USER");

            Map<String, Object> response = new HashMap<>();
            response.put("jwt", jwt);
            response.put("userId", user.getUserId());
            response.put("username", user.getUserName());
            response.put("email", user.getEmailId());
            response.put("mobile", user.getMobileNumber());

            return response;
        } else {
            throw new IllegalArgumentException("Invalid OTP");
        }
    }
    
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Users findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Users getUserByMobile(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber);
    }
}
