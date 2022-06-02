package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
//This annotation is used to convert the class into the tables.
@Entity
//This annotation is used to change table name.
@Table(name="Customer_Table")
public class Customer 
{
	//This annotation is used to create the primary key. 
	@Id
	//This annotation is used to create the primary key value as auto generated one.
	@GeneratedValue
	private int customerId;
	//This annotation is used to check the message is blank or not if it is blank it will not allow.
	@NotBlank(message="Customer name cannot be blank")
	private String customerName;
	//This annotation is used to check the message length if we want only fixed digit values means then we can use it.
	@Length(min=10,max=13,message="Mobile Number must be 10 digits")
	private String customerMobileNo;
	//This annotation also check the message is present or not.
	@NotNull(message="Customer Address cannot be blank ")

	@Length(min=3,message="Address alteast have 3 letters")
	private String customerAddress;

    //constructor without arguments
	public Customer() 
	{
		super();
	}
	//constructor with arguments
	public Customer(int customerId, String customerName,
			String customerMobileNo,
			String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNo = customerMobileNo;
		this.customerAddress = customerAddress;
	}
	//getter and setter methods
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerMobileNo() {
		return customerMobileNo;
	}


	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

    //toString method to display the result in the output screen
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNo="
				+ customerMobileNo + ", customerAddress=" + customerAddress + "]";
	}


}