package com.neuedu.service.impl;

import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.impl.jdbc.CategoryDaoImpl;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao  ct=new CategoryDaoImpl();
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return ct.addCategory(category);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return ct.findAll();
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return ct.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return ct.deleteCategory(id);
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return ct.findCategoryById(id);
	}

	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return ct.findCategoryByPage(pageNo, pageSize);
	}

}
