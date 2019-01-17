package com.app.datamvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.datamvc.dao.StudentDao;
import com.app.datamvc.dao.generic.GenericDao;
import com.app.datamvc.model.Student;
import com.app.datamvc.service.StudentService;
import com.app.datamvc.service.generic.GenericServiceImpl;

@Service
public class StudentServiceImpl extends GenericServiceImpl<Student> implements StudentService{

	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(
		@Qualifier("studentDaoImpl") GenericDao<Student> genericDao) {
		super(genericDao);
		this.studentDao = (StudentDao) genericDao;
	}

}
