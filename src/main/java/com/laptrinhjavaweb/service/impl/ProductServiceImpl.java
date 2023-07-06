package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IProductService;

public class ProductServiceImpl implements IProductService{
	@Inject
	private IProductDAO iProductDAO;

	@Override
	public List<ProductModel> getAll() {
		return iProductDAO.findAll();
	}

	@Override
	public ProductModel insertOne(ProductModel model) {
		model.setIs_activated(true);
		model.setIs_deleted(false);
		return iProductDAO.insertOne(model);
	}

	@Override
	public ProductModel updateOne(ProductModel model) {
		
		if(iProductDAO.findById(model.getId()) == null) {
			return null;
		}
		
		return iProductDAO.updateOne(model);
	}

	@Override
	public ProductModel findById(Integer productId) {
		
		return iProductDAO.findById(productId);
	} 

	@Override
	public void enableById(Integer productId) {
		if(iProductDAO.findById(productId) == null) {
			return;
		}
		iProductDAO.enableById(productId);
	}

	@Override
	public void deleteById(Integer productId) {
		if(iProductDAO.findById(productId) == null) {
			return; 
		} 
		iProductDAO.deleteById(productId);
	}

}
