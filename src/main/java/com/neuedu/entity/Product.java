package com.neuedu.entity;

import java.io.Serializable;

/**
 * javaʵ���� javaBean
 * ����JavaBean
 * (1)����˽��
 * (2)�ṩ�в�/�޲εĹ��췽��
 * ��3���ṩget/set����
 * ��4��ʵ�����л��ӿ�
 * */
public class Product implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6185202905228190806L;
	private  int  id; //��Ʒid
	private  String  name;//��Ʒ����
	private  String  desc;//��Ʒ����
	private  double  price;//��Ʒ�۸�
	private  String  rule;//��Ʒ���
	private String  image;
	
	
	private  int  stock;//���
	
	
	public Product() {
		super();
	}
	public Product( String name, String desc, double price, String rule) {
		super();
		
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
	}
	public Product(int id, String name, String desc, double price, String rule) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
	}
	
	public Product(int id, String name, String desc, double price, String rule, String image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", rule=" + rule + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
