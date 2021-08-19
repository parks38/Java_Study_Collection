package com.example.email_practice.service;

import com.example.email_practice.domain.User;
import com.example.email_practice.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public boolean checkPasswordMatch(String encodedPassword) {
    Optional<User> user = Optional.ofNullable(userRepository.findById(1).orElseThrow(() ->
        new IllegalArgumentException("회원 찾기 실패")));

    return encodedPassword.equals(user.get().getPassword());
  }

  public void insertPassword(User user) {
    userRepository.save(user);
  }
}
