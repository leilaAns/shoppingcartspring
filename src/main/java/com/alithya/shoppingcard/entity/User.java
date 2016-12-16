package com.alithya.shoppingcard.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
  
  private String role;
  
  
  public User() {
    
  }

  public User(String role) {
    
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User [role=" + role + "]";
  }
  

}
