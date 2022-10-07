package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec14Assignment {

  public static void main(String[] args) {
    Flux<Integer> range = Flux.range(1, 10);
    range.map(i -> i * 10);
    range.subscribe(System.out::println);

    Flux<Integer> just = Flux.just(1, 2, 3);

    just.subscribe(ReactorUtil.getDefaultSubscriber());
    just.subscribe(ReactorUtil.getDefaultSubscriber());
  }

}
