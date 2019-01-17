package com.app.datamvc.service.generic;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.datamvc.dao.generic.GenericDao;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T>{
	
	private GenericDao<T> genericDao;
	
	public GenericServiceImpl(GenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericServiceImpl() {}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insert(T entity) throws Exception {
		this.genericDao.insert(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(T entity) throws Exception {
		this.genericDao.update(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(T entity) throws Exception {
		this.genericDao.delete(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Class<T> type, Object id) throws Exception {
		this.genericDao.deleteById(type, id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T find(Class<T> type, Object id) throws Exception {
		return this.genericDao.find(type, id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> list(String queryName) throws Exception {
		return this.genericDao.list(queryName);
	}

}
