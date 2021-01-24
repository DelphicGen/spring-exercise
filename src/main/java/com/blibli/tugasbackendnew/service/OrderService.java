package com.blibli.tugasbackendnew.service;


import com.blibli.tugasbackendnew.controller.model.request.InsertOderRequest;
import com.blibli.tugasbackendnew.controller.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    public List<OrderResponse> getOrder();
    public OrderResponse getOrderById(int id);
    public OrderResponse postOrder(InsertOderRequest orderRequest);
    public List<OrderResponse> getSortedOrder(String by);
}
