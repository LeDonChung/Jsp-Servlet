package com.laptrinhjavaweb.model;

public class CategoryModel {
	private int id;
	private String code;
	private String name;
	
	
	public CategoryModel(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public CategoryModel() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
	
	
	
}
