package com.demo.reactor.sec05;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec07Assignment {

  public static void main(String[] args) {

    Flux<Integer> flux = Flux.create(fluxSink -> {
      System.out.println("created");
      for (int i = 0; i < 5; i++) {
        fluxSink.next(i);
      }
      fluxSink.complete();
    });
    Flux<Integer> cache = flux.filter(i -> i > 1)
      //  .delayElements(Duration.ofSeconds(1))
        .cache(1);

    cache.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));
    cache.subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));

    ReactorUtil.sleepSeconds(10);
  }

}
