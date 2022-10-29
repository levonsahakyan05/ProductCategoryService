package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.dto.UpdateCategoryDto;
import com.example.productcategoryservice.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryResponseDto> map(List<Category> categories);

    CategoryResponseDto map(Category category);

    Category map(CreateCategoryDto createCategoryDto);

    Category map(UpdateCategoryDto updateCategoryDto);
}
