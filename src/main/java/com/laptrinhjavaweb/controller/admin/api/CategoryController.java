package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = "/api/categories")
public class CategoryController extends HttpServlet{
	@Inject
	private ICategoryService iCategoryService;
	// Lấy ra
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Định dạng nhận về
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		List<CategoryModel> categories = iCategoryService.getALl();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), categories);
	}
	// Khởi tạo
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel model = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		
		CategoryModel modelNew = iCategoryService.insertOne(model);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), modelNew);
	}
	
	// Cập nhật 
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	// Xóa
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel model = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		
		int status = iCategoryService.deleteOne(model.getId());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), status);
	}

}
