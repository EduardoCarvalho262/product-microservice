package com.gft.product.controllers;

import com.gft.product.command.handlers.ProductCommandHandler;
import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.dto.ProductDTO;
import com.gft.product.queries.handlers.ProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductCommandHandler productCommandHandler;

    @Autowired
    private ProductQueryHandler productQueryHandler;

    @PostMapping(value = "/new", consumes = "application/json")
    public Integer createProduct(@RequestBody CreateProductCommand command){
        return productCommandHandler.createHandle(command);
    }

    @GetMapping()
    public List<ProductDTO> getAllProducts(){
        return productQueryHandler.getAllProducts();
    }

    @DeleteMapping(value = "/delete" , consumes = "application/json")
    public Integer deleteProductById(@RequestBody DeleteProductCommand command){
        return productCommandHandler.deleteHandle(command);
    }

    @GetMapping("/ping")
    public String Ping(){
        return "Pong";
    }
}
