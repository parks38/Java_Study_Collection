package com.example.email_practice.controller;

import com.example.email_practice.domain.PasswordUpdateVO;
import com.example.email_practice.domain.User;
import com.example.email_practice.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

  @Autowired
  private UserService userService;

  /**
   *  로그인 폼
   *
   * @return
   */
  @RequestMapping("/user/form")
  public String form() {

    return "join";
  }

  /**
   * 로그인 AUTH
   * @param user
   * @return
   * @throws Exception
   */
  @RequestMapping("/user/login")
  public ResponseEntity<String> login(@RequestBody User user) throws Exception {

    return getResponse(userService.checkPasswordMatch(user.getPassword()));
  }

  /**
   * NEW PASSWORD CHANGE FORM
   * @return
   */
  @GetMapping("/user/newForm")
  public String newpassword() {
    // password : 1111
    return "newpassword";
  }

  /**
   * 패스워드 변경
   *
   * @param passwordUpdate
   * @return
   * @throws Exception
   */
  @RequestMapping("/user/changepassword")
  public ResponseEntity<String> changePassword(@RequestBody PasswordUpdateVO passwordUpdate) throws Exception {

    boolean result = userService.checkPasswordMatch(passwordUpdate.getPassword());
    if (result) {
      return getResponse(userService.insertPassword(passwordUpdate.getNewPassword()).isPresent());
    }
    return new ResponseEntity<>("fail", HttpStatus.UNAUTHORIZED);
  }

  /**
   * response
   * @param result
   * @return
   */
  private ResponseEntity<String> getResponse(boolean result) {

    if (result) {
      return new ResponseEntity<>("success", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("fail", HttpStatus.UNAUTHORIZED);
    }
  }
}
