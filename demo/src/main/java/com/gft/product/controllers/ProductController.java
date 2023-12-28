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

import java.net.URI;
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
        ProductDTO  product = productQueryHandler.getProductById(id);
        if(product == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(product);
    }

    @PostMapping(value = "/new", consumes = "application/json")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductCommand command) {
        int productId = productCommandHandler.createHandle(command);
        String responseBody = "Id: " + productId;

        return ResponseEntity.created(URI.create("/v1/product/" + productId)).body(responseBody);
    }
    @DeleteMapping(value = "/delete" , consumes = "application/json")
    public ResponseEntity<String> deleteProductById(@RequestBody DeleteProductCommand command){
        Integer productId = productCommandHandler.deleteHandle(command);

        if(productId == null)
            return ResponseEntity.notFound().build();

        String responseBody = "Id deletado " + productId;
        return ResponseEntity.ok().body(responseBody);
    }

    @PutMapping(value = "/{id}" , consumes = "application/json")
    public ResponseEntity<String> updateProduct(@PathVariable  Integer id, @RequestBody UpdateProductCommand command){
        command.setId(id);
        productCommandHandler.updateHandle(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ping")
    public String Ping(){
        return "Pong";
    }
}
