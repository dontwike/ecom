package com.eCom.demo.Dto;

import lombok.Data;

@Data
public class productDto {

    private Long id;

    private String name;

    private int categoryId;

    private double price;

    private double weight;

    private String description;

    private String imageName;
}
