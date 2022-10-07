package com.demo.reactor.sec09;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec04Window {

  static  AtomicInteger counter = new AtomicInteger(1);
  public static void main(String[] args) {

    eventStream()
        .window(5)
        .flatMap(stringFlux -> saveEvents(stringFlux))
        .subscribe(ReactorUtil.getDefaultSubscriber());

    ReactorUtil.sleepSeconds(100);
  }


  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(300))
        .handle((aLong, synchronousSink) -> {
          if(aLong>1000)
            synchronousSink.complete();
          else
            synchronousSink.next(aLong);
        })
        .map(i -> "event" + i);
  }

  private static Mono<Integer> saveEvents(Flux<String> event){
    return event.doOnNext(s -> {
      System.out.println("Saving event"+s);
    })
        .doOnComplete(() -> {
          System.out.println("Completed processing batch");
          System.out.println("---------------------------");
        })
        .then(Mono.just(counter.getAndIncrement()));

  }

}
