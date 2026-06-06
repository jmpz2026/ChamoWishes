package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.Entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUserEntity,Long> {
}
