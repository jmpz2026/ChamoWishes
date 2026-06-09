package com.chamo.chamowishes.service;

import com.chamo.chamowishes.constant.MessageConstant;
import com.chamo.chamowishes.dto.product.ProductResponseDTO;
import com.chamo.chamowishes.entity.ProductEntity;
import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetRequestDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetResponseDTO;
import com.chamo.chamowishes.exception.ResourceNotFoundException;
import com.chamo.chamowishes.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ApiResponseDTO<ProductGetResponseDTO> getProductById(ProductGetRequestDTO productGetRequestDTO) {
        ProductEntity productEntity = productRepository.findById(productGetRequestDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND));

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(productEntity.getId());
        productResponseDTO.setName(productEntity.getName());
        productResponseDTO.setPrice(productEntity.getPrice());
        productResponseDTO.setStock(productEntity.getStock());

        ProductGetResponseDTO productGetResponseDTO = new ProductGetResponseDTO();
        productGetResponseDTO.setProductResponseDTO(productResponseDTO);

        ApiResponseDTO<ProductGetResponseDTO> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(productGetResponseDTO);
        apiResponseDTO.setMessage(MessageConstant.PRODUCT_FOUND);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }

    public ApiResponseDTO<List<ProductGetResponseDTO>> getAllProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();

        List<ProductGetResponseDTO> productGetResponseDTOList = new ArrayList<>();

        productEntityList.forEach(productEntity -> {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductId(productEntity.getId());
            productResponseDTO.setName(productEntity.getName());
            productResponseDTO.setPrice(productEntity.getPrice());
            productResponseDTO.setStock(productEntity.getStock());

            ProductGetResponseDTO productGetResponseDTO = new ProductGetResponseDTO();
            productGetResponseDTO.setProductResponseDTO(productResponseDTO);

            productGetResponseDTOList.add(productGetResponseDTO);
        });

        ApiResponseDTO<List<ProductGetResponseDTO>> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(productGetResponseDTOList);
        apiResponseDTO.setMessage(MessageConstant.PRODUCT_FOUND);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }


}
