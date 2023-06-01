package com.digitalhie.datagenerator.ccd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Procedures")
public class CCDProcedures {
	@Id
	@GeneratedValue
	private Integer id;
	private String patientId;
	private String startDate;
	private String authorDate;
	private String relaventDateTime;
	private String procedureCode;
	private String codeFlag;
	private String endDate;
	private String serviceStatus;
	private String attribute;
	private String attributeText;
	private String deviceId;
	private String notDone;
	private String reasonCode;
	private String reasonDate;
	private String qrdaFlag;
//	@ManyToOne
//    @JoinColumn(name="patientId", nullable=false)
//	private Patient patient;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	 * @return the relaventDateTime
	 */
	public String getRelaventDateTime() {
		return relaventDateTime;
	}
	/**
	 * @param relaventDateTime the relaventDateTime to set
	 */
	public void setRelaventDateTime(String relaventDateTime) {
		this.relaventDateTime = relaventDateTime;
	}
	/**
	 * @return the procedureCode
	 */
	public String getProcedureCode() {
		return procedureCode;
	}
	/**
	 * @param procedureCode the procedureCode to set
	 */
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
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
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}
	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	/**
	 * @return the attributeText
	 */
	public String getAttributeText() {
		return attributeText;
	}
	/**
	 * @param attributeText the attributeText to set
	 */
	public void setAttributeText(String attributeText) {
		this.attributeText = attributeText;
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
	
}
