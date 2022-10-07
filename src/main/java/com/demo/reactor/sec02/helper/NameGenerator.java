package com.demo.reactor.sec02.helper;

import com.demo.reactor.utility.ReactorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class NameGenerator {

  public static List<String> getNames(int count) {
    List<String> nameList = new ArrayList<>(count);
    for (int i = 1; i <= count; i++) {
      nameList.add(getName());
    }
    return nameList;
  }


  public static Flux<String> getNamesFlux(int count) {
    return Flux.range(1,count).map(NameGenerator::getName);

  }

  private static String getName(int i) {
    ReactorUtil.sleepSeconds(1);
    return ReactorUtil.faker().name().fullName();
  }
  private static String getName() {
    ReactorUtil.sleepSeconds(1);
    return ReactorUtil.faker().name().fullName();
  }

}
