package com.app.datamvc.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.app.datamvc.dao.CategoriDao;
import com.app.datamvc.dao.generic.GenericDaoImpl;
import com.app.datamvc.model.Categori;

@Repository
@Scope("prototype")
public class CategoriDaoImpl extends GenericDaoImpl<Categori> implements CategoriDao{

}
