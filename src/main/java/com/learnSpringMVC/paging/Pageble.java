package com.learnSpringMVC.paging;

import com.learnSpringMVC.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
