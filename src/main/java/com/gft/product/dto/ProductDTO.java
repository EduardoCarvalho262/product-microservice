package com.gft.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    public String name;
    public Double value;


    public ProductDTO() {
    }

    public ProductDTO(String name, Double value) {
        this.name = name;
        this.value = value;
    }
}
