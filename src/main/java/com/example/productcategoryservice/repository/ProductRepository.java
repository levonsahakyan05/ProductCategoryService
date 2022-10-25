package com.example.productcategoryservice.repository;

import com.example.productcategoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByCategory_Id(int categoryId);
}
