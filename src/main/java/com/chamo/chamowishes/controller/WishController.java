package com.chamo.chamowishes.controller;

import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.wish.add.WishAddRequestDTO;
import com.chamo.chamowishes.dto.wish.add.WishAddResponseDTO;
import com.chamo.chamowishes.dto.wish.delete.WishDeleteRequestDTO;
import com.chamo.chamowishes.dto.wish.delete.WishDeleteResponseDTO;
import com.chamo.chamowishes.dto.wish.list.WishListRequestDTO;
import com.chamo.chamowishes.dto.wish.list.WishListResponseDTO;
import com.chamo.chamowishes.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/wish")
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<WishAddResponseDTO>> addProductWish(@RequestBody WishAddRequestDTO wishAddRequestDTO) {
        ApiResponseDTO<WishAddResponseDTO> apiResponseDTO = wishService.addProductWish(wishAddRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDTO<WishDeleteResponseDTO>> deleteProductWish(@RequestBody WishDeleteRequestDTO wishDeleteRequestDTO) {
        ApiResponseDTO<WishDeleteResponseDTO> apiResponseDTO = wishService.deleteProductWish(wishDeleteRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDTO<WishListResponseDTO>> getAllProductWish(@RequestBody WishListRequestDTO wishListRequestDTO) {
        ApiResponseDTO<WishListResponseDTO> apiResponseDTO = wishService.getAllProductWish(wishListRequestDTO);
        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponseDTO);
    }
}
