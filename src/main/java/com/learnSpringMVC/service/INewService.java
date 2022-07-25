package com.learnSpringMVC.service;

import com.learnSpringMVC.model.NewModel;
import com.learnSpringMVC.paging.Pageble;

import java.util.List;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long[] ids);
	List<NewModel> findAll();
	int getTotalItem();
	NewModel findOne(long id);
}
