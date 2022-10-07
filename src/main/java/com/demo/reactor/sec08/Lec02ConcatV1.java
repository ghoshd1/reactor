package com.demo.reactor.sec08;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec02ConcatV1 {

  public static void main(String[] args) {

    Flux<String> flux1 = Flux.just("a", "b");
    Flux<String> flux2 = Flux.error(new RuntimeException("Error Occurred"));
    Flux<String> flux3 = Flux.just("c", "d","e");

    Flux<String> concat = Flux.concat(flux1, flux2, flux3);
    concat.subscribe(ReactorUtil.getDefaultSubscriber("Sub1"));


        Flux
        .concatDelayError(flux1, flux2, flux3)
        .subscribe(ReactorUtil.getDefaultSubscriber("Sub2"));

  }

}
