package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> getAll();
	CategoryModel insertOne(CategoryModel model);
	int deleteOne(int id);
	List<CategoryModel> getAllByName(String name);
	CategoryModel getById(Integer id);
	CategoryModel updateOne(CategoryModel model);
	Integer count();
	List<CategoryModel> findAll(Integer offset, Integer valueOf, String sortBy, String sortName);
}
