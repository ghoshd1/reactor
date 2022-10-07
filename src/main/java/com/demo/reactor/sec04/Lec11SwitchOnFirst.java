package com.demo.reactor.sec04;

import com.demo.reactor.sec04.helper.Person;
import com.demo.reactor.utility.ReactorUtil;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Lec11SwitchOnFirst {

  //based on first item pick the route
  public static void main(String[] args) {
    getPerson()
        .switchOnFirst((signal, personFlux) -> {
          if (signal.isOnNext() && signal.get().getAge() > 10) {
            System.out.println("Route1");
            return personFlux;
          } else {
            System.out.println("Route2");
            return applyFilterAndMap().apply(personFlux);
          }
        })
        .subscribe(ReactorUtil.getDefaultSubscriber("Deb"));

  }

  private static Flux<Person> getPerson(){
    return  Flux.range(1,10).map(Person::new);
  }

  //reusable logic
  private static Function<Flux<Person>,Flux<Person>> applyFilterAndMap(){
    return personflux ->
        personflux
        .filter(person -> person.getAge()>4)
        .doOnNext(person -> person.setName(person.getName().toUpperCase()))
            .doOnDiscard(Person.class,person -> System.out.println("Not allowing :"+person));

  }
}
