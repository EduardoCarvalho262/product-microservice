package com.gft.product.command.handlers;

import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.model.Product;
import com.gft.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandHandler {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Integer handle(CreateProductCommand command){
        Product newProduct = new Product();
        newProduct.setName(command.getName());
        newProduct.setValue(command.getValue());

        productRepository.save(newProduct);

        return newProduct.getId();
    };
}
