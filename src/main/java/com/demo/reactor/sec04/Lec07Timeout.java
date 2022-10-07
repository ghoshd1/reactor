package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec07Timeout {

  public static void main(String[] args) {

    getOrderNumbers()
        .timeout(Duration.ofSeconds(2))
        .subscribe(ReactorUtil.getDefaultSubscriber());


    getOrderNumbers()
        .timeout(Duration.ofSeconds(2),fallback())
        .subscribe(ReactorUtil.getDefaultSubscriber());

    ReactorUtil.sleepSeconds(60);

  }


  private static Flux<Integer> getOrderNumbers(){
    return Flux.range(1,10)
        .delayElements(Duration.ofSeconds(5));
  }

  private static Flux<Integer> fallback(){
    return Flux.range(100,10)
        .delayElements(Duration.ofSeconds(1));
  }
}
