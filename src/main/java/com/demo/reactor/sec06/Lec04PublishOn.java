package com.demo.reactor.sec06;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {

  public static void main(String[] args) {
    Flux<Object> objectFlux = Flux.create(fluxSink -> {
          printThreadName("create");
          for (int i = 0; i < 10; i++)
            fluxSink.next(i);
          fluxSink.complete();
        })
            .doOnNext(o -> printThreadName("doOnNext1-"+o));

        objectFlux
            .publishOn(Schedulers.boundedElastic())
            .doOnNext(o -> printThreadName("doOnNext2-"+o))
            .publishOn(Schedulers.parallel())
            .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));


    ReactorUtil.sleepSeconds(10);
  }

  public static void printThreadName(String message){
    System.out.println(message+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }
}
