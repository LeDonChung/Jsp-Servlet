package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constrants.SystemConstrants;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

@WebServlet(urlPatterns = "/admin/categories")
public class CategoryController extends HttpServlet{
	@Inject
	private ICategoryService categoryService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/categories.jsp");

		// get all category
		List<CategoryModel> categories = categoryService.getALl();
		
		
		req.setAttribute(SystemConstrants.TITLE, "Category Manager");
		req.setAttribute(SystemConstrants.CATEGORIES, categories);
		rd.forward(req, resp);
	}

}
