package com.demo.reactor.sec03;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateUntil {

  public static void main(String[] args) {


    Flux.generate(synchronousSink -> {
          System.out.println("emitting");
          String country = ReactorUtil.faker().country().name();
          synchronousSink.next(country);
          if(country.toLowerCase().equals("canada"))
             synchronousSink.complete();
    })
        .take(3)
        .subscribe(ReactorUtil.getDefaultSubscriber());

  }

}
