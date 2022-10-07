package com.demo.reactor.sec07;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink.OverflowStrategy;
import reactor.core.scheduler.Schedulers;

public class Lec06FluxCreate {

  public static void main(String[] args) {

   // 75%of 16=12
    //Queues
    System.setProperty("reactor.bufferSize.small", "16");

     Flux.create(fluxSink -> {
      for (int i = 1; i <= 500 && !fluxSink.isCancelled(); i++) {
        System.out.println("Publishing "+i);
        fluxSink.next(i);
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      fluxSink.complete();
    }, OverflowStrategy.BUFFER).subscribe(ReactorUtil.getDefaultSubscriber());



    ReactorUtil.sleepSeconds(5);
  }

}
