package com.gft.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    public String name;
    public Double value;
    public Byte rating;
    public String Image;


    public ProductDTO() {
    }

    public ProductDTO(String name, Double value, Byte rating) {
        this.name = name;
        this.value = value;
        this.rating = rating;
    }
}
