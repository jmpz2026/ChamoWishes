package com.chamo.chamowishes.controller;

import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetRequestDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetResponseDTO;
import com.chamo.chamowishes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<ProductGetResponseDTO>> getProductById(@RequestBody ProductGetRequestDTO productGetRequestDTO) {
        ApiResponseDTO<ProductGetResponseDTO> apiResponseDTO = productService.getProductById(productGetRequestDTO);
        return ResponseEntity.ok(apiResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDTO<List<ProductGetResponseDTO>>> getAllProducts() {
        ApiResponseDTO<List<ProductGetResponseDTO>> apiResponseDTO = productService.getAllProducts();
        return ResponseEntity.ok(apiResponseDTO);
    }
}
