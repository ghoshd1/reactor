package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09MonoFromFlux {

  public static void main(String[] args) {


    Flux<Integer> integerFlux = Flux.range(1,5);

    Mono<Integer> next = integerFlux.filter(i->i>3).next();//convert Flux to Mono
    next.subscribe(ReactorUtil.onNext(),ReactorUtil.onError(),ReactorUtil.onComplete());

    System.out.println("**************");
    integerFlux.next().filter(i->i>3).subscribe(ReactorUtil.onNext(),ReactorUtil.onError(),ReactorUtil.onComplete());

  }

}
