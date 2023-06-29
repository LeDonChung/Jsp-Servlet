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
import com.laptrinhjavaweb.utils.MessageUtils;

@WebServlet(urlPatterns = "/admin/categories")
public class CategoryController extends HttpServlet{
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "";
		
		String messageParam = req.getParameter(SystemConstrants.MESSAGE);
		String typeParam = req.getParameter(SystemConstrants.TYPE);
		if(typeParam.equalsIgnoreCase(SystemConstrants.TYPE_LIST)) {
			// get all category
			List<CategoryModel> categories = categoryService.getAll();
			req.setAttribute(SystemConstrants.CATEGORIES, categories);
			view = "/views/admin/categories/list.jsp";
		} else if(typeParam.equalsIgnoreCase(SystemConstrants.TYPE_EDIT)){
			
			String idParam = req.getParameter("id");
			if(idParam == null) {
				req.setAttribute("action", "add");
			} else { 
				CategoryModel model = categoryService.getById(Integer.valueOf(idParam));
				req.setAttribute("category", model); 
				req.setAttribute("action", "update"); 
			}
			
			view = "/views/admin/categories/edit.jsp";
			
		}
		
		if(messageParam != null) {
			req.setAttribute(SystemConstrants.MESSAGE, MessageUtils.getMessage(messageParam));
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		
		req.setAttribute(SystemConstrants.TITLE, "Category Manager");
	 	
		rd.forward(req, resp);
	}

}
