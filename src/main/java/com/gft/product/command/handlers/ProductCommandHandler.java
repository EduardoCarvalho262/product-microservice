package com.gft.product.command.handlers;

import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.model.Product;
import com.gft.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class ProductCommandHandler {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ResponseEntity<String> createHandle(CreateProductCommand command){
        Product newProduct = new Product(command.getName(), command.getValue(), command.getRating());
        newProduct.setImage(command.getImage());
        var response = productRepository.save(newProduct);

        String responseBody = "Id: " + response.getId();

        return ResponseEntity.created(URI.create("/v1/product/" + response.getId())).body(responseBody);
    }

    @Transactional
    public ResponseEntity<String> deleteHandle(DeleteProductCommand command){
        Optional<Product> entity = productRepository.findById(command.getId()).isPresent() ? productRepository.findById(command.getId()) : Optional.empty();
        Integer productId =  entity.map(Product::getId).orElse(null);

        if(productId == null)
            return ResponseEntity.notFound().build();

        String responseBody = "Id deletado: " + productId;
        return ResponseEntity.ok().body(responseBody);
    }


    @Transactional
    public ResponseEntity<String> updateHandle(UpdateProductCommand command, Integer id){
        Product newProduct = new Product(id,command.getName(), command.getValue(), command.getRating(), command.getImage());
        var response = productRepository.save(newProduct);

        if (!response.getId().equals(id))
            ResponseEntity.badRequest().body("Id diferente do produto");

        return ResponseEntity.noContent().build();
    }
}
