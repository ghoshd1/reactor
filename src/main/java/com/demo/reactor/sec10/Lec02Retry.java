package com.demo.reactor.sec10;

import com.demo.reactor.utility.ReactorUtil;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.publisher.Flux;

public class Lec02Retry {

  private static AtomicInteger integer = new AtomicInteger(1);
  public static void main(String[] args) {

    getIntegers()
        .retry(2)
        .subscribe(ReactorUtil.getDefaultSubscriber());
  }

  private static Flux<Integer> getIntegers(){
    return Flux.range(1,3)
        .doOnSubscribe(subscription -> System.out.println("Subscribed"))
        .doOnComplete(() -> System.out.println("Completed"))
        .map(i->1/0)
        .doOnError(throwable -> System.out.println("--error"));

  }

}
