package com.blibli.tugasbackendnew.service.impl;

import com.blibli.tugasbackendnew.controller.model.request.InsertOderRequest;
import com.blibli.tugasbackendnew.controller.model.response.AllOrdersResponse;
import com.blibli.tugasbackendnew.controller.model.response.OrderResponse;
import com.blibli.tugasbackendnew.entity.OrderItem;
import com.blibli.tugasbackendnew.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private int orderId = 0;
    private int orderItemId = 0;
    ArrayList<OrderResponse> listOfOrder = new ArrayList<>();

    @Override
    public AllOrdersResponse getOrder() {
//        return banyaknya order dan total semua price untuk soal no 2
        double total = 0;
        for(OrderResponse order : listOfOrder) {
            total += order.getTotalPrice();
        }
        AllOrdersResponse allOrdersResponse = AllOrdersResponse.builder().data(listOfOrder).totalOrder(listOfOrder.size()).allPrice(total).build();
        return allOrdersResponse;
    }

    @Override
    public OrderResponse getOrderById(int id) {
        OrderResponse result;
        for(OrderResponse order : listOfOrder) {
            if(order.getOrderId() == id) {
                result = order;
                return result;
            }
        }
        return null;
    }

    @Override
    public OrderResponse postOrder(InsertOderRequest orderRequest) {
        double totalPrice = 0;

        for(OrderItem item : orderRequest.getOrderItemList()) {
            item.setOrderItemId(orderItemId++);
            totalPrice += item.getProductPrice() * item.getProductQuantity();
        }

        OrderResponse newOrder = OrderResponse
                .builder()
                .totalPrice(totalPrice)
                .customer(orderRequest.getCustomer())
                .orderItemList(orderRequest.getOrderItemList())
                .orderId(this.orderId++)
                .build();

        listOfOrder.add(newOrder);

        return newOrder;
    }

    @Override
    public Double numberOfOrder() {
        double total = 0;
        for(OrderResponse order : listOfOrder) {
            total += order.getTotalPrice();
        }
        return total;

//        Maaf mas saya agak lupa maksud poin kedua itu totalPrice dijumlahkan semua atau banyaknya order, kalau mau banyaknya order bisa langsung return listOfOrder.size() mas
//        return listOfOrder.size();
    }

    @Override
    public List<OrderResponse> getSortedOrder(String by) {
        ArrayList<OrderResponse> sortedListOfOrder = new ArrayList<>(listOfOrder);

        if (by == "name") {
            sortedListOfOrder.sort(Comparator.comparing(o -> o.getCustomer().getName()));
        } else {
            sortedListOfOrder.sort((o1, o2) -> (int) (o2.getTotalPrice() - o1.getTotalPrice()));
        }

        return sortedListOfOrder;
    }
}
