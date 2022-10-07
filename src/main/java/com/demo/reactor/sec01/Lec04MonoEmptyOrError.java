package com.demo.reactor.sec01;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

  public static void main(String[] args) {


    userRepository(1).subscribe( ReactorUtil.onNext(),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

    userRepository(2).subscribe( ReactorUtil.onNext(),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

    userRepository(3).subscribe( ReactorUtil.onNext(),
        ReactorUtil.onError(),
        ReactorUtil.onComplete());

  }

  public static Mono<String> userRepository(int userId){
    System.out.println("#################");
    if(userId==1){
      return Mono.just(ReactorUtil.faker().name().fullName());
    } else if (userId==2) {
      return Mono.error(() -> new RuntimeException("Invalid UserId"));
    }else {
      return Mono.empty();
    }
  }
}
