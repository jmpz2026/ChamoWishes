package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
