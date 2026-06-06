package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.Entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<WishEntity,Long> {
}
