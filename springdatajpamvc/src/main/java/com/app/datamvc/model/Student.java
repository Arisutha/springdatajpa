package com.app.datamvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "STD")
public class Student extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,  generator= "STUDENT_SEQ")
	@TableGenerator(name = "STUDENT_SEQ", table = "T_SEQUENCE", initialValue = 1, allocationSize = 1, pkColumnName = "SEQ_PK", valueColumnName = "SEQ_VAL", pkColumnValue="STD")
	@Column(name = "STD_NIS")
	private int id;
	
	@Column(name = "FIRSTNAME", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "MIDDLENAME", nullable = true, length = 20)
	private String middleName;
	
	@Column(name = "LASTNAME", nullable = true, length = 20)
	private String lastName;
	
	@Column(name = "ADDRESS", nullable = true, length = 20)
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
