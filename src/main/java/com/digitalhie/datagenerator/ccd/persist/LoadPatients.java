/**
 * 
 */
package com.digitalhie.datagenerator.ccd.persist;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.PatientRepository;

/**
 * @author svalluripalli
 *
 */
public class LoadPatients {
	private static Random random;
	
	/**
	 * @param args
	 */
	public static Map<String,Patient> readPatient() {
		String patientInfo = "D:\\work\\shared\\Member_Modified.txt";
		random = new Random();
		//Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
	    /*      "Patient ID", "Gender",
	      "Date Of Birth (YYYYMMDD)", "Payer","Race","Ethinicity","Member Last Name","Member First Name",
	      "Member Middle Initial", "Mailing Address1", "Mailing Address 2", "City", "State", "Zip", "Telephone Number","Deceased")); 
	    */
		Map<String,Patient> patients = new HashMap<>();
	    try {
	        FileReader input = new FileReader(patientInfo);
	        Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().parse(input);	        
	        records.forEach(record -> {
	          final long index = record.getRecordNumber();
	          final long seed = random.nextLong();
	          Patient p = generatePerson(index, seed, record);
	          patients.put(p.getPatientId(), p);
	          //loadPatient(p);
	          //threadPool.submit(() -> p);
	        });
	      } catch (Exception e) {
	        System.out.println("Exception: " + e.getMessage());
	        System.out.println(e);
	      } finally {
	        System.out.println("Created patients");	        
	      }
	    return patients;
	}
	
	/**
	 * 
	 * @param patient
	 */
	private static void loadPatient(Patient patient)
	{
		// Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{			
	        // Create our repositories
	        PatientRepository oPatientRepository = new PatientRepository(entityManager);
	        // Create a Patient now...
	        Optional<Patient> savePatient = oPatientRepository.save(patient);			
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			// Close the entity manager and associated factory
	        entityManager.close();
	        entityManagerFactory.close();
		}
	}
	
	/**
	 * 
	 * @param index
	 * @param seed
	 * @param record
	 * @return Patient
	 */
	private static Patient generatePerson(long index, long seed, CSVRecord record) 
	{
		Patient oPatient = new Patient();
		oPatient.setPatientId(record.get("Patient ID"));		
		oPatient.setFirstName(record.get("Member First Name"));
		oPatient.setLastName(record.get("Member Last Name"));
		oPatient.setGender(record.get("Gender"));
		oPatient.setDob(record.get("Date Of Birth (YYYYMMDD)"));
		oPatient.setPayer(record.get("Payer"));
		oPatient.setRace(record.get("Race"));
		oPatient.setEthinicity(record.get("Ethinicity"));
		oPatient.setMiddleName(record.get("Member Middle Initial"));
		oPatient.setMailingAddress1(record.get("Mailing Address1"));
		oPatient.setMailingAddress2(record.get("Mailing Address 2"));
		oPatient.setCity(record.get("City"));
		oPatient.setState(record.get("State"));
		oPatient.setZip(record.get("Zip"));
		oPatient.setTelePhone(record.get("Telephone Number"));
		oPatient.setDeceased(record.get("Deceased"));
		return oPatient;
	}

}
