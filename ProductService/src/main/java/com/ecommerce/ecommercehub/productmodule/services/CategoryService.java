package com.ecommerce.ecommercehub.productmodule.services;

import java.util.List;

import com.ecommerce.ecommercehub.productmodule.dtos.CategoryDTO;
import com.ecommerce.ecommercehub.productmodule.dtos.CategoryResponseDTO;
import com.ecommerce.ecommercehub.productmodule.entities.Category;

public interface CategoryService {

    CategoryDTO addCategory(Category category);

	CategoryResponseDTO fetchCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	CategoryDTO modifyCategory(Category category, Long categoryId);

	String removeCategory(Long categoryId);

}
