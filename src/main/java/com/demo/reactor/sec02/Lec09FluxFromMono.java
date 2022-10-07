package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

  public static void main(String[] args) {

    Mono<Integer> integerMono = Mono.just(1);

    Flux<Integer> integerFlux = Flux.from(integerMono);

    integerFlux.subscribe(ReactorUtil.onNext());


  }

}
