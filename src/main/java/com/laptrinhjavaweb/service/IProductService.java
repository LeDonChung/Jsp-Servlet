package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface IProductService {
	List<ProductModel> getAll();
	ProductModel insertOne(ProductModel model);
	ProductModel updateOne(ProductModel model);
	ProductModel findById(Integer productId);
	void enableById(Integer productId);
	void deleteById(Integer productId);
}
