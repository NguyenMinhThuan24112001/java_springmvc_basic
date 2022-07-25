package com.learnSpringMVC.service;

import com.learnSpringMVC.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
