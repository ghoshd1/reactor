package com.demo.reactor.sec04.helper;

import com.demo.reactor.utility.ReactorUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Person {

  private String name;
  private int age;

  public Person(){
    this.name= ReactorUtil.faker().name().fullName();
    this.age= ReactorUtil.faker().random().nextInt(10);
  }

  public Person(Integer integer) {
    this.name= ReactorUtil.faker().name().fullName();
    this.age= ReactorUtil.faker().random().nextInt(10);
  }
}
