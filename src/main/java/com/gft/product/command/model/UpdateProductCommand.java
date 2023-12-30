package com.gft.product.command.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductCommand {
    public Integer Id;
    public String Name;
    public Double Value;
    public Byte Rating;
}
