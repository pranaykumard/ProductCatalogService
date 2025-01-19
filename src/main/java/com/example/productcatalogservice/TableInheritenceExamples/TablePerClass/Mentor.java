package com.example.productcatalogservice.TableInheritenceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User{
    private Long hours;
}
