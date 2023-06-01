/**
 * 
 */
package com.digitalhie.datagenerator.ccd.persist;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.digitalhie.datagenerator.ccd.entity.CCDIntervention;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.CCDRepository;

/**
 * @author svalluripalli
 *
 */
public class LoadIntervention {
	
	private Patient oPatient;
	
	public LoadIntervention(Patient oPatient)
	{
		setPatient(oPatient);
	}
	
	public LoadIntervention() {
		// TODO Auto-generated constructor stub
	}

	public List<CCDIntervention> readIntervention() 
	{
		String interventionInfo = "D:\\work\\shared\\Inter_Modified.txt";
		//Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
		List<CCDIntervention> interventions = new ArrayList<>();
		try {
			FileReader input = new FileReader(interventionInfo);
	        Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().parse(input);
	        records.forEach(record -> {
	        	CCDIntervention ii = generateIntervention(record);
	        	interventions.add(ii);
	        	//loadIntervention(ii);
	        	//threadPool.submit(() -> ii);
	        	});
	         
		} catch (Exception e) {
	        System.out.println("Exception: " + e.getMessage());
	        System.out.println(e);
	        e.printStackTrace();
	      } finally {
	        System.out.println("Created Intervention");	        
	      }
		return interventions;
	}
	
	/**
	 * 
	 * @param ii
	 */
	private void loadIntervention(CCDIntervention ii)
	{
		// Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			CCDRepository repo = new CCDRepository(entityManager);
			// Create a Intervention now...
			Optional<CCDIntervention> saveIntervention = repo.save(ii);
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
	 * @param record
	 * @return CCDIntervention
	 */
	private CCDIntervention generateIntervention(CSVRecord record)
	{
		CCDIntervention ii = new CCDIntervention();
		ii.setPatientId(record.get("Patient ID"));
		ii.setAuthorDate(record.get("Author Date"));
		ii.setCodeFlag(record.get("Code Flag"));
		ii.setEndDate(record.get("End Date"));
		ii.setInterventionCode(record.get("Intervention Code"));
		ii.setNotDone(record.get("Not Done"));
		ii.setProcedureTemplateType(record.get("Procedure Template Type"));
		ii.setQrdaFlag(record.get("QRDA Flag"));
		ii.setReasonCode(record.get("Reason Code"));
		ii.setReasonDate(record.get("Reason Date"));
		ii.setRelevantDateTime(record.get("Relevant Date Time"));
		ii.setServiceStatus(record.get("Service Status"));
		ii.setStartDate(record.get("Start date"));		
		return ii;
	}

	/**
	 * @return the oPatient
	 */
	public Patient getPatient() {
		return oPatient;
	}

	/**
	 * @param oPatient the oPatient to set
	 */
	public void setPatient(Patient oPatient) {
		this.oPatient = oPatient;
	}

}
