package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.*;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryEndpoint {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping()
    public List<CategoryResponseDto> getAll() {
        return categoryMapper.map(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getById(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        CategoryResponseDto map = categoryMapper.map(byId.get());
        return ResponseEntity.ok(map);

    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody CreateCategoryDto createCategoryDto) {
        Category map = categoryMapper.map(createCategoryDto);
        categoryService.save(map);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.map(map));
    }

    @PutMapping()
    public ResponseEntity<UpdateCategoryDto> update(@RequestBody UpdateCategoryDto updateCategoryDto) {
        categoryService.save(categoryMapper.map(updateCategoryDto));
        return ResponseEntity.ok(updateCategoryDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
