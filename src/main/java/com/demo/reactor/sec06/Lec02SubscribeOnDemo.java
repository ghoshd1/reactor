package com.demo.reactor.sec06;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {

  public static void main(String[] args) {
    Flux.create(fluxSink -> {
          printThreadName("create");
          fluxSink.next(1);
        })
        .doFirst(()->printThreadName("doFirst1 "))
        .doOnNext(o -> printThreadName("doOnNext "+o))
        .subscribeOn(Schedulers.boundedElastic())
        .doFirst(()->printThreadName("doFirst2 "))
        .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));

    ReactorUtil.sleepSeconds(10);
  }

  public static void printThreadName(String message){
    System.out.println(message+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }
}
