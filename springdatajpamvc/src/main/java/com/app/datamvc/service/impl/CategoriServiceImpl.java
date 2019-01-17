package com.app.datamvc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.datamvc.dao.CategoriDao;
import com.app.datamvc.dao.generic.GenericDao;
import com.app.datamvc.model.Categori;
import com.app.datamvc.service.CategoriService;
import com.app.datamvc.service.generic.GenericServiceImpl;

@Service
public class CategoriServiceImpl extends GenericServiceImpl<Categori> implements CategoriService{

	private CategoriDao categoriDao;
	
	@Autowired
	public CategoriServiceImpl(
		@Qualifier("categoriDaoImpl") GenericDao<Categori> genericDao) {
		super(genericDao);
		this.categoriDao = (CategoriDao) genericDao;
	}

}
