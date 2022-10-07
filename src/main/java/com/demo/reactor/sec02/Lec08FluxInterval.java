package com.demo.reactor.sec02;

import com.demo.reactor.sec02.helper.NameGenerator;
import com.demo.reactor.utility.ReactorUtil;
import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec08FluxInterval {

  public static void main(String[] args) {
   Flux.interval(Duration.ofSeconds(1))
       .subscribe(ReactorUtil.onNext(),ReactorUtil.onError(),ReactorUtil.onComplete());

    ReactorUtil.sleepSeconds(10);
  }

}
