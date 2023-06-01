/**
 * 
 */
package com.digitalhie.datagenerator.ccd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author svalluripalli
 *
 */
@Entity
@Table (name = "Device")
public class CCDDevice {
	@Id
	@GeneratedValue
	private Integer id;
	private String patientId;
	private String deviceId;
	private String dateApplied;
	private String authorDate;
	private String deviceCode;
	private String codeFlag;
	private String endDae;
	private String serviceStatus;
	private String author;
	private String notDone;
	private String reasonCode;
	private String reasonDate;
	private String qrdaFlag;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the dateApplied
	 */
	public String getDateApplied() {
		return dateApplied;
	}
	/**
	 * @param dateApplied the dateApplied to set
	 */
	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}
	/**
	 * @return the authorDate
	 */
	public String getAuthorDate() {
		return authorDate;
	}
	/**
	 * @param authorDate the authorDate to set
	 */
	public void setAuthorDate(String authorDate) {
		this.authorDate = authorDate;
	}
	/**
	 * @return the deviceCode
	 */
	public String getDeviceCode() {
		return deviceCode;
	}
	/**
	 * @param deviceCode the deviceCode to set
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	/**
	 * @return the codeFlag
	 */
	public String getCodeFlag() {
		return codeFlag;
	}
	/**
	 * @param codeFlag the codeFlag to set
	 */
	public void setCodeFlag(String codeFlag) {
		this.codeFlag = codeFlag;
	}
	/**
	 * @return the endDae
	 */
	public String getEndDae() {
		return endDae;
	}
	/**
	 * @param endDae the endDae to set
	 */
	public void setEndDae(String endDae) {
		this.endDae = endDae;
	}
	/**
	 * @return the serviceStatus
	 */
	public String getServiceStatus() {
		return serviceStatus;
	}
	/**
	 * @param serviceStatus the serviceStatus to set
	 */
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the notDone
	 */
	public String getNotDone() {
		return notDone;
	}
	/**
	 * @param notDone the notDone to set
	 */
	public void setNotDone(String notDone) {
		this.notDone = notDone;
	}
	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}
	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	/**
	 * @return the reasonDate
	 */
	public String getReasonDate() {
		return reasonDate;
	}
	/**
	 * @param reasonDate the reasonDate to set
	 */
	public void setReasonDate(String reasonDate) {
		this.reasonDate = reasonDate;
	}
	/**
	 * @return the qrdaFlag
	 */
	public String getQrdaFlag() {
		return qrdaFlag;
	}
	/**
	 * @param qrdaFlag the qrdaFlag to set
	 */
	public void setQrdaFlag(String qrdaFlag) {
		this.qrdaFlag = qrdaFlag;
	}
	
//	@ManyToOne
//	@JoinColumn(name="patientId")
//	private Patient patient;
	
	
	
	
	

}
