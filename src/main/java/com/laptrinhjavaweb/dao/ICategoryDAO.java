package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel insertOne(CategoryModel model);
	CategoryModel updateOne(CategoryModel model);
	int deleteOne(int id);
	List<CategoryModel> findAllByName(String name);
}
