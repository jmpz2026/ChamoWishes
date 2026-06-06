package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.Entity.WishHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishHistoryRepository extends JpaRepository<WishHistoryEntity,Long> {
}
