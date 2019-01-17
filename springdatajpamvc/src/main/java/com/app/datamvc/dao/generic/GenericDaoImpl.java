package com.app.datamvc.dao.generic;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public abstract class GenericDaoImpl<T> implements GenericDao<T>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(T entity) throws Exception {
		this.entityManager.persist(entity);
	}

	@Override
	public void update(T entity) throws Exception {
		this.entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) throws Exception {
		this.entityManager.remove(entity);
	}

	@Override
	public T find(Class<T> type, Object id) throws Exception{
		return (T) this.entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String queryName) throws Exception{
		return this.entityManager.createNamedQuery(queryName).getResultList();
	}

	@Override
	public void deleteById(Class<T> type, Object id) throws Exception {
		T entity = this.find(type, id);
		this.delete(entity);
	}

}
