package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.*;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<CategoryResponseDto> getAll() {
        return categoryMapper.map(categoryService.findAll());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseDtoById> getById(@PathVariable("id") int id) {
       CategoryResponseDtoById  map = categoryMapper.map(categoryService.findById(id));
        return ResponseEntity.ok(map);

    }

    @PostMapping("/categories")
    public ResponseEntity<CreateCategoryDto> create(@RequestBody CreateCategoryDto createCategoryDto) {
        categoryService.save(categoryMapper.map(createCategoryDto));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/categories")
    public ResponseEntity<UpdateCategoryDto> update(@RequestBody UpdateCategoryDto updateCategoryDto) {
        categoryService.save(categoryMapper.map(updateCategoryDto));
        return ResponseEntity.ok(updateCategoryDto);

    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<DeleteCategoryDto> delete(@PathVariable("id") int id){
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
