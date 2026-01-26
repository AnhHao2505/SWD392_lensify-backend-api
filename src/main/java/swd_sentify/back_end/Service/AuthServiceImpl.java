package swd_sentify.back_end.Service;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import swd_sentify.back_end.DTO.RegisterRequest;
import swd_sentify.back_end.DTO.VerifyUserRequest;
import swd_sentify.back_end.Entity.User;
import swd_sentify.back_end.Repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public User register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        String verificationCode = generateVerificationCode();
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .address(request.getAddress())
                .role("USER")
                .active(false)
//                .verificationCode(verificationCode)
//                .verificationExpiry(LocalDateTime.now().plusMinutes(15))
                .build();
        user.setVerificationCode(verificationCode);
        user.setVerificationExpiry(LocalDateTime.now().plusMinutes(15));

        User savedUser = userRepository.save(user);

        try {
            emailService.sendVerificationEmail(savedUser.getEmail(), savedUser.getName(), verificationCode);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send verification email");
        }

        return savedUser;
    }

    @Override
    public void verifyAccount(VerifyUserRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getVerificationExpiry().isBefore(LocalDateTime.now())){
                throw new RuntimeException("Verification code expired");
            }
            if(user.getVerificationCode().equals(request.getVerificationCode())){
                user.setActive(true);
                user.setVerificationCode(null);
                user.setVerificationExpiry(null);
                userRepository.save(user);
            } else {
                throw new RuntimeException("Invalid verification code");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void resendVerificationCode(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.isActive()){
                throw new RuntimeException("Account already activated");
            }
            user.setVerificationCode(generateVerificationCode());
            user.setVerificationExpiry(LocalDateTime.now().plusMinutes(15));
            userRepository.save(user);
            try {
                emailService.sendVerificationEmail(user.getEmail(), user.getName(), user.getVerificationCode());
            } catch (MessagingException e) {
                throw new RuntimeException("Failed to send verification email");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    private String generateVerificationCode() {
        int code = (int)(Math.random() * 900000) + 100000; // tạo mã 6 chữ số
        return String.valueOf(code);
    }

}
