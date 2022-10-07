package com.demo.reactor.sec04.helper;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class OrderService {

  private static Map<String, List<PurchaseOrder>> db = new HashMap<>();

  static {
    List<PurchaseOrder> user1PurchaseOrders = Arrays.asList(
        new PurchaseOrder("user1"), new PurchaseOrder("user1"), new PurchaseOrder("user1")
    );
    List<PurchaseOrder> user2PurchaseOrders = Arrays.asList(
        new PurchaseOrder("user2"), new PurchaseOrder("user2")
    );

    db.put("user1",user1PurchaseOrders);
    db.put("user2",user2PurchaseOrders);
  }

  public static Flux<PurchaseOrder> getPurchaseOrder(String userId){
    return Flux.fromIterable(db.get(userId)).delayElements(Duration.ofSeconds(1));
  }
  public static Flux<PurchaseOrder> getPurchaseOrderRevised(String userId){
    return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
      db.get(userId).forEach(purchaseOrder->purchaseOrderFluxSink.next(purchaseOrder));
      purchaseOrderFluxSink.complete();
    })
        .delayElements(Duration.ofSeconds(1));
  }
}
