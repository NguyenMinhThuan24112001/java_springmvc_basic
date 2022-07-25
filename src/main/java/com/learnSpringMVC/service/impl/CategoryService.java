package com.learnSpringMVC.service.impl;

import com.learnSpringMVC.DAO.ICategoryDAO;
import com.learnSpringMVC.model.CategoryModel;
import com.learnSpringMVC.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
