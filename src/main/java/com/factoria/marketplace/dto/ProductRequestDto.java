package com.factoria.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequestDto {
    private String name;
    private String img;
    private Double price;
}
