package com.example.productcatalogservice.TableInheritenceExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class Ta extends User {
    private Double rating;
}
