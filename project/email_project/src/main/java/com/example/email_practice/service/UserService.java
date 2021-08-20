package com.example.email_practice.service;

import com.example.email_practice.domain.User;
import com.example.email_practice.repository.UserRepository;
import com.example.email_practice.util.PasswordWrongException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * charSequence("1111", encodedPassword); 로 하면 작동하는데
   * 값을 받아 넣으면 에러.
   * String and charSequence creates same content but not the same
   * password.equals("1111"); //false
   * parameter 을 string 으로 받기보다는 객체로 받아서 넘기기
   */
  public boolean checkPasswordMatch(String password) {
    Optional<User> user = userRepository.findById(4);
    //pwdEncoder.matches(입력된 비밀번호(), 암호화된 비밀번호())
    return user.filter(value -> passwordEncoder.matches(password, value.getPassword())).isPresent();
  }


  public void insertPassword(User user) {
    userRepository.save(user);
    System.out.println(passwordEncoder.matches("1111", user.getPassword()));
  }
}
