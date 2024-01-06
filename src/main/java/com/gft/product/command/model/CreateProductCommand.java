package com.gft.product.command.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductCommand {
    public String Name;
    public Double Value;
    public Byte Rating;
    public String Image;
}
