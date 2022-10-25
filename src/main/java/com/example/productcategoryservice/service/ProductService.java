package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(int id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.get();
    }

    public List<Product> findAllByCategoryId(int id) {
       return productRepository.findAllByCategory_Id(id);

    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
