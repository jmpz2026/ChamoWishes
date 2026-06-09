package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity,Long> {
}
