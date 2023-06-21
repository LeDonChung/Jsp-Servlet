package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	@Inject
	private ICategoryDAO iCategoryDAO;

	@Override
	public List<CategoryModel> getALl() {
		// TODO Auto-generated method stub
		return iCategoryDAO.findAll();
	}

	@Override
	public CategoryModel insertOne(CategoryModel model) {
		// TODO Auto-generated method stub
		return iCategoryDAO.insertOne(model);
	}

	@Override
	public int deleteOne(int id) {
		return iCategoryDAO.deleteOne(id);
	}

	@Override
	public List<CategoryModel> getAllByName(String name) {
		return iCategoryDAO.findAllByName(name);
	}
	
	
	
}
