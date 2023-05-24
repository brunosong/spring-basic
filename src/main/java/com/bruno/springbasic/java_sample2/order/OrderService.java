package com.bruno.springbasic.java_sample2.order;

import com.bruno.springbasic.java_sample1.order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
