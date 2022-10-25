package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.dto.UpdateProductDto;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductResponseDto> map(List<Product> products);

    ProductResponseDto map(Product product);

    Product map(CreateProductDto createProductDto);

    Product map(UpdateProductDto updateProductDto);
}
