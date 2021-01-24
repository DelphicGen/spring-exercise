package com.blibli.tugasbackendnew.controller.model.response;

import com.blibli.tugasbackendnew.entity.Customer;
import com.blibli.tugasbackendnew.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private List<OrderItem> orderItemList;
    private double totalPrice;
    private Customer customer;
    private int orderId;



}
