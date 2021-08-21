package com.example.email_practice.controller;

import com.example.email_practice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
  @Autowired
  private ProfileService profileService;

    @RequestMapping("/main")
    public String main(ModelMap model) {
      model.addAttribute("profileList", profileService.selectInfo());
      return "main";
    }
}
