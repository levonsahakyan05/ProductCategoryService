package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.DeleteProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.dto.UpdateProductDto;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(){
       return productMapper.map(productService.findAll());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable("id") int id){
        ProductResponseDto map = productMapper.map(productService.findById(id));
        return ResponseEntity.ok(map);
    }
    @PostMapping("/products")
    public ResponseEntity<CreateProductDto> create(@RequestBody CreateProductDto createProductDto){
        productService.save(productMapper.map(createProductDto));
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/products/byCategory/{categoryId}")
    public List<ProductResponseDto> getAllByCategory(@PathVariable("categoryId") int categoryId){
            return productMapper.map(productService.findAllByCategoryId(categoryId));
    }
    @PutMapping("/products")
    public ResponseEntity<UpdateProductDto> update(@RequestBody UpdateProductDto updateProductDto){
        productService.save(productMapper.map(updateProductDto));
        return ResponseEntity.ok(updateProductDto);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<DeleteProductDto> delete(@PathVariable("id") int id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
