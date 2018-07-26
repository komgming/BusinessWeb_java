package com.neuedu.service;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

import java.util.List;


public interface CategoryService {

	/**������*/
    public  boolean addCategory(Category category);	
    /**��ѯ���*/
    public  List<Category> findAll();
    /**�޸����*/
    public  boolean  updateCategory(Category category);
    /**ɾ�����*/
    public  boolean deleteCategory(int id);
    /**����id��ѯ�����Ϣ*/
    public  Category  findCategoryById(int id);
    
    /**��ҳ��ѯ*/
    public  PageModel<Category> findCategoryByPage(int pageNo, int pageSize);
    
	
}
