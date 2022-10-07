package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

  public static void main(String[] args) {


    Flux.range(3,10)
        .subscribe(ReactorUtil.onNext());

    Flux.range(3,10)
        .map(i -> i+"->"+ReactorUtil.faker().name().fullName())
        .subscribe(ReactorUtil.onNext());

  }

}
