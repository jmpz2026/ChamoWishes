package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishRepository extends JpaRepository<WishEntity,Long> {
    List<WishEntity> findAllByUser_Id(Long userId);
}
