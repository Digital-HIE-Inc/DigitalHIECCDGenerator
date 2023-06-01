/**
 * 
 */
package com.digitalhie.datagenerator.ccd.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author svalluripalli
 *
 */
@Entity
@Table(name="Patient")
//@NamedQueries({
//    @NamedQuery(name = "Patient.findByName",
//            query = "SELECT b FROM Patient b WHERE b.patientId = :patientId"),
//    @NamedQuery(name = "Patient.findAll",
//            query = "SELECT b FROM Patient b")
//})
public class Patient {
	
	@Id
	String patientId;
	String gender;
	String dob;
	String payer;
	String race;
	String ethinicity;
	String lastName;
	String firstName;
	String middleName;
	String mailingAddress1;
	String mailingAddress2;
	String city;
	String state;
	String zip;
	String telePhone;
	String deceased;
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="patientId")
	List<CCDObservations> observations;
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="patientId")
	List<CCDDiagnosis> diagnostics;
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="patientId")
	List<CCDIntervention> interventions;
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="patientId")
	List<CCDDevice> devices;
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="patientId")
	List<CCDProcedures> procedures;
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="patientId")
	List<CCDVisits> visits;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the payer
	 */
	public String getPayer() {
		return payer;
	}
	/**
	 * @param payer the payer to set
	 */
	public void setPayer(String payer) {
		this.payer = payer;
	}
	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}
	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}
	/**
	 * @return the ethinicity
	 */
	public String getEthinicity() {
		return ethinicity;
	}
	/**
	 * @param ethinicity the ethinicity to set
	 */
	public void setEthinicity(String ethinicity) {
		this.ethinicity = ethinicity;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the mailingAddress1
	 */
	public String getMailingAddress1() {
		return mailingAddress1;
	}
	/**
	 * @param mailingAddress1 the mailingAddress1 to set
	 */
	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}
	/**
	 * @return the mailingAddress2
	 */
	public String getMailingAddress2() {
		return mailingAddress2;
	}
	/**
	 * @param mailingAddress2 the mailingAddress2 to set
	 */
	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the telePhone
	 */
	public String getTelePhone() {
		return telePhone;
	}
	/**
	 * @param telePhone the telePhone to set
	 */
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	/**
	 * @return the deceased
	 */
	public String getDeceased() {
		return deceased;
	}
	/**
	 * @param deceased the deceased to set
	 */
	public void setDeceased(String deceased) {
		this.deceased = deceased;
	}
	/**
	 * @return the observations
	 */
	public List<CCDObservations> getObservations() {
		if(observations == null)
			observations = new ArrayList<>();
		return observations;
	}
	/**
	 * @param observations the observations to set
	 */
	public void setObservations(List<CCDObservations> observations) {
		this.observations = observations;
	}
	/**
	 * @return the diagnostics
	 */
	public List<CCDDiagnosis> getDiagnostics() {
		if(null == diagnostics)
			diagnostics = new ArrayList<>();
		return diagnostics;
	}
	/**
	 * @param diagnostics the diagnostics to set
	 */
	public void setDiagnostics(List<CCDDiagnosis> diagnostics) {
		this.diagnostics = diagnostics;
	}
	/**
	 * @return the interventions
	 */
	public List<CCDIntervention> getInterventions() {
		if(null == interventions)
			interventions = new ArrayList<>();
		return interventions;
	}
	/**
	 * @param interventions the interventions to set
	 */
	public void setInterventions(List<CCDIntervention> interventions) {
		this.interventions = interventions;
	}
	/**
	 * @return the devices
	 */
	public List<CCDDevice> getDevices() {
		if(this.devices == null)
			devices=new ArrayList<>();
		return devices;
	}
	/**
	 * @param devices the devices to set
	 */
	public void setDevices(List<CCDDevice> devices) {
		this.devices = devices;
	}
	/**
	 * @return the procedures
	 */
	public List<CCDProcedures> getProcedures() {
		if(null == procedures)
			procedures = new ArrayList<>();
		return procedures;
	}
	/**
	 * @param procedures the procedures to set
	 */
	public void setProcedures(List<CCDProcedures> procedures) {
		this.procedures = procedures;
	}
	/**
	 * @return the visits
	 */
	public List<CCDVisits> getVisits() {
		if(null == visits)
			visits = new ArrayList<>();
		return visits;
	}
	/**
	 * @param visits the visits to set
	 */
	public void setVisits(List<CCDVisits> visits) {
		this.visits = visits;
	}
	
}
