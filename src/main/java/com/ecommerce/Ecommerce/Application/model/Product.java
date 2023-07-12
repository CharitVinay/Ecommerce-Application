package com.ecommerce.Ecommerce.Application.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "category_id", referencedColumnName = "id")
    private Category category;

    private double price;

    private double weight;

    private String description;

    private String imageName;
}
