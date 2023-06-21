package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.RoleModel;

public interface IRoleService {
	List<RoleModel> getAll();
	RoleModel insertOne(RoleModel role);
}
