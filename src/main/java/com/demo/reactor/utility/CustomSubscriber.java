package com.demo.reactor.utility;


import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubscriber implements Subscriber<Object> {

private String name ="";

  CustomSubscriber(){}

  CustomSubscriber(String name){
  this.name=name;
  }
  AtomicReference<Subscription> atomicReference = new AtomicReference<>();



  @Override
  public void onSubscribe(Subscription subscription) {
    System.out.println(name+" Received Subscription "+subscription);
    atomicReference.set(subscription);
    subscription.request(Integer.MAX_VALUE);
  }

  @Override
  public void onNext(Object item) {
    System.out.println(name+"-onNext - "+item+"\t\t[Thread Name-"+Thread.currentThread().getName()+"]");
  }

  @Override
  public void onError(Throwable throwable) {
    System.out.println(name+"-onError - "+throwable.getMessage());
    atomicReference.get().cancel();
  }

  @Override
  public void onComplete() {
    System.out.println(name+"-onComplete");
    atomicReference.get().cancel();
  }
}
