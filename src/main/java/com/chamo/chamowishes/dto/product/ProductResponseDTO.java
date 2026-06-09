package com.chamo.chamowishes.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Long productId;
    private String name;
    private Float price;
    private Long stock;
}
