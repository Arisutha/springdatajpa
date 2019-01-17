package com.app.datamvc.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.app.datamvc.dao.StudentDao;
import com.app.datamvc.dao.generic.GenericDaoImpl;
import com.app.datamvc.model.Student;

@Repository
@Scope("prototype")
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao{

}
