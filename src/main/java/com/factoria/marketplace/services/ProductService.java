package com.factoria.marketplace.services;

import com.factoria.marketplace.dto.ProductRequestDto;
import com.factoria.marketplace.exceptions.NotFoundException;
import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.models.User;
import com.factoria.marketplace.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductRequestDto productDto, User authUser) {
        var product = new Product();
        product.setName(productDto.getName());
        product.setImg(productDto.getImg());
        product.setPrice(productDto.getPrice());
        product.setSeller(authUser);
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        var opProduct = productRepository.findById(id);
        if (opProduct.isEmpty()) throw new NotFoundException("Product Not Found", "P-153");
        return opProduct.get();
    }

}
