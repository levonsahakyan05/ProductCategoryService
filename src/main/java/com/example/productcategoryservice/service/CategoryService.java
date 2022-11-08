package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        if (category == null) {
            throw new RuntimeException("Category can't be null");
        }
        categoryRepository.save(category);
    }

    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);

    }

    public void deleteById(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("id can't be 0");
        }
        categoryRepository.deleteById(id);
    }
}
