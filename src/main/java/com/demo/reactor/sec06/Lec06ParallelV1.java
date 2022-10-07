package com.demo.reactor.sec06;


import com.demo.reactor.utility.ReactorUtil;
import java.util.ArrayList;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06ParallelV1 {

  public static void main(String[] args) {

    ArrayList<Integer> integerArrayList = new ArrayList<>();
    Flux<Object> objectFlux = Flux.create(fluxSink -> {
          printThreadName("create");
          for (int i = 0; i < 10; i++)
            fluxSink.next(i);
          fluxSink.complete();
        });

    objectFlux
        .parallel(10)
        .runOn(Schedulers.boundedElastic())
        .doOnNext(o -> printThreadName("doOnNext-"+o))
        .sequential()
        .doOnNext(o -> printThreadName("doOnNext1-"+o))
        .subscribe(o -> integerArrayList.add((Integer)o));


    ReactorUtil.sleepSeconds(2);

    System.out.println("Size : "+integerArrayList.size());

  }

  private static void printThreadName(String msg){
    System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
  }
}