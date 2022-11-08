package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
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
class CategoryServiceTest {

    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;
    @Test
    void findAll() {
        List<Category> categories = Arrays.asList(
                new Category(1,"catt"),
                new Category(2,"catt2")
        );
        when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> all = categoryService.findAll();
        verify(categoryRepository,times(1)).findAll();
    }

    @Test
    void save() {
        Category category = Category.builder()
                .id(1)
                .name("cat1")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
       categoryService.save(Category.builder()
               .name("cat1")
               .build());

        verify(categoryRepository,times(1)).save(any());
    }
    @Test
    void saveNull() {
        Category category = Category.builder()
                .id(1)
                .name("cat1")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
        assertThrows(RuntimeException.class,() ->{
            categoryService.save(null);
        });
        verify(categoryRepository,times(0)).save(any());
    }

    @Test
    void findById() {
        Category category = Category.builder()
                .id(1)
                .build();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
        categoryService.findById(category.getId());
        verify(categoryRepository,times(1)).findById(any());
    }
    @Test
    void deleteById() {
        Category category = Category.builder()
                .id(1)
                .build();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
        categoryService.deleteById(category.getId());
        verify(categoryRepository,times(1)).deleteById(any());
    }
    @Test
    void deleteById0() {
        Category category = Category.builder()
                .id(0)
                .build();
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
        assertThrows(IllegalArgumentException.class,() ->{
            categoryService.deleteById(category.getId());
        });
        verify(categoryRepository,times(0)).deleteById(any());
    }
}