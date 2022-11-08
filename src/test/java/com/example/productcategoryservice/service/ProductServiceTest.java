package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Test
    void findAll() {
        List<Product> products = Arrays.asList(
                new Product(1,"title1",5,65,new Category(),new User()),
                new Product(2,"title2",5,665,new Category(),new User())
        );
        when(productRepository.findAll()).thenReturn(products);
        productService.findAll();
        verify(productRepository,times(1)).findAll();

    }

    @Test
    void save() {
        Product product = Product.builder()
                .id(1)
                .title("Tilte1")
                .count(5)
                .price(55)
                .category(new Category())
                .user(new User())
                .build();
        when(productRepository.save(any())).thenReturn(product);
        productService.save(Product.builder()
                .title("Tilte1")
                .count(5)
                .price(55)
                .category(new Category())
                .user(new User())
                .build());
        verify(productRepository,times(1)).save(any());
    }
 @Test
    void saveNull() {
        Product product = Product.builder()
                .id(1)
                .title("Tilte1")
                .count(5)
                .price(55)
                .category(new Category())
                .user(new User())
                .build();
        when(productRepository.save(any())).thenReturn(product);
        assertThrows(RuntimeException.class,()->{
            productService.save(null);
        });
        verify(productRepository,times(0)).save(any());
    }

    @Test
    void findById() {
        Product product = Product.builder()
                .id(1)
                .build();
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        productService.findById(product.getId());
        verify(productRepository,times(1)).findById(any());
    }

    @Test
    void findAllByCategoryId() {
        Product product = new Product(1, "title1", 5, 65, new Category(1,"asdf1"), new User());
        Product product1 = new Product(2, "title2", 5, 65, new Category(1,"asdf1"), new User());
        when(productRepository.findAllByCategory_Id(anyInt())).thenReturn(List.of(product,product1));
        productService.findAllByCategoryId(product.getCategory().getId());
        verify(productRepository,times(1)).findAllByCategory_Id(anyInt());
    }

    @Test
    void deleteById() {
        Product product = Product.builder()
                .id(3)
                .build();
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        productService.deleteById(product.getId());
        verify(productRepository,times(1)).deleteById(any());
    }
    @Test
    void deleteById0() {
        Product product = Product.builder()
                .id(0)
                .build();
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        assertThrows(IllegalArgumentException.class,() ->{
            productService.deleteById(product.getId());
        });
        verify(productRepository,times(0)).deleteById(any());
    }
}