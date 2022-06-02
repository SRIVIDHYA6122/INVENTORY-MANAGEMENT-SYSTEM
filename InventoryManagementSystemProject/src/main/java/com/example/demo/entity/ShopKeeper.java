package com.example.demo.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//This annotation is used to convert the class into the tables.
@Entity
//This annotation is used to change table name.
@Table(name="Shopkeeper_Table")
public class ShopKeeper {
	//This annotation is used to create the primary key.
	@Id
	//This annotation is used to create the primary key value as auto generated one.
	@GeneratedValue(generator="seq",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq",initialValue = 1000)
	private int productId;
	//This annotation is used to check the message is blank or not if it is blank it will not allow.
	@NotBlank(message="Product name cannot be blank")
	private String productName;
	@NotBlank(message="Product type cannot be blank ")
	private String productType;
	//This annotation also check the message is present or not.
	@NotNull(message="Product brand cannot be blank")
	private String productBrand;
	//This annotation we are declaring to check atleast single value
	@Min(value=1)
	private int productQuantity;
	private double productPrice;
	public int currentstock;
	public  double totalamount;
	
	//constructor without arguments
	public ShopKeeper() {
		super();
	}
	//constructor with arguments
	public ShopKeeper(int productId,String productName,
	String productType,
		String productBrand, @Min(1) int productQuantity,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productBrand = productBrand;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}
	
	/**This annotation is create the relationship between two entity classes
	 * targetEntity->this specifies which entity we are making relationship to this entity
	 * cascade->this handle the parent and child relation
	*/
	@OneToMany(targetEntity = Customer.class,cascade = CascadeType.ALL)
	//this annotation eliminate one table and makes one column in the target entity
   @JoinColumn(name="product_id")
	
	//creating target entity object
	private List<Customer> customer;

	//getter and setter methods
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice =productPrice;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	//toString method
	@Override
	public String toString() {
		return "ShopKeeper [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productBrand=" + productBrand + ", productQuantity=" + productQuantity + ", productPrice="
				+ productPrice + ", currentstock=" + currentstock + ", totalamount=" + totalamount + ", customer="
				+ customer + "]";
	}

	
	
	
	
	
	
	
	
	

}
