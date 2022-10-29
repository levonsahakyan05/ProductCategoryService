package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.dto.UpdateProductDto;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping()
    public List<ProductResponseDto> getAllProducts() {
        return productMapper.map(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable("id") int id) {
        Optional<Product> byId = productService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        ProductResponseDto map = productMapper.map(byId.get());
        return ResponseEntity.ok(map);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateProductDto createProductDto) {
        Product map = productMapper.map(createProductDto);
        productService.save(map);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.map(map));
    }

    @GetMapping("/byCategory/{categoryId}")
    public List<ProductResponseDto> getAllByCategory(@PathVariable("categoryId") int categoryId) {
        return productMapper.map(productService.findAllByCategoryId(categoryId));
    }

    @PutMapping()
    public ResponseEntity<UpdateProductDto> update(@RequestBody UpdateProductDto updateProductDto) {
        productService.save(productMapper.map(updateProductDto));
        return ResponseEntity.ok(updateProductDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
