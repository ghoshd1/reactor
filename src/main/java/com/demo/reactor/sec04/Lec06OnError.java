package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

  public static void main(String[] args) {
    Flux.range(1,10)
        .log()
        .map(i ->i/(5-i))
      //  .onErrorReturn(-1)
    /*    .onErrorResume(throwable -> {
          System.out.println("Error Occurred "+throwable.getMessage());
          return fallback();
          //return Flux.just(-1);
        })*/
        .onErrorContinue((throwable, o) -> {
          System.out.println("Error Occurred "+throwable.getMessage());
          System.out.println("record that caused problem - "+o);
        })
        .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));
  }

  public static Mono<Integer> fallback(){
    return Mono.just(-1);
  }

}

//onErrorReturn -> returns a fallback value and terminates
//onErrorResume -> onErrorResume is same as onErrorReturn only advantage is you get the throwable object which can provide the information related to the error
//                  and you have to return a publisher instead of value
//onErrorContinue -> onErrorContinue will allow you to ignore that error and move ahead with other values