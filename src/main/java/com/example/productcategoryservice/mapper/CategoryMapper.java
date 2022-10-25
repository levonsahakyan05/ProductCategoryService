package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.*;
import com.example.productcategoryservice.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryResponseDto> map(List<Category> categories);

    CategoryResponseDtoById map(Category category);

    Category map(CreateCategoryDto createCategoryDto);

    Category map(UpdateCategoryDto updateCategoryDto);
}
