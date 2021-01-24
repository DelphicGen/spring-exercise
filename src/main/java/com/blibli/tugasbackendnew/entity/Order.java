package com.blibli.tugasbackendnew.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    private List<OrderItem> orderItemList;
    private double totalPrice;
    private Customer customer;
    private int orderId;
}