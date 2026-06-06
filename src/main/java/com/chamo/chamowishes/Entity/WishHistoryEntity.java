package com.chamo.chamowishes.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wish_history")
public class WishHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "productId")
    private Long productId;
}
