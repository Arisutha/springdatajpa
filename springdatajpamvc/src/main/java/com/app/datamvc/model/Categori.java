package com.app.datamvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "CATEGORI")
@NamedQueries({ @NamedQuery(name = "CATEGORI.FINDALL", query = "SELECT C FROM Categori C") })
public class Categori extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,  generator= "CATEGORI_SEQ")
	@TableGenerator(name = "CATEGORI_SEQ", table = "T_SEQUENCE", initialValue = 1, allocationSize = 1, pkColumnName = "SEQ_PK", valueColumnName = "SEQ_VAL", pkColumnValue="CAT")
	//@SequenceGenerator(sequenceName = "CATEGORI_SEQ", initialValue = 1, name = "CATEGORI_SEQ")
	@Column(name = "ID")
	private long id;

	@Column(name = "NAMA_CATEGORI", nullable = false, length = 30)
	private String namaCategori;

	@Column(name = "STATUS", length = 1)
	private String status;

	@Column(name = "PARENT_ID", nullable = true)
	private Long parentId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNamaCategori() {
		return namaCategori;
	}

	public void setNamaCategori(String namaCategori) {
		this.namaCategori = namaCategori;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
