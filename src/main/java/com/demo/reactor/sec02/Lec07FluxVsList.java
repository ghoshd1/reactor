package com.demo.reactor.sec02;

import com.demo.reactor.sec02.helper.NameGenerator;
import com.demo.reactor.utility.ReactorUtil;
import java.util.List;
import reactor.core.publisher.Flux;

public class Lec07FluxVsList {

  public static void main(String[] args) {
    List<String> names = NameGenerator.getNames(5);
    System.out.println(names);

    Flux<String> namesFlux = NameGenerator.getNamesFlux(5);
    namesFlux.subscribe(ReactorUtil.onNext());
  }

}
