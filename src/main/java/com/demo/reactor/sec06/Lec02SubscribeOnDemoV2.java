package com.demo.reactor.sec06;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemoV2 {

  public static void main(String[] args) {
    Flux<Object> objectFlux = Flux.create(fluxSink -> {
          printThreadName("create");
          fluxSink.next(1);
        })
        .subscribeOn(Schedulers.newParallel("ParallelThread"))
        .doFirst(() -> printThreadName("doFirst1 "))
        .doOnNext(o -> printThreadName("doOnNext " + o))
        .subscribeOn(Schedulers.boundedElastic())
        .doFirst(() -> printThreadName("doFirst2 "));

    Runnable r = ()->objectFlux.subscribe(ReactorUtil.getDefaultSubscriber("Deb"));

    for(int i=0;i<2;i++){
      new Thread(r).start();
    }
    ReactorUtil.sleepSeconds(10);
  }

  public static void printThreadName(String message){
    System.out.println(message+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }
}
