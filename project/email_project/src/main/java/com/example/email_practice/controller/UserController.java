package com.example.email_practice.controller;

import com.example.email_practice.domain.User;
import com.example.email_practice.repository.UserRepository;
import com.example.email_practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * creating password authentication
   * @return
   */
  @PostMapping("/user/join")
  public String join(@RequestBody String password) {

    boolean result = userService.checkPasswordMatch(encodePassword(password));
    if (result) return "newpassword";
    else return "join";
  }

  @GetMapping("/user/form")
  public String form() {

    return "join";
  }

  @RequestMapping("/user/changepassword")
  public void changePassword(@RequestBody User user) {
    user.setPassword(encodePassword(user.getPassword()));
    userService.insertPassword(user);
    System.out.println("saved");
  }

  private String encodePassword(String password) {
    return passwordEncoder.encode(password);
  }
}
