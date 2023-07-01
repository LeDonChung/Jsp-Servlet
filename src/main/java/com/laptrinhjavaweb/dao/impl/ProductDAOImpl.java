package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.model.ProductModel;

public class ProductDAOImpl extends BaseDao implements IProductDAO{

	@Override
	public List<ProductModel> findAll() {
		List<ProductModel> products = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			if (conn != null) {
				statement = conn.createStatement();
				String query = "SELECT *FROM products";
				rs = statement.executeQuery(query);

				while (rs.next()) {
					 Integer id = rs.getInt(1);
					 String productName = rs.getString(2);
					 Double salePrice = rs.getDouble(3);
					 Double costPrice  = rs.getDouble(4);
					 Integer quantity = rs.getInt(5);
					 String description  = rs.getString(6);
					 String imageUrl = rs.getString(7);
					 Boolean is_deleted = rs.getBoolean(8);
					 Boolean is_activated = rs.getBoolean(9);
					 Integer categoryId = rs.getInt(10);
					 ProductModel model = new ProductModel(id, productName, salePrice, costPrice, quantity, description, imageUrl, categoryId, is_deleted, is_activated);
					 products.add(model);
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

		return products;
	}

	@Override
	public ProductModel insertOne(ProductModel model) {
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "INSERT INTO products(product_name, sale_price, cost_price, quantity, description, imageUrl, is_activated, is_deleted, category_id) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				preparableStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				preparableStatement.setString(1, model.getProductName());
				preparableStatement.setDouble(2, model.getSalePrice());
				preparableStatement.setDouble(3, model.getCostPrice());
				preparableStatement.setInt(4, model.getQuantity());
				preparableStatement.setString(5, model.getDescription());
				preparableStatement.setString(6	, model.getImageUrl());
				preparableStatement.setBoolean(7, model.getIs_activated());
				preparableStatement.setBoolean(8, model.getIs_deleted());
				preparableStatement.setInt(9, model.getCategoryId());
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
	public ProductModel updateOne(ProductModel model) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "UPDATE products "
						+ "SET product_name = ?, sale_price = ?, cost_price = ?, quantity = ?, description = ?, imageUrl = ?, category_id = ? "
						+ "WHERE id = ?";
				preparableStatement = conn.prepareStatement(query);
				preparableStatement.setString(1, model.getProductName());
				preparableStatement.setDouble(2, model.getSalePrice());
				preparableStatement.setDouble(3, model.getCostPrice());
				preparableStatement.setInt(4, model.getQuantity());
				preparableStatement.setString(5, model.getDescription());
				preparableStatement.setString(6	, model.getImageUrl());
				preparableStatement.setInt(7, model.getCategoryId());
				preparableStatement.setInt(8, model.getId());
				preparableStatement.executeUpdate(); 
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
	public ProductModel findById(Integer productId) {
		ProductModel product = null;
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			if (conn != null) {
				statement = conn.createStatement();
				String query = "SELECT *FROM products WHERE id = " + productId ;
				rs = statement.executeQuery(query);

				while (rs.next()) {
					 Integer id = rs.getInt(1);
					 String productName = rs.getString(2);
					 Double salePrice = rs.getDouble(3);
					 Double costPrice  = rs.getDouble(4);
					 Integer quantity = rs.getInt(5);
					 String description  = rs.getString(6);
					 String imageUrl = rs.getString(7);
					 Boolean is_deleted = rs.getBoolean(8);
					 Boolean is_activated = rs.getBoolean(9);
					 Integer categoryId = rs.getInt(10);
					 product = new ProductModel(id, productName, salePrice, costPrice, quantity, description, imageUrl, categoryId, is_deleted, is_activated);
					 
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

		return product;
	}

	@Override
	public void enableById(Integer productId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "UPDATE products "
						+ "SET is_activated = ?, is_deleted = ? "
						+ "WHERE id = ?";
				preparableStatement = conn.prepareStatement(query);
				preparableStatement.setBoolean(1, true);
				preparableStatement.setBoolean(2, false);
				preparableStatement.setInt(3, productId);
				
				preparableStatement.executeUpdate();
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

	}

	@Override
	public void deleteById(Integer productId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparableStatement = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String query = "UPDATE products "
						+ "SET is_activated = ?, is_deleted = ? "
						+ "WHERE id = ? ";
				preparableStatement = conn.prepareStatement(query);
				preparableStatement.setBoolean(1, false);
				preparableStatement.setBoolean(2, true);
				preparableStatement.setInt(3, productId);
				 
				preparableStatement.executeUpdate();
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
	}
	
	

}
