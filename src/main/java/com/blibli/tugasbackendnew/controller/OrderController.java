package com.blibli.tugasbackendnew.controller;

import com.blibli.tugasbackendnew.controller.model.request.InsertOderRequest;
import com.blibli.tugasbackendnew.controller.model.response.OrderResponse;
import com.blibli.tugasbackendnew.entity.Order;
import com.blibli.tugasbackendnew.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE) // path
    public List<OrderResponse> getOrder () {
        return orderService.getOrder();
    }

    @GetMapping(value = "/order/{orderId}")
    public OrderResponse getOrderById (
            @PathVariable String orderId
    ) {
        return orderService.getOrderById(Integer.parseInt(orderId));
    }

    @PostMapping(value = "/order") // path
    public OrderResponse postOrder (@RequestBody InsertOderRequest orderRequest) {
        return orderService.postOrder(orderRequest);
    }

    @GetMapping(value = "/order/sortedbyname", produces = MediaType.APPLICATION_JSON_VALUE) // path
    public List<OrderResponse> getOrderSortedByCustomerName () {
        return orderService.getSortedOrder("name");
    }

    @GetMapping(value = "/order/sortedbytotalprice", produces = MediaType.APPLICATION_JSON_VALUE) // path
    public List<OrderResponse> getOrderSortedByTotalPrice () {
        return orderService.getSortedOrder("total price");
    }
}
