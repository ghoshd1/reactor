package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

  public static void main(String[] args) {

    Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

    integerFlux.subscribe(ReactorUtil.onNext(),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

    Flux<Object> objectFlux = Flux.just(1, 2, 3, 4,"a",ReactorUtil.faker().name().fullName());

    objectFlux.subscribe(ReactorUtil.onNext(),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());
  }

}
