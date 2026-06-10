package com.chamo.chamowishes.controller;

import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetRequestDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetResponseDTO;
import com.chamo.chamowishes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<ProductGetResponseDTO>> getProductById(@RequestParam Long productId) {
        ApiResponseDTO<ProductGetResponseDTO> apiResponseDTO = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDTO<List<ProductGetResponseDTO>>> getAllProducts() {
        ApiResponseDTO<List<ProductGetResponseDTO>> apiResponseDTO = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponseDTO);
    }
}
