package com.example.simplewebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private int prodid;
    private String prodname;
    private int prodprize;

    public Product() {
    }
}
