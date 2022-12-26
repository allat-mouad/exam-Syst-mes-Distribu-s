package com.example.communapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder public class CreateProductDTO {
    private String name;
    private double price;
    private int quantity;
    private String catDescription;
    private String catName;

}
