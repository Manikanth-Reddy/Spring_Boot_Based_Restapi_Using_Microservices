package org.mani.Orderservice.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class OrderEntity {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private long altkey;
	private String productId;
	private long quantity;
	private double price;
	private double totalprice;
	private String paymentMode;
	private Date soldDate;
	public long getAltkey() {
		return altkey;
	}
	public void setAltkey(long altkey) {
		this.altkey = altkey;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
}
