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
@Table (name = "Diagnosis")
public class CCDDiagnosis {
	@Id
	@GeneratedValue
	private Integer id;
	private String patientId;
	private String startDate;
	private String diagnosisCode;
	private String diagnosisFlag;
	private String endDate;
	private String ordinality;
	private String targetSiteCode;
	private String targetSiteCodeText;
	private String relation;
	private String relationText;
	private String attribute;
	private String attributeText;
	private String symtomFlag;
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
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the patientId
	 *
	public String getPatientId() {
		return patientId;
	}*/
	/**
	 * @param patientId the patientId to set
	 *
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}*/
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
	 * @return the ordinality
	 */
	public String getOrdinality() {
		return ordinality;
	}
	/**
	 * @param ordinality the ordinality to set
	 */
	public void setOrdinality(String ordinality) {
		this.ordinality = ordinality;
	}
	/**
	 * @return the targetSiteCode
	 */
	public String getTargetSiteCode() {
		return targetSiteCode;
	}
	/**
	 * @param targetSiteCode the targetSiteCode to set
	 */
	public void setTargetSiteCode(String targetSiteCode) {
		this.targetSiteCode = targetSiteCode;
	}
	/**
	 * @return the targetSiteCodeText
	 */
	public String getTargetSiteCodeText() {
		return targetSiteCodeText;
	}
	/**
	 * @param targetSiteCodeText the targetSiteCodeText to set
	 */
	public void setTargetSiteCodeText(String targetSiteCodeText) {
		this.targetSiteCodeText = targetSiteCodeText;
	}
	/**
	 * @return the relation
	 */
	public String getRelation() {
		return relation;
	}
	/**
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}
	/**
	 * @return the relationText
	 */
	public String getRelationText() {
		return relationText;
	}
	/**
	 * @param relationText the relationText to set
	 */
	public void setRelationText(String relationText) {
		this.relationText = relationText;
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
	 * @return the symtomFlag
	 */
	public String getSymtomFlag() {
		return symtomFlag;
	}
	/**
	 * @param symtomFlag the symtomFlag to set
	 */
	public void setSymtomFlag(String symtomFlag) {
		this.symtomFlag = symtomFlag;
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
