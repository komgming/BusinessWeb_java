package com.neuedu.service;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

import java.util.List;

public interface ProductService {

	/**�����Ʒ*/
    public  boolean addProduct(Product product);	
    /**��ѯ��Ʒ*/
    public  List<Product> findAll();
    /**�޸���Ʒ*/
    public  boolean  updateProduct(Product product);
    /**ɾ����Ʒ*/
    public  boolean deleteProduct(int id);
    /**����id��ѯ��Ʒ��Ϣ*/
    public  Product  findProductById(int id);
    
    /**��ҳ��ѯ*/
    public  PageModel<Product> findProductByPage(int pageNo, int pageSize);
    
    
}
