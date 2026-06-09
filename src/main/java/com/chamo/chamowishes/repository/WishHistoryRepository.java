package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.entity.WishHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishHistoryRepository extends JpaRepository<WishHistoryEntity,Long> {
}
