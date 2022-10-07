package com.demo.reactor.sec04.helper;

import com.demo.reactor.utility.ReactorUtil;
import lombok.Data;

@Data
public class PurchaseOrder {

  private String item;
  private String price;
  private String userId;

  public PurchaseOrder(String userId){
    this.userId=userId;
    this.price= ReactorUtil.faker().commerce().price();
    this.item=ReactorUtil.faker().commerce().productName();
  }

}
