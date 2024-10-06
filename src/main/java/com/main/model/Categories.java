package com.main.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	@OneToMany(mappedBy = "categories")
	private List<Products> products;
	
		public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Categories [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
