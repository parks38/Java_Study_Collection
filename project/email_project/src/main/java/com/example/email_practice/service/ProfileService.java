package com.example.email_practice.service;

import com.example.email_practice.domain.Profile;
import com.example.email_practice.repository.ProfileRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
  @Autowired
  private ProfileRepository profileRepository;

  public List<Profile> selectInfo() {
    return profileRepository.findAll();
  }

  public int getCategory(int categoryId) {
    System.out.println("working category " + categoryId);
    return categoryId;
  }

  public void getCategorySort(int categoryId) {
    System.out.println("working category sort " + categoryId);
  }

  public void getRecent() {
    System.out.println("working recent ");
  }

  public void getRecentSort() {
    System.out.println("working category sort");
  }

  public void getKeyword(String type, String keyword) {
    System.out.println("working keyword search with type " + type + " and keyword " + keyword);
  }

  public void getKeywordSort(String type, String keyword) {
    System.out.println("working keyword sort search with type " + type + " and keyword " + keyword);
  }

  public void getKeywordDate(String type, String keyword, Date fromdate, Date todate) {
    System.out.println("working keyword search with type " + type + " and keyword " + keyword);
    System.out.println("date from : " +fromdate + " to todate : " + todate);
  }

  public void getKeywordDateSort(String type, String keyword, Date fromdate, Date todate) {
    System.out.println("working keyword sort search with type " + type + " and keyword " + keyword);
    System.out.println("date from : " +fromdate + " to todate : " + todate);
  }
}
