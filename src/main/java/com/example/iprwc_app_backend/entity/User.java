package com.example.iprwc_app_backend.entity;

import com.example.iprwc_app_backend.entity.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private UserRole role;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    public String getName() {
        return name;
    }
}
