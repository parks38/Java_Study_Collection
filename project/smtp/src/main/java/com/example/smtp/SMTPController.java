package com.example.smtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SMTPController {

  @Autowired
  SMTPService smtpService;

  @RequestMapping("/send")
  public void index() {
    try {
      smtpService.send();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @RequestMapping("/main")
  public ModelAndView main(ModelAndView mv) {
    mv.setViewName("/main");
    return mv;
  }
}
