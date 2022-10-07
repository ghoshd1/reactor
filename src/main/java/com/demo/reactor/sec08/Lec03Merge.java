package com.demo.reactor.sec08;

import com.demo.reactor.sec08.helper.AmericanAirlines;
import com.demo.reactor.sec08.helper.Emirates;
import com.demo.reactor.sec08.helper.Qatar;
import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec03Merge {

  public static void main(String[] args) {
    Flux.merge(
        Qatar.getFlights(),
        AmericanAirlines.getFlights(),
        Emirates.getFlights()
    ).subscribe(ReactorUtil.getDefaultSubscriber());


    ReactorUtil.sleepSeconds(10);
  }

}
