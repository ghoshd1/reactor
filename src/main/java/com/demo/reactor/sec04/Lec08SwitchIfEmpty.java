package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec08SwitchIfEmpty {

  public static void main(String[] args) {

    getOrderNumbers()
        .filter(i ->i>10)
        .switchIfEmpty(fallback())
        .subscribe(ReactorUtil.getDefaultSubscriber());




  }


  //redisCache
  private static Flux<Integer> getOrderNumbers(){
    return Flux.range(1,10);
  }

  //DB
  private static Flux<Integer> fallback(){
    return Flux.range(100,5);
  }

}
