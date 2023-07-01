package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface IProductDAO {
	List<ProductModel> findAll();
	ProductModel insertOne(ProductModel model);
	ProductModel updateOne(ProductModel model);
	ProductModel findById(Integer productId);
	void enableById(Integer productId);
	void deleteById(Integer productId);
}
