package com.demo.reactor.sec04;

import com.demo.reactor.sec04.helper.Person;
import com.demo.reactor.utility.ReactorUtil;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Lec10Transform {

  public static void main(String[] args) {
    getPerson()
        .transform(applyFilterAndMap()) //reusable logic can be called from here
        .subscribe(ReactorUtil.getDefaultSubscriber());

  }

  private static Flux<Person> getPerson(){
    return  Flux.range(1,10).map(Person::new);
  }

  //reusable logic
  private static Function<Flux<Person>,Flux<Person>> applyFilterAndMap(){
    return personflux ->
        personflux
        .filter(person -> person.getAge()>1)
        .doOnNext(person -> person.setName(person.getName().toUpperCase()))
            .doOnDiscard(Person.class,person -> System.out.println("Not allowing :"+person));

  }
}
