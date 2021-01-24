package com.blibli.tugasbackendnew.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class OrderItem {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private int orderItemId;
}

