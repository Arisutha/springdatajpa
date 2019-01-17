package com.app.datamvc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -8947383683527365265L;
	private Date timeCreate;
	private Long userCreate;
	private Date lastUpdate;
	private Long lastUpdater;
	private Boolean deleteStatus = Boolean.FALSE;
	private Date deletionDate;
	private Long userDelete;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRD", nullable = false)
	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Column(name = "CRDOPR", nullable = false)
	public Long getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(Long userCreate) {
		this.userCreate = userCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPD")
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "UPDOPR")
	public Long getLastUpdater() {
		return lastUpdater;
	}

	public void setLastUpdater(Long lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	@Column(name = "DEL")
	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELD")
	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	@Column(name = "DELOPR")
	public Long getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(Long userDelete) {
		this.userDelete = userDelete;
	}

	@Transient
	public final Date parseDate(String arg) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			result = sdf.parse(arg);
		} catch (Exception localException) {
		}
		return result;
	}

	@Transient
	public final Date parseDateTime(String arg) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		try {
			result = sdf.parse(arg);
		} catch (Exception localException) {
		}
		return result;
	}

	@Transient
	public final String formatDate(Date arg) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return sdf.format(arg);
		} catch (Exception localException) {
		}
		return null;
	}

	@Transient
	public final String formatDateTime(Date arg) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		try {
			return sdf.format(arg);
		} catch (Exception localException) {
		}
		return null;
	}

	@Transient
	protected Integer getGregorianToJulian(Date date) {
		if (date != null) {
			String result = "";
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int year = cal.get(1);
			result = result + new Integer(year - 1900).toString();
			result = result + lpad(new Integer(cal.get(6)).intValue(), 3, "0");
			return new Integer(result);
		}
		return null;
	}

	@Transient
	protected static String lpad(int src, int counter) {
		return lpad(src, counter, " ");
	}

	@Transient
	protected static String lpad(int src, int counter, String padChar) {
		String result = "";
		for (int i = 0; i <= counter; i++) {
			result = result + padChar;
		}
		result = result + src;
		return result.substring(result.length() - counter);
	}

	@Transient
	public Date getJulianToGregorian(Integer arg) {
		Date result = null;
		try {
			Calendar cal = Calendar.getInstance();
			int year = 1900 + arg.intValue();
			int doy = arg.intValue();
			cal.set(1, year);
			cal.set(6, doy);
			result = new Date();
			result.setTime(cal.getTimeInMillis());
		} catch (Exception localException) {
		}
		return result;
	}

	@Transient
	public Date getJulianToGregorian(String arg) {
		Date result = null;
		try {
			Calendar cal = Calendar.getInstance();
			int year = 1900 + Integer.parseInt(arg.substring(0, 3));
			int doy = Integer.parseInt(arg.substring(3));
			cal.set(1, year);
			cal.set(6, doy);
			result = new Date();
			result.setTime(cal.getTimeInMillis());
		} catch (Exception localException) {
		}
		return result;
	}
}
