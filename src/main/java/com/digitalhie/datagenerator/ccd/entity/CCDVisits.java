package com.digitalhie.datagenerator.ccd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Visits")
public class CCDVisits {

	@Id
	@GeneratedValue
	private Integer id;
	private String patientId;
	private String serviceDate;
	private String activityType;
	private String codeFlag;
	private String endDate;
	private String status;
	private String providerId;
	private String providerSpecialty;
	private String facilityLocation;
	private String dischargeDispositionTranslationCode;
	private String dischargeDispositionTranslationFlag;
	private String dischargeDispositionStatusCode;
	private String dischargeDispositionStatusCodeFlag;
	private String diagnosisCode;
	private String diagnosisFlag;
	private String qrdaFlag;
//	@ManyToOne
//    @JoinColumn(name="patientId", nullable=false)
//	private Patient patient;
	/**
	 * @return the patient
	 */
//	public Patient getPatient() {
//		return patient;
//	}
//	/**
//	 * @param patient the patient to set
//	 */
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}
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
	 * @return the serviceDate
	 */
	public String getServiceDate() {
		return serviceDate;
	}
	/**
	 * @param serviceDate the serviceDate to set
	 */
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	/**
	 * @return the activityType
	 */
	public String getActivityType() {
		return activityType;
	}
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}
	/**
	 * @param providerId the providerId to set
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	/**
	 * @return the providerSpecialty
	 */
	public String getProviderSpecialty() {
		return providerSpecialty;
	}
	/**
	 * @param providerSpecialty the providerSpecialty to set
	 */
	public void setProviderSpecialty(String providerSpecialty) {
		this.providerSpecialty = providerSpecialty;
	}
	/**
	 * @return the facilityLocation
	 */
	public String getFacilityLocation() {
		return facilityLocation;
	}
	/**
	 * @param facilityLocation the facilityLocation to set
	 */
	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}
	/**
	 * @return the dischargeDispositionTranslationCode
	 */
	public String getDischargeDispositionTranslationCode() {
		return dischargeDispositionTranslationCode;
	}
	/**
	 * @param dischargeDispositionTranslationCode the dischargeDispositionTranslationCode to set
	 */
	public void setDischargeDispositionTranslationCode(String dischargeDispositionTranslationCode) {
		this.dischargeDispositionTranslationCode = dischargeDispositionTranslationCode;
	}
	/**
	 * @return the dischargeDispositionTranslationFlag
	 */
	public String getDischargeDispositionTranslationFlag() {
		return dischargeDispositionTranslationFlag;
	}
	/**
	 * @param dischargeDispositionTranslationFlag the dischargeDispositionTranslationFlag to set
	 */
	public void setDischargeDispositionTranslationFlag(String dischargeDispositionTranslationFlag) {
		this.dischargeDispositionTranslationFlag = dischargeDispositionTranslationFlag;
	}
	/**
	 * @return the dischargeDispositionStatusCode
	 */
	public String getDischargeDispositionStatusCode() {
		return dischargeDispositionStatusCode;
	}
	/**
	 * @param dischargeDispositionStatusCode the dischargeDispositionStatusCode to set
	 */
	public void setDischargeDispositionStatusCode(String dischargeDispositionStatusCode) {
		this.dischargeDispositionStatusCode = dischargeDispositionStatusCode;
	}
	/**
	 * @return the dischargeDispositionStatusCodeFlag
	 */
	public String getDischargeDispositionStatusCodeFlag() {
		return dischargeDispositionStatusCodeFlag;
	}
	/**
	 * @param dischargeDispositionStatusCodeFlag the dischargeDispositionStatusCodeFlag to set
	 */
	public void setDischargeDispositionStatusCodeFlag(String dischargeDispositionStatusCodeFlag) {
		this.dischargeDispositionStatusCodeFlag = dischargeDispositionStatusCodeFlag;
	}
	/**
	 * @return the diagnosisCode
	 */
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	/**
	 * @param diagnosisCode the diagnosisCode to set
	 */
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	/**
	 * @return the diagnosisFlag
	 */
	public String getDiagnosisFlag() {
		return diagnosisFlag;
	}
	/**
	 * @param diagnosisFlag the diagnosisFlag to set
	 */
	public void setDiagnosisFlag(String diagnosisFlag) {
		this.diagnosisFlag = diagnosisFlag;
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
