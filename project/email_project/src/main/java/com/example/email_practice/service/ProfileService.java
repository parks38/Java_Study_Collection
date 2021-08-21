package com.example.email_practice.service;

import com.example.email_practice.domain.Profile;
import com.example.email_practice.repository.ProfileRepository;
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
}
