package com.demo.reactor.sec07;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

public class Lec02BackpressureDrop {

  public static void main(String[] args) {

   // 75%of 16=12
    //Queues
    System.setProperty("reactor.bufferSize.small", "16");
    Flux<Object> objectFlux = Flux.create(fluxSink -> {
      for (int i = 1; i <= 500; i++) {
        System.out.println("Publishing "+i);
        fluxSink.next(i);
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      fluxSink.complete();
    });

    objectFlux
        .onBackpressureDrop()
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(o -> {
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        })
        .subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));

    ReactorUtil.sleepSeconds(10);
  }

}
