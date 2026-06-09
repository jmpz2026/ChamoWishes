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

    @Column(name = "user_id")
    private Long user;

    @Column(name = "product_id")
    private Long productId;
}
