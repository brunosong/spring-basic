package com.bruno.springbasic.java_sample1.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
