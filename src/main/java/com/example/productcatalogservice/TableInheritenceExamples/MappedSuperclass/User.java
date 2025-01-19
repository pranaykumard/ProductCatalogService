package com.example.productcatalogservice.TableInheritenceExamples.MappedSuperclass;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class User {
    private String email;

    @Id
    private Long id;
}
