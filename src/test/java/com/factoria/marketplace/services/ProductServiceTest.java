package com.factoria.marketplace.services;

import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.repositories.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Mock
    IProductRepository productRepository;

    @Test
    void getAllReturnsAListOfProducts() {
        var productService = new ProductService(productRepository);
        var productList = List.of(new Product(), new Product());
        Mockito.when(productRepository.findAll()).thenReturn(productList);

        var sut = productService.getAll();

        assertThat(sut.size(), equalTo(2));
    }

    @Test
    void createProduct() {
    }
}