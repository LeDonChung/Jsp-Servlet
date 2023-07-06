package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

import com.laptrinhjavaweb.constrants.SystemConstrants;

public class MessageUtils {
	public static String getMessage(String param) {
		if(param != null) {
			if(param.equalsIgnoreCase("ADD_CATEGORY_SUCCESS")) {
				return "Add category successfully.";
			} else if(param.equalsIgnoreCase("SERVER_ERRORS")) {
				return "The server has errors."; 
			} else if(param.equalsIgnoreCase("DELETE_CATEGORY_SUCCESS")) {
				return "Delete category successfully.";
			} else if(param.equalsIgnoreCase("UPDATE_CATEGORY_SUCCESS")) {
				return "Update category successfully.";
			} else if(param.equalsIgnoreCase("DELETE_PRODUCT_SUCCESS")) {
				return "Delete product successfully.";
			} else if(param.equalsIgnoreCase("ENABLE_PRODUCT_SUCCESS")) {
				return "Enable product successfully.";
			} else if(param.equalsIgnoreCase("UPDATE_PRODUCT_SUCCESS")) {
				return "Update product successfully";
			} else if(param.equalsIgnoreCase("ADD_PRODUCT_SUCCESS")) {
				return "Add product successfully";
			}
		} 
		return "";
	}
}
