package com.demo.reactor.sec01;

import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

  public static void main(String[] args) {
    Mono<Integer> integerMono = Mono.just(1);
    //integerMono.subscribe();

    integerMono.subscribe(
        item -> System.out.println(item),
        err-> System.out.println(err.getMessage()),
        ()->System.out.println("Completed"));
  }

}
