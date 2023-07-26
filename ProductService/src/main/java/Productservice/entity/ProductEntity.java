package org.mani.Productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProductEntity {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private long altkey;
	private String name;
	@Column(nullable =false)
	private long price;
	private Integer quantity;
	private String description;
	public long getAltkey() {
		return altkey;
	}
	public void setAltkey(long altkey) {
		this.altkey = altkey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProductEntity [altkey=" + altkey + ", name=" + name + ", Price=" + price + ", quantity=" + quantity
				+ ", description=" + description + "]";
	}
	
}
