package com.demo.reactor.sec06;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03SubscribeOnMultipleItems {

  public static void main(String[] args) {
    Flux<Object> objectFlux = Flux.create(fluxSink -> {
          printThreadName("create");
          for (int i = 0; i < 40; i++)
            fluxSink.next(i);
          fluxSink.complete();
        });
      //  .subscribeOn(Schedulers.boundedElastic());
    //   .doOnNext(o -> printThreadName("doOnNext-"+o))
        objectFlux
            .subscribeOn(Schedulers.boundedElastic())
            .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
    objectFlux
        .subscribeOn(Schedulers.parallel())
        .subscribe(ReactorUtil.getDefaultSubscriber("mike"));

    ReactorUtil.sleepSeconds(10);
  }

  public static void printThreadName(String message){
    System.out.println(message+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }
}
