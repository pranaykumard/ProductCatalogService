package com.example.productcatalogservice.TableInheritenceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class Ta extends User{
    private Double rating;
}
