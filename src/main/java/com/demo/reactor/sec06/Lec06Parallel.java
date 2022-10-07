package com.demo.reactor.sec06;


import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {

  public static void main(String[] args) {

    Flux<Object> objectFlux = Flux.create(fluxSink -> {
          printThreadName("create");
          for (int i = 0; i < 10; i++)
            fluxSink.next(i);
          fluxSink.complete();
        });

    objectFlux
        .parallel()
        .runOn(Schedulers.boundedElastic())
        .doOnNext(o -> printThreadName("doOnNext-"+o))
        .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));


    ReactorUtil.sleepSeconds(10);

  }

  private static void printThreadName(String msg){
    System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
  }
}