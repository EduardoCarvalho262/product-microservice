package com.gft.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    public String name;
    public Double value;
    public Byte rating;
    public String image;


    public ProductDTO() {
    }

    public ProductDTO(String name, Double value, Byte rating, String image) {
        this.name = name;
        this.value = value;
        this.rating = rating;
        this.image = image;
    }
}
