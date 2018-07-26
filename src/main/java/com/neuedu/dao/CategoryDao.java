package com.neuedu.dao;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

import java.util.List;

public interface CategoryDao {


	/**
	  * ������
	  * */
	boolean  addCategory(Category category);
	/**
	 * �鿴���
	 * */
	List<Category> findAll();
	/**
	 * �޸����
	 * */
	boolean  updateCategory(Category category);
	/**
	 * ɾ�����
	 * */
	boolean  deleteCategory(int id);
	
	/**����id��ѯ���*/
	Category  findCategoryById(int id);
	
	
	/**
	 * ��ҳ��ѯ
	 * pageNo:Ҫ��ѯ�ĵڼ�ҳ
	 * pageSize:Ҫ��ѯ��¼��
	 * */
	
	PageModel<Category> findCategoryByPage(int pageNo, int pageSize);
	
	
	
	
	
}
