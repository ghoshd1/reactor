package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import reactor.core.publisher.Flux;

public class Lec05FluxRangeLog {

  public static void main(String[] args) {
    Flux.range(3,10)
        .log()
        .map(i -> i+"->"+ReactorUtil.faker().name().fullName())
        .log()
        .subscribe(ReactorUtil.onNext());

  }

}
