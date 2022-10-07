package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import java.util.Arrays;
import java.util.List;
import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {

  public static void main(String[] args) {

    Integer a[] = {1,2,3};
    Flux<Integer> integerFlux = Flux.fromArray(a);
    integerFlux.subscribe(ReactorUtil.onNext());


    List<String> stringList = Arrays.asList("a", "b", "c");

    Flux<String> stringFlux = Flux.fromIterable(stringList);
    stringFlux.subscribe(ReactorUtil.onNext());

  }

}
