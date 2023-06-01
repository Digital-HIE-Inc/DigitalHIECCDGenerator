package com.digitalhie.datagenerator.ccd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Observations")
public class CCDObservations {
	@Id
	@GeneratedValue
	private Integer id;
	private String patientId;
	private String observationDate;
	private String authorDate;
	private String test;
	private String testCodeFlag;
	private String value;
	private String units;
	private String endDate;
	private String time;
	private String status;
	private String typeOfResults;
	private String resultValueFlag;
	private String type;
	private String notDone;
	private String reasonCode;
	private String reasonDate;
	private String qrdaFlag;
	private String edTextFile;
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
	 * @return the observationDate
	 */
	public String getObservationDate() {
		return observationDate;
	}
	/**
	 * @param observationDate the observationDate to set
	 */
	public void setObservationDate(String observationDate) {
		this.observationDate = observationDate;
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
	 * @return the test
	 */
	public String getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}
	/**
	 * @return the testCodeFlag
	 */
	public String getTestCodeFlag() {
		return testCodeFlag;
	}
	/**
	 * @param testCodeFlag the testCodeFlag to set
	 */
	public void setTestCodeFlag(String testCodeFlag) {
		this.testCodeFlag = testCodeFlag;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
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
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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
	 * @return the typeOfResults
	 */
	public String getTypeOfResults() {
		return typeOfResults;
	}
	/**
	 * @param typeOfResults the typeOfResults to set
	 */
	public void setTypeOfResults(String typeOfResults) {
		this.typeOfResults = typeOfResults;
	}
	/**
	 * @return the resultValueFlag
	 */
	public String getResultValueFlag() {
		return resultValueFlag;
	}
	/**
	 * @param resultValueFlag the resultValueFlag to set
	 */
	public void setResultValueFlag(String resultValueFlag) {
		this.resultValueFlag = resultValueFlag;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	/**
	 * @return the edTextFile
	 */
	public String getEdTextFile() {
		return edTextFile;
	}
	/**
	 * @param edTextFile the edTextFile to set
	 */
	public void setEdTextFile(String edTextFile) {
		this.edTextFile = edTextFile;
	}

}
