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
        if (product == null){
            throw new RuntimeException("Product can't be null");
        }
        productRepository.save(product);
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);

    }

    public void deleteById(int id) {
        if (id == 0){
            throw  new IllegalArgumentException("id can't be 0");
        }
        productRepository.deleteById(id);
    }
}
