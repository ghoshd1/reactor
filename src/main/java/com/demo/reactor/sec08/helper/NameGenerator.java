package com.demo.reactor.sec08.helper;

import com.demo.reactor.utility.ReactorUtil;
import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;

public class NameGenerator {

  private List<String> cache = new ArrayList<String>();
  public Flux<String> generateNames(){
    return Flux.generate(synchronousSink -> {
      System.out.println("Generated fresh");
      ReactorUtil.sleepSeconds(1);
      String name = ReactorUtil.faker().name().fullName();
      cache.add(name);
      synchronousSink.next(name);
    })
        .cast(String.class)
        .startWith(getFromCache());
  }

  public Flux<String> getFromCache(){
    return Flux.fromIterable(cache);
  }

}
