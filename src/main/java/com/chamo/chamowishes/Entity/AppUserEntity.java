package com.chamo.chamowishes.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rolId")
    private Long rolId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

}
