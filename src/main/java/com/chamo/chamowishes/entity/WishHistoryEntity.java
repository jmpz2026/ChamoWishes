package com.chamo.chamowishes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "wish_history")
public class WishHistoryEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long user;

    @Column(name = "productId")
    private Long productId;
}
