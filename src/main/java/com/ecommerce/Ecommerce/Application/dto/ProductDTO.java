package com.ecommerce.Ecommerce.Application.dto;

import com.ecommerce.Ecommerce.Application.model.Category;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private int categoryId;

    private double price;

    private double weight;

    private String description;

    private String imageName;
}
