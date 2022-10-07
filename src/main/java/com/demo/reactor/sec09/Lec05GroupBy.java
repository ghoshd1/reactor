package com.demo.reactor.sec09;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

public class Lec05GroupBy {


  public static void main(String[] args) {

    Flux.range(1,100)
        .delayElements(Duration.ofSeconds(1))
        .groupBy(i ->i%2)
        .subscribe(gf -> process(gf,gf.key()));

    ReactorUtil.sleepSeconds(100);
  }


  private static void process(Flux<Integer> flux,Integer key){
    System.out.println("called");
    flux.subscribe(value -> {
      System.out.println("key:"+key+" value :"+value);
    });
  }


}
