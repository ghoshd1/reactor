package com.demo.reactor.sec01;

import com.demo.reactor.utility.ReactorUtil;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribeError {

  public static void main(String[] args) {
    Mono<Integer> integerMono = Mono.just(1).map(i->i/0);

    integerMono.subscribe(
        System.out::println,
        err-> System.out.println("Error Happened "+err.getMessage()),
        ()->System.out.println("Completed"));

    Mono<Integer> integerMono1 = Mono.just(1).map(i->i/1);

    integerMono1.subscribe(
        ReactorUtil.onNext(),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());
  }

}
