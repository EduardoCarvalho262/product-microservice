package com.gft.product.queries.handlers;

import com.gft.product.dto.ProductDTO;
import com.gft.product.model.Product;
import com.gft.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
                .map(product -> new ProductDTO(product.getName(), product.getValue(), product.getRating(), product.getImage()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<ProductDTO> getProductById(Integer id){
        Product product = productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;

        if(product == null)
            return ResponseEntity.notFound().build();

        ProductDTO response = new ProductDTO(product.getName(), product.getValue(), product.getRating(), product.getImage());

        return ResponseEntity.ok(response);
    }
}
