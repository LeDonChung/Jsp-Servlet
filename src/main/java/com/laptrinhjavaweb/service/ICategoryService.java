package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> getALl();
	CategoryModel insertOne(CategoryModel model);
	int deleteOne(int id);
	List<CategoryModel> getAllByName(String name);
	
}
