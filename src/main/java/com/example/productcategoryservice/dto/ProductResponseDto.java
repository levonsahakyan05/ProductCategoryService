package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    private int id;
    private String title;
    private int count;
    private int price;

    private Category category;

    private User user;
}
