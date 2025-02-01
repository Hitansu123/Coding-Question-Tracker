package com.example.CodingQuestionTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.CodingQuestionTracker.AuthenticationRepo.Authenticationrepo;
import com.example.CodingQuestionTracker.Entity.Users;

public class CustomUserDetail {

  @Autowired
  private Authenticationrepo authenticationrepo;

  public UserDetails loadUserbyusername(String username) throws Exception {
    Users user = authenticationrepo.findByUsername(username);
    if (user.getUsername() != null) {
      return User.builder()
          .username(user.getUsername())
          .password(user.getPassword())
          .build();
    }
    throw new UsernameNotFoundException("username cannot be found");
  }
}
