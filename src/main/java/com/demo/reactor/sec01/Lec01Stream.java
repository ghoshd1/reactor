package com.demo.reactor.sec01;

import java.util.stream.Stream;

public class Lec01Stream {

  //Stream Lazy behaviour
  public static void main(String[] args) {
    Stream<Integer> integerStream = Stream.of(1).map(i -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return i*2;
    });

   // System.out.println(integerStream);

    integerStream.forEach(System.out::println);
  }

}
