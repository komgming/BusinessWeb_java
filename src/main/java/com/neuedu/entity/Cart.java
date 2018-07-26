package com.neuedu.entity;

import java.io.Serializable;

/**
 * ���ﳵʵ����
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;
	private  Product  productid;
	private  int  productNum;//��Ʒ����
	private  int  productbyid;
	public Cart(int id, Product productid, int productNum, int productbyid) {
		super();
		this.id = id;
		this.productid = productid;
		this.productNum = productNum;
		this.productbyid = productbyid;
	}
	public int getProductbyid() {
		return productbyid;
	}
	public void setProductbyid(int productbyid) {
		this.productbyid = productbyid;
	}
	public Cart(int id, Product product, int productNum, Product productid) {
		super();
		this.id = id;
		this.productid = productid;
		this.productNum = productNum;
	}
	public Cart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProductid() {
		return productid;
	}
	public void setProductid(Product productid) {
		this.productid = productid;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", productid=" + productid + ", productNum=" + productNum + ", productbyid="
				+ productbyid + "]";
	}
	
	
	
	
	
	
}
