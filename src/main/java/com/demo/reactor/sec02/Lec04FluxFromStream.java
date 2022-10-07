package com.demo.reactor.sec02;

import com.demo.reactor.utility.ReactorUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {

  public static void main(String[] args) {


    List<String> stringList = Arrays.asList("a", "b", "c");
    Stream<String> stringStream = stringList.stream();
    Flux<String> stringFlux = Flux.fromStream(stringStream);
    stringFlux.subscribe(ReactorUtil.onNext());
    Flux<String> stringFlux1 = Flux.fromStream(stringStream);
    stringFlux1.subscribe(ReactorUtil.onNext());
    Flux<String> stringFlux2 = Flux.fromStream(() -> stringStream);
    stringFlux2.subscribe(ReactorUtil.onNext());
    Flux<String> stringFlux3 = Flux.fromStream(() -> stringList.stream());
    stringFlux3.subscribe(ReactorUtil.onNext());
  //  stringFlux.subscribe(ReactorUtil.onNext(),ReactorUtil.onError(),ReactorUtil.onComplete());

  }

}
