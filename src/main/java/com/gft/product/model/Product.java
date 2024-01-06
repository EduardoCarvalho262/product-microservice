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

    @Column(name = "`RATING`")
    private Byte Rating;

    private String Image;

    public Product() {}

    public Product(String name, Double value, Byte rating) {
        Name = name;
        Value = value;
        Rating = rating;
    }

    public Product(Integer id, String name, Double value, Byte rating, String image) {
        Id = id;
        Name = name;
        Value = value;
        Rating = rating;
        Image = image;
    }
}
