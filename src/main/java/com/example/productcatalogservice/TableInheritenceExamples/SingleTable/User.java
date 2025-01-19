package com.example.productcatalogservice.TableInheritenceExamples.SingleTable;

import jakarta.persistence.*;

@Entity(name="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",discriminatorType=DiscriminatorType.INTEGER)
public class User {
    private String email;

    @Id
    private Long id;

    private String phoneNumber;
}
