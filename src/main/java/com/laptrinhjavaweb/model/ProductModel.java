package com.laptrinhjavaweb.model;

public class ProductModel {
	
	private Integer id;
	private String productName;
	private Double salePrice;
	private Double costPrice;
	private Integer quantity;
	private String description;
	private String imageUrl;
	private Integer categoryId;
	private Boolean is_deleted;
	private Boolean is_activated;
	
	
	
	public ProductModel(Integer id, String productName, Double salePrice, Double costPrice, Integer quantity,
			String description, String imageUrl, Integer categoryId, Boolean is_deleted, Boolean is_activated) {
		super();
		this.id = id;
		this.productName = productName;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.quantity = quantity;
		this.description = description;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
		this.is_deleted = is_deleted;
		this.is_activated = is_activated;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public ProductModel(Integer id, String productName, Double salePrice, Double costPrice, String description,
			String imageUrl, Integer categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.description = description;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
	}
	public ProductModel() {
		super();
	}
	public Boolean getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public Boolean getIs_activated() {
		return is_activated;
	}
	public void setIs_activated(Boolean is_activated) {
		this.is_activated = is_activated;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", productName=" + productName + ", salePrice=" + salePrice + ", costPrice="
				+ costPrice + ", quantity=" + quantity + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", categoryId=" + categoryId + ", is_deleted=" + is_deleted + ", is_activated=" + is_activated + "]";
	}
	
	
	
	
}
