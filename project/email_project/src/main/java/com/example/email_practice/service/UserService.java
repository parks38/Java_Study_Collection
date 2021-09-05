package com.example.email_practice.service;

import com.example.email_practice.domain.User;
import com.example.email_practice.repository.UserRepository;
import com.example.email_practice.util.HashCalculator.Hash;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  /**
   * 패스워드 일치 확인
   *
   * @param password
   * @return
   * @throws Exception
   */
  public boolean checkPasswordMatch(String password) throws Exception {

    Optional<User> user = userRepository.findById(2);

    return user.isPresent() &&
        Objects.equals(user.get().getPassword(), Hash.SHA256.checksum(password));
  }

  /**
   * 새로운 패스워드 저장
   *
   * @param newPassword
   * @return
   */
  public Optional<User> insertPassword(String newPassword) {

    Optional<User> user = userRepository.findById(2);

    user.ifPresent(selectUser ->{
      try {
        selectUser.setPassword(Hash.SHA256.checksum(newPassword));
        userRepository.save(selectUser);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    return user;
  }
}
