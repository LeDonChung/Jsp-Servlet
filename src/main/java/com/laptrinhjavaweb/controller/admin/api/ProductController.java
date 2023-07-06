package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = "/api/products")
public class ProductController extends HttpServlet{
	@Inject
	private IProductService iProductService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String idParam = req.getParameter("id");
		if(idParam != null) {
			mapper.writeValue(resp.getOutputStream(), iProductService.findById(Integer.valueOf(idParam)));
			
		} else {
			mapper.writeValue(resp.getOutputStream(), iProductService.getAll());
		}
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		ProductModel model = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		
		model = iProductService.insertOne(model);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), model);
		super.doPost(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String paramEnable = req.getParameter("enable");
		String paramDisable = req.getParameter("disable");
		ProductModel model = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		ObjectMapper mapper = new ObjectMapper();
		if(paramEnable != null) {
			// enable
			iProductService.enableById(model.getId());
			mapper.writeValue(resp.getOutputStream(), "Enable successfully");
		} else if(paramDisable != null) {
			// disable
			iProductService.deleteById(model.getId());
			mapper.writeValue(resp.getOutputStream(), "Deleted successfully");
		} else {
			// update 
			model = iProductService.updateOne(model);
			mapper.writeValue(resp.getOutputStream(), "Update successfully");
		}
		
		
		
	}

}
