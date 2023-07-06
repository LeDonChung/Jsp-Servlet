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
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.utils.MessageUtils;

@WebServlet(urlPatterns = "/admin/products")
public class ProductController extends HttpServlet{
	@Inject
	private IProductService iProductService;
	@Inject
	private ICategoryService iCategoryService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String view = "/views/admin/products/list.jsp";
		String paramType = req.getParameter(SystemConstrants.TYPE);
		if(paramType.equals(SystemConstrants.TYPE_LIST)) {
			List<ProductModel> products = iProductService.getAll();
			req.setAttribute(SystemConstrants.PRODUCTS, products);
			
		} else if(paramType.equals(SystemConstrants.TYPE_EDIT)) {
			List<CategoryModel> categories = iCategoryService.getAll();
			req.setAttribute(SystemConstrants.CATEGORIES, categories);
			
			String paramId = req.getParameter("id");
			if(paramId == null) {
				// add
				req.setAttribute("action", "add");
			} else {
				// update
				req.setAttribute("action", "update");
				ProductModel model = iProductService.findById(Integer.valueOf(paramId));
				req.setAttribute(SystemConstrants.PRODUCT, model);
			}
			view = "/views/admin/products/edit.jsp";
		}
		 
		
		
		if(req.getParameter(SystemConstrants.MESSAGE) != null) {
			req.setAttribute(SystemConstrants.MESSAGE, MessageUtils.getMessage(req.getParameter(SystemConstrants.MESSAGE)));
		}
		req.setAttribute(SystemConstrants.TITLE, "Product Manager");
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
