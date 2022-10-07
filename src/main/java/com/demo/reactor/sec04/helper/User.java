package com.demo.reactor.sec04.helper;

import com.demo.reactor.utility.ReactorUtil;
import lombok.Data;

@Data
public class User {

  private String userId;
  private String name;

  public User(String userId){
    this.userId=userId;
    this.name= ReactorUtil.faker().name().fullName();
  }

}
