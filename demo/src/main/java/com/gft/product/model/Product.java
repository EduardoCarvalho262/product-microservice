package com.gft.product.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;

    @Column(name = "`VALUE`")
    private Double Value;

    public Product() {}

    public Product(String name, Double value) {
        Name = name;
        Value = value;
    }
}
