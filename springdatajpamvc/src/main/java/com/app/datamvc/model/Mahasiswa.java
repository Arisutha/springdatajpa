package com.app.datamvc.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MHS")
@AttributeOverrides({ @AttributeOverride(name = "timeCreate", column = @Column(name = "CRDMHS")),
		@AttributeOverride(name = "userCreate", column = @Column(name = "CRDOPRMHS")),
		@AttributeOverride(name = "lastUpdate", column = @Column(name = "UPDMHS")),
		@AttributeOverride(name = "lastUpdater", column = @Column(name = "UPDOPRMHS")),
		@AttributeOverride(name = "deleteStatus", column = @Column(name = "DELMHS")),
		@AttributeOverride(name = "deletionDate", column = @Column(name = "DELDMHS")),
		@AttributeOverride(name = "userDelete", column = @Column(name = "DELOPRMHS")) })
public class Mahasiswa extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NIMMHS", length = 20)
	private String nimMhs;

	@Column(name = "NMMHS", length = 30, nullable = false)
	private String namaMahasiswa;

	@Column(name = "JKMHS", length = 1, nullable = false)
	private int jenisKelamin;

	@Column(name = "TMPLHRMHS", length = 30, nullable = false)
	private String tempatLahir;

	@Column(name = "TGLLHRMHS", nullable = false)
	private Date tanggalLahir;

	@Column(name = "TLPMHS", nullable = true, length = 15)
	private String telpon;

	@Column(name = "RTMHS", nullable = true, length = 5)
	private String rt;

	@Column(name = "RWMHS", nullable = true, length = 5)
	private String rw;

	@Column(name = "ALMMHS", nullable = true, length = 255)
	private String alamat;

	@Column(name = "JRMHS", insertable = false, updatable = false)
	private int jurusan;

	@Column(name = "KLSMHS", insertable = false, updatable = false)
	private int kelas;

	public String getNimMhs() {
		return nimMhs;
	}

	public void setNimMhs(String nimMhs) {
		this.nimMhs = nimMhs;
	}

	public String getNamaMahasiswa() {
		return namaMahasiswa;
	}

	public void setNamaMahasiswa(String namaMahasiswa) {
		this.namaMahasiswa = namaMahasiswa;
	}

	public int getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(int jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getRw() {
		return rw;
	}

	public void setRw(String rw) {
		this.rw = rw;
	}

	public int getJurusan() {
		return jurusan;
	}

	public void setJurusan(int jurusan) {
		this.jurusan = jurusan;
	}

	public int getKelas() {
		return kelas;
	}

	public void setKelas(int kelas) {
		this.kelas = kelas;
	}

	public String getTelpon() {
		return telpon;
	}

	public void setTelpon(String telpon) {
		this.telpon = telpon;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
