package com.demo.reactor.sec08;

import com.demo.reactor.sec08.helper.AmericanAirlines;
import com.demo.reactor.sec08.helper.Emirates;
import com.demo.reactor.sec08.helper.Qatar;
import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec04Zip {

  public static void main(String[] args) {

    Flux.zip(getBody(), getEngine(), getTires())
        .subscribe(ReactorUtil.getDefaultSubscriber());
  }

  private static Flux<String> getBody(){
    return Flux.range(1, 5)
        .map(i -> "body");
  }

  private static Flux<String> getEngine(){
    return Flux.range(1, 3)
        .map(i -> "engine");
  }

  private static Flux<String> getTires(){
    return Flux.range(1, 6)
        .map(i -> "tires");
  }

}
