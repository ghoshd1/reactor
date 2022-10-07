package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

  public static void main(String[] args) {

    Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

    Flux<Integer> evenFlux = integerFlux.filter(i->i%2==0);

    integerFlux.subscribe(ReactorUtil.onNext("Sub1"),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

    integerFlux.subscribe(ReactorUtil.onNext("Sub2"),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

    evenFlux.subscribe(ReactorUtil.onNext("Sub3"),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

  }

}
