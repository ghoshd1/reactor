package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {

  public static void main(String[] args) {

    getOrderNumbers()
        .filter(i ->i>10)
        .defaultIfEmpty(100)
        .subscribe(ReactorUtil.getDefaultSubscriber());




  }


  private static Flux<Integer> getOrderNumbers(){
    return Flux.range(1,10);
  }

}
