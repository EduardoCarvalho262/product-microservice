package com.gft.product.queries.handlers;


import com.gft.product.dto.ProductDTO;
import com.gft.product.model.Product;
import com.gft.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductQueryHandler {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> products = (List<Product>) productRepository.findAll();

        return products.stream()
                .map(product -> new ProductDTO(product.getName(), product.getValue()))
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Integer id){
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product.getName(), product.getValue());
    }
}
