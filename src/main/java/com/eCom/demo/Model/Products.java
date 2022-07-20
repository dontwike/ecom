package com.eCom.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "category_id"
    )
    public Category category;

    public double price;

    public double weight;

    public String description;

    public String imageName;
}
