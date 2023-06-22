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

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

@WebServlet(urlPatterns = "/admin/categories")
public class CategoryController extends HttpServlet{
	@Inject
	private ICategoryService categoryService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/categories.jsp");
		
		String message = (String) req.getParameter("message");
		
		if(message != null) {
			if(message.equals("ADD_SUCCESS")) {
				req.setAttribute("message", "Add category successfully");
			} else if(message.equals("ADD_FAIL")) {
				req.setAttribute("message", "Add category fail");
			}
		}
		 
		req.setAttribute("title", "Category");
		req.setAttribute("pageHeading", "Manager Category");
		List<CategoryModel> categories = categoryService.getALl();
		req.setAttribute("age", 20);
		req.setAttribute("categories", categories);
		rd.forward(req, resp);
	}

}
