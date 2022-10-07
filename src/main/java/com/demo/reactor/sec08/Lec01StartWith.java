package com.demo.reactor.sec08;

import com.demo.reactor.sec08.helper.NameGenerator;
import com.demo.reactor.utility.ReactorUtil;

public class Lec01StartWith {

  public static void main(String[] args) {

    NameGenerator nameGenerator = new NameGenerator();

    nameGenerator.generateNames()
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));

    nameGenerator.generateNames()
     //   .startWith(nameGenerator.getFromCache())
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));

    nameGenerator.generateNames()
        .take(5)
        .subscribe(ReactorUtil.getDefaultSubscriber("Sub3"));

    nameGenerator.generateNames()
        .filter(name->name.startsWith("A"))
        .take(2)
        .subscribe(ReactorUtil.getDefaultSubscriber("Sub4"));
  }

}
