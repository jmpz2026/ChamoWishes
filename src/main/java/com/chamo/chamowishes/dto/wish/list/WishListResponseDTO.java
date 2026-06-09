package com.chamo.chamowishes.dto.wish.list;

import com.chamo.chamowishes.dto.product.ProductResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WishListResponseDTO {
    private Long userId;
    private List<ProductResponseDTO> products;
}
