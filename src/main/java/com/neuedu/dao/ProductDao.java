package com.neuedu.dao;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

import java.util.List;

public interface ProductDao {

	


	/**
	  * �����Ʒ
	  * */
	boolean  addProduct(Product product);
	/**
	 * �鿴��Ʒ
	 * */
	List<Product> findAll();
	/**
	 * �޸���Ʒ
	 * */
	boolean  updateProduct(Product product);
	/**
	 * ɾ����Ʒ
	 * */
	boolean  deleteProduct(int id);
	
	/**����id��ѯ��Ʒ*/
	Product  findById(int id);
	
	
	/**
	 * ��ҳ��ѯ
	 * pageNo:Ҫ��ѯ�ĵڼ�ҳ
	 * pageSize:Ҫ��ѯ��¼��
	 * */
	
	PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
	
	
	
	
}
