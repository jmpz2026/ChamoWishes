package com.chamo.chamowishes.repository;

import com.chamo.chamowishes.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity,Long> {
    Optional<AppUserEntity> findByName(String name);

    boolean existsByName(String name);
}
