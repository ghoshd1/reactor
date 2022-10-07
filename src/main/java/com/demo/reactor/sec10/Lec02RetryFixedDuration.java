package com.demo.reactor.sec10;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class Lec02RetryFixedDuration {

  private static AtomicInteger integer = new AtomicInteger(1);
  public static void main(String[] args) {

    getIntegers()
        .map(i->1/0)
        .retryWhen(Retry.fixedDelay(2,Duration.ofSeconds(2)))
        .onErrorContinue((throwable, o) ->  {
          System.out.println("Element dropped"+o);
          if(o.equals(2))
           throw Exceptions.propagate(throwable);
        })
        .subscribe(ReactorUtil.getDefaultSubscriber());

    ReactorUtil.sleepSeconds(10);
  }

  private static Flux<Integer> getIntegers(){
    return Flux.range(1,3)
        .doOnSubscribe(subscription -> System.out.println("Subscribed"))
        .doOnComplete(() -> System.out.println("Completed"))
        .doOnNext(integer1 -> System.out.println("Element emitted-"+integer1))
        .doOnError(throwable -> System.out.println("--error"));

  }

}
