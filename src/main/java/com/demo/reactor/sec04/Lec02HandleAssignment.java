package com.demo.reactor.sec04;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

  public static void main(String[] args) {
    Flux.range(1,Integer.MAX_VALUE)
        .map(i-> ReactorUtil.faker().country().name())
        .handle((country, synchronousSink) -> {

          synchronousSink.next(country );//map

          if(country.toLowerCase().equals("canada")) //filter
            synchronousSink.complete();


        }).subscribe(ReactorUtil.getDefaultSubscriber());

    Flux.generate(synchronousSink -> synchronousSink.next(ReactorUtil.faker().country().name()))
        .map(Object::toString)
        .handle((country, synchronousSink) -> {

          synchronousSink.next(country );//map

          if(country.toLowerCase().equals("canada")) //filter
            synchronousSink.complete();


        }).subscribe(ReactorUtil.getDefaultSubscriber());
  }

}
