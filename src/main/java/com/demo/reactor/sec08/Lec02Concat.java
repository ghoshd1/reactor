package com.demo.reactor.sec08;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec02Concat {

  public static void main(String[] args) {

    Flux<String> flux1 = Flux.just("a", "b");
    Flux<String> flux2 = Flux.just("c", "d","e");

    Flux<String> stringFlux = flux1.concatWith(flux2);

    Flux<String> concat = Flux.concat(flux1, flux2);

    stringFlux.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));

    concat.subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));
  }

}
