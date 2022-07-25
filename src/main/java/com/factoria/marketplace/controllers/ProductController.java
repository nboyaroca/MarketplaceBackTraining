package com.factoria.marketplace.controllers;

import com.factoria.marketplace.dto.ProductRequestDto;
import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.models.User;
import com.factoria.marketplace.services.IProductService;
import com.factoria.marketplace.services.IUserService;
import com.factoria.marketplace.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    private IProductService productService;
    private IUserService userService;

    // CONSTRUCTOR (AMB GENERATE)
    public ProductController(IProductService productService, IUserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/products")
    List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getById(@PathVariable Long id) {
        var product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
        
    }
    @PostMapping("/products")
    Product createProduct (@RequestBody ProductRequestDto productRequest) {
        var authUser = getAuthUser();
        return productService.createProduct(productRequest, authUser);
    }

    private User getAuthUser() {
        return userService.getById(1L);
    }

}
