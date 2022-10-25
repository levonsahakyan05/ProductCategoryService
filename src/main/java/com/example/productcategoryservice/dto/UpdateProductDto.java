package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductDto {

    private int id;
    private String title;
    private int count;
    private int price;

    private Category category;
}
