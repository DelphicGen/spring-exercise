package com.blibli.tugasbackendnew.controller.model.request;

import com.blibli.tugasbackendnew.entity.Customer;
import com.blibli.tugasbackendnew.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InsertOderRequest {
    private List<OrderItem> orderItemList;
    private Customer customer;
}
