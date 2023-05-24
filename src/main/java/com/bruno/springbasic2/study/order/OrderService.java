package com.bruno.springbasic2.study.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
