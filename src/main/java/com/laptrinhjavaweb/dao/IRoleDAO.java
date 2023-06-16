package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.RoleModel;

public interface IRoleDAO {
	List<RoleModel> findAll();
	RoleModel insertOne(RoleModel role);
}
