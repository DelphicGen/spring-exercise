package com.blibli.tugasbackendnew.controller.model.response;

import com.blibli.tugasbackendnew.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllOrdersResponse {
    private List<OrderResponse> ordersList;
    private Integer totalOrder;
    private Double allPrice;
}
