package com.gft.product.controllers;

import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.dto.ProductDTO;
import com.gft.product.queries.handlers.ProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductCommandHandler productCommandHandler;

    @Autowired
    private ProductQueryHandler productQueryHandler;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productQueryHandler.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return productQueryHandler.getProductById(id);
    }

    @PostMapping(value = "/new", consumes = "application/json")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductCommand command) {
        return productCommandHandler.createHandle(command);
    }

    @DeleteMapping(value = "/delete" , consumes = "application/json")
    public ResponseEntity<String> deleteProductById(@RequestBody DeleteProductCommand command){
       return productCommandHandler.deleteHandle(command);
    }

    @PutMapping(value = "/{id}" , consumes = "application/json")
    public ResponseEntity<String> updateProduct(@PathVariable  Integer id, @RequestBody UpdateProductCommand command){
        return productCommandHandler.updateHandle(command, id);
    }
}
