package com.chamo.chamowishes.service;

import com.chamo.chamowishes.constant.MessageConstant;
import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.product.ProductResponseDTO;
import com.chamo.chamowishes.dto.wish.add.WishAddRequestDTO;
import com.chamo.chamowishes.dto.wish.add.WishAddResponseDTO;
import com.chamo.chamowishes.dto.wish.delete.WishDeleteRequestDTO;
import com.chamo.chamowishes.dto.wish.delete.WishDeleteResponseDTO;
import com.chamo.chamowishes.dto.wish.list.WishListRequestDTO;
import com.chamo.chamowishes.dto.wish.list.WishListResponseDTO;
import com.chamo.chamowishes.entity.AppUserEntity;
import com.chamo.chamowishes.entity.ProductEntity;
import com.chamo.chamowishes.entity.WishEntity;
import com.chamo.chamowishes.entity.WishHistoryEntity;
import com.chamo.chamowishes.exception.ResourceNotFoundException;
import com.chamo.chamowishes.repository.AppUserRepository;
import com.chamo.chamowishes.repository.ProductRepository;
import com.chamo.chamowishes.repository.WishHistoryRepository;
import com.chamo.chamowishes.repository.WishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishService {

    private final WishRepository wishRepository;
    private final WishHistoryRepository wishHistoryRepository;
    private final ProductRepository productRepository;
    private final AppUserRepository appUserRepository;

    public WishService(WishRepository wishRepository, WishHistoryRepository wishHistoryRepository, ProductRepository productRepository, AppUserRepository appUserRepository) {
        this.wishRepository = wishRepository;
        this.wishHistoryRepository = wishHistoryRepository;
        this.productRepository = productRepository;
        this.appUserRepository = appUserRepository;
    }

    public ApiResponseDTO<WishAddResponseDTO> addProductWish(WishAddRequestDTO wishAddRequestDTO) {
        if(!productRepository.existsById(wishAddRequestDTO.getProductId())) {
            throw new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND);
        }

        ProductEntity productEntity = productRepository.findById(wishAddRequestDTO.getProductId())
                .orElseThrow(()  -> new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND));

        AppUserEntity appUserEntity = appUserRepository.findById(wishAddRequestDTO.getUserId())
                .orElseThrow(()  -> new ResourceNotFoundException(MessageConstant.USER_NOT_FOUND));

        WishEntity wishEntity = new WishEntity();
        wishEntity.setUser(appUserEntity);
        wishEntity.setProduct(productEntity);
        wishRepository.save(wishEntity);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(productEntity.getId());
        productResponseDTO.setName(productEntity.getName());
        productResponseDTO.setPrice(productEntity.getPrice());
        productResponseDTO.setStock(productEntity.getStock());

        WishAddResponseDTO wishAddResponseDTO = new WishAddResponseDTO();
        wishAddResponseDTO.setUserId(wishEntity.getUser().getId());
        wishAddResponseDTO.setProductResponseDTO(productResponseDTO);

        WishHistoryEntity wishHistoryEntity = new WishHistoryEntity();
        wishHistoryEntity.setId(wishEntity.getId());
        wishHistoryEntity.setProductId(wishEntity.getProduct().getId());
        wishHistoryEntity.setUser(wishEntity.getUser().getId());
        wishHistoryRepository.save(wishHistoryEntity);

        ApiResponseDTO<WishAddResponseDTO> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(wishAddResponseDTO);
        apiResponseDTO.setMessage(MessageConstant.WISH_ADDED);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }

    public ApiResponseDTO<WishDeleteResponseDTO> deleteProductWish(WishDeleteRequestDTO wishDeleteRequestDTO) {
        WishEntity wishEntity = wishRepository.findById(wishDeleteRequestDTO.getWishId())
                .orElseThrow(() -> new ResourceNotFoundException(MessageConstant.WISH_NOT_FOUND));

        WishDeleteResponseDTO wishDeleteResponseDTO = new WishDeleteResponseDTO();
        wishDeleteResponseDTO.setWishId(wishEntity.getId());

        wishRepository.deleteById(wishDeleteRequestDTO.getWishId());

        ApiResponseDTO<WishDeleteResponseDTO> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(wishDeleteResponseDTO);
        apiResponseDTO.setMessage(MessageConstant.WISH_DELETED);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }

    public ApiResponseDTO<WishListResponseDTO> getAllProductWish(WishListRequestDTO wishListRequestDTO) {
        List<WishEntity> wishEntityList = wishRepository.findAllByUser_Id(wishListRequestDTO.getUserId());

        if(wishEntityList.isEmpty()) {
            throw new ResourceNotFoundException(MessageConstant.WISH_NOT_FOUND);
        }

        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

        wishEntityList.forEach(wishEntity -> {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductId(wishEntity.getProduct().getId());
            productResponseDTO.setName(wishEntity.getProduct().getName());
            productResponseDTO.setPrice(wishEntity.getProduct().getPrice());
            productResponseDTO.setStock(wishEntity.getProduct().getStock());
            if (wishEntity.getProduct().getStock() <= 0){
                productResponseDTO.setAlert(MessageConstant.WISH_PRODUCT_NOT_ENOUGH);
            }
            productResponseDTOList.add(productResponseDTO);
        });

        WishListResponseDTO wishListResponseDTO = new WishListResponseDTO();
        wishListResponseDTO.setUserId(wishListRequestDTO.getUserId());
        wishListResponseDTO.setProducts(productResponseDTOList);

        ApiResponseDTO<WishListResponseDTO> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(wishListResponseDTO);
        apiResponseDTO.setMessage(MessageConstant.WISH_EXISTS);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }
}
