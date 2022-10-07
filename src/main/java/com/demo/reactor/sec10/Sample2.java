package com.demo.reactor.sec10;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//
public class Sample2 {

  public static void main(String[] args) {
    Flux<Integer> just = Flux.just(1, 2, 3, 4).delayElements(Duration.ofSeconds(2));
just=Flux.error(new RuntimeException("dummy"));
    just
        .then(Mono.just(10))
       // .switchIfEmpty(Mono.just(11))
//        .flatMap(integer -> {
//          System.out.println(integer);
//          return Mono.just(12);
//        })
        .subscribe(ReactorUtil.getDefaultSubscriber());

    ReactorUtil.sleepSeconds(10);
  }

}
