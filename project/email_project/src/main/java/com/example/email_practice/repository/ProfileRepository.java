package com.example.email_practice.repository;

import com.example.email_practice.domain.Profile;
import com.example.email_practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
