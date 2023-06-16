package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.dao.impl.RoleDaoImpl;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.service.IRoleService;

public class RoleSerivceImpl implements IRoleService{
	@Inject
	private IRoleDAO roleDAO;
	@Override
	public List<RoleModel> getAll() {
		return roleDAO.findAll();
	}
	
}
