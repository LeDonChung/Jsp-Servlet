package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constrants.SystemConstrants;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.impl.RoleSerivceImpl;

@WebServlet(urlPatterns = { "/admin" })

public class HomeController extends HttpServlet {
	@Inject
	private IRoleService roleService;
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/admin/home.jsp");
		req.setAttribute(SystemConstrants.TITLE, "Home Admin");
		rd.forward(req, resp); 
	}
}
