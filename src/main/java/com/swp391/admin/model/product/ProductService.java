package com.swp391.admin.model.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getListProduct() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getListLowrateProduct() {
        return productRepository.getListLowrateProduct();
    }

}
