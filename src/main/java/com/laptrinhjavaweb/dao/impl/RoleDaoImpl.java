package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.model.RoleModel;

public class RoleDaoImpl extends BaseDao implements IRoleDAO {
	@Override
	public List<RoleModel> findAll() {
		List<RoleModel> roles = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			if (conn != null) {
				statement = conn.createStatement();
				String query = "SELECT *FROM roles";
				rs = statement.executeQuery(query);

				while (rs.next()) {
					int id = rs.getInt("id");
					String code = rs.getString("code");
					String name = rs.getString("name");
					RoleModel role = new RoleModel(id, code, name);
					roles.add(role);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return roles;
	}

	@Override
	public RoleModel insertOne(RoleModel role) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "INSERT INTO roles(code, name) values(?, ?)";
				preparableStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				preparableStatement.setString(1, role.getCode());
				preparableStatement.setString(2, role.getName());
				preparableStatement.executeUpdate();

				rs = preparableStatement.getGeneratedKeys();
				while (rs.next()) {
					role.setId(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparableStatement != null) {
				try {
					preparableStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role;

	}

}
