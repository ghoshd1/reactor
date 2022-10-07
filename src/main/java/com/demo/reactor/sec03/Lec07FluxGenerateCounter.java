package com.demo.reactor.sec03;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {

  public static void main(String[] args) {

    Flux.generate(
        () -> 1,
            (counter, synchronousSink) -> {
              System.out.println("emitting");
              String country = ReactorUtil.faker().country().name();
              synchronousSink.next(country);
              if (country.toLowerCase().equals("canada") || counter == 5) {
                synchronousSink.complete();
              }
              return counter + 1;
            })
        // .take(3)
        .subscribe(ReactorUtil.getDefaultSubscriber());

  }

}
