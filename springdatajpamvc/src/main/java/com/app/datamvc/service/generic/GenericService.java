package com.app.datamvc.service.generic;

import java.util.List;

public interface GenericService<T> {
	void insert(T entity) throws Exception;
	void update(T entity) throws Exception;
	void delete(T entity) throws Exception;
	void deleteById(Class<T> type,Object id) throws Exception;
	T find(Class<T> type,Object id) throws Exception;
	List<T> list(String queryName) throws Exception;
}
