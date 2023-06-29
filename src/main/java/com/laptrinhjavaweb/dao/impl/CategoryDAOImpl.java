package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.RoleModel;

public class CategoryDAOImpl extends BaseDao implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> categories = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			if (conn != null) {
				statement = conn.createStatement();
				String query = "SELECT *FROM categories";
				rs = statement.executeQuery(query);

				while (rs.next()) {
					int id = rs.getInt("id");
					String code = rs.getString("code");
					String name = rs.getString("name");
					CategoryModel category = new CategoryModel(id, code, name);
					categories.add(category);
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

		return categories;
	}

	@Override
	public CategoryModel insertOne(CategoryModel model) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "INSERT INTO categories(code, name) values(?, ?)";
				preparableStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				preparableStatement.setString(1, model.getCode());
				preparableStatement.setString(2, model.getName());
				preparableStatement.executeUpdate();

				rs = preparableStatement.getGeneratedKeys();
				while (rs.next()) {
					model.setId(rs.getInt(1));
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

		return model;
	}

	@Override
	public CategoryModel updateOne(CategoryModel model) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "UPDATE categories SET code = ?, name = ? WHERE id = ?";
				
				preparableStatement = conn.prepareStatement(query);
				preparableStatement.setString(1, model.getCode());
				preparableStatement.setString(2, model.getName());
				preparableStatement.setInt(3, model.getId());
				preparableStatement.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

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

		return model;
	}

	@Override
	public int deleteOne(int id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		int row = 0;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "DELETE FROM categories WHERE id = ?";
				
				preparableStatement = conn.prepareStatement(query);
				preparableStatement.setInt(1, id);
				
				row = preparableStatement.executeUpdate();

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

		return row;
	}

	@Override
	public List<CategoryModel> findAllByName(String nameS) {
		List<CategoryModel> categories = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			if (conn != null) {
				statement = conn.createStatement();
				String query = String.format("SELECT *FROM categories name LIKE '%%%s%%'", nameS);
				rs = statement.executeQuery(query);

				while (rs.next()) {
					int id = rs.getInt("id");
					String code = rs.getString("code");
					String name = rs.getString("name");
					CategoryModel category = new CategoryModel(id, code, name);
					categories.add(category);
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

		return categories;
	}

	@Override
	public CategoryModel findById(Integer idS) {
		CategoryModel model = null; 
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			if (conn != null) {
				statement = conn.createStatement();
				String query = String.format("SELECT *FROM categories where id = %d", idS);
				rs = statement.executeQuery(query);

				while (rs.next()) {
					int id = rs.getInt("id");
					String code = rs.getString("code");
					String name = rs.getString("name");
					model = new CategoryModel(id, code, name);
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

		return model;
	}

}
