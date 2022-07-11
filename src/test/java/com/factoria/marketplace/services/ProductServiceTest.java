package com.factoria.marketplace.services;

import com.factoria.marketplace.dto.ProductRequestDto;
import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.models.User;
import com.factoria.marketplace.repositories.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

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
    void createSavesAProductMappedFromDTO() {
        var productService = new ProductService(productRepository);

        var productRequest = new ProductRequestDto("Product1", "img.jpg", 50.5);
        var seller = new User();
        seller.setId(1L);

        var product = new Product();
        product.setName("Product1");
        product.setImg("img.jpg");
        product.setPrice(50.5);
        product.setId(1L);
        product.setSeller(seller);

        Mockito.when(productRepository.save(any(Product.class))).thenReturn(product);

        var sut = productService.createProduct(productRequest, seller);

        assertThat(sut.getSeller(), equalTo(seller));
    }
}