package com.demo.reactor.sec04;

import com.demo.reactor.sec04.helper.OrderService;
import com.demo.reactor.sec04.helper.Person;
import com.demo.reactor.sec04.helper.PurchaseOrder;
import com.demo.reactor.sec04.helper.User;
import com.demo.reactor.sec04.helper.UserService;
import com.demo.reactor.utility.ReactorUtil;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Lec12FlatMap {

  public static void main(String[] args) {

    Flux<User> users = UserService.getUsers();

//    Flux<Flux<PurchaseOrder>> map = users.map(
//        user -> OrderService.getPurchaseOrder(user.getUserId()));

    Flux<PurchaseOrder> purchaseOrderFlux = users.flatMap(
        user -> OrderService.getPurchaseOrder(user.getUserId()));

    purchaseOrderFlux.subscribe(ReactorUtil.getDefaultSubscriber());
    ReactorUtil.sleepSeconds(10);
  }
}
