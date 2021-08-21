package com.example.email_practice.controller;

import com.example.email_practice.domain.User;
import com.example.email_practice.repository.UserRepository;
import com.example.email_practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
  @RequestMapping("/user/form")
  public String form(@RequestBody(required = false) User user) {
  if(user != null) {
    boolean result = userService.checkPasswordMatch(user.getPassword());
    if (result) {
      System.out.println("password match");
      return "newpassword";
    } else {
      System.out.println("password fail");
    }
  }
    return "join";
  }

  @GetMapping("/user/newForm")
  public String newpassword() {

    return "newpassword";
  }

  @RequestMapping("/user/changepassword")
  public void changePassword(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userService.insertPassword(user);
    System.out.println("saved");
  }
}
