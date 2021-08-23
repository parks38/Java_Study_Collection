package com.example.email_practice.controller;

import com.example.email_practice.domain.EnumFilter;
import com.example.email_practice.domain.FilterType;
import com.example.email_practice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/category")
  public String category(ModelMap model, @RequestParam(required = false)EnumFilter filter, @RequestBody(required = false)
        FilterType filterType) {

      if(filter != null) {
        System.out.println(
            "type : " + filterType.getType() +
                " keyword : " + filterType.getKeyword() +
                " sort : " + filterType.getSort() +
                " categoryId : " + filterType.getCategoryId() +
                " fromdate : " + filterType.getFromdate() +
                " todate : " + filterType.getTodate());

        switch(filter) {
          case CATEGORY :
            System.out.println("category case");
            model.addAttribute("filter",profileService.getCategory(filterType.getCategoryId()));
            break;
          case CATEGORY_SORT:
            System.out.println("category sort case");
            profileService.getCategorySort(filterType.getCategoryId());
            break;
          case KEYWORD:
            System.out.println("keyword case");
            profileService.getKeyword(filterType.getType(), filterType.getKeyword());
            break;
          case KEYWORD_SORT:
            System.out.println("keyword sort case");
            profileService.getKeywordSort(filterType.getType(), filterType.getKeyword());
            break;
          case KEYWORD_DATE:
            System.out.println("keyword date case");
            profileService.getKeywordDate(filterType.getType(), filterType.getKeyword(), filterType.getFromdate(), filterType.getTodate());
            break;
          case KEYWORD_DATE_SORT:
            System.out.println("keyword date sort case");
            profileService.getKeywordDateSort(filterType.getType(), filterType.getKeyword(), filterType.getFromdate(), filterType.getTodate());
            break;
          case RECENT_SORT:
            System.out.println("recent sort case");
            profileService.getRecentSort();
            break;
        }
      } else {
        System.out.println("no parameter case");
        profileService.getRecent();
      }

      return "category";
    }
}
