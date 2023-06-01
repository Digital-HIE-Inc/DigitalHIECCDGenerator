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

import com.digitalhie.datagenerator.ccd.entity.CCDObservations;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.CCDObservationsRepository;

public class LoadObservations {
	private Patient oPateint;
	
	public LoadObservations(Patient oPatient)
	{
		this.setPateint(oPatient);
	}
	
	public LoadObservations() {
		// TODO Auto-generated constructor stub
	}

		public List<CCDObservations> readObservations() {
			String ObservationsInfo = "D:\\work\\shared\\Obs_Modified.txt";
		// Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
		List<CCDObservations> observations = new ArrayList<CCDObservations>();
		try {
			FileReader input = new FileReader(ObservationsInfo);
			Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(input);
			records.forEach(record -> {
				CCDObservations observation = generateObservations(record);
				observations.add(observation);
				//loadObservations(oDevice);
				//threadPool.submit(() -> oDevice);
			});

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("Created observations");
		}
		return observations;
	}
	
	private void loadObservations(CCDObservations oObservations) {
		// Create our entity manager
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					CCDObservationsRepository repo = new CCDObservationsRepository(entityManager);
					// Create a Intervention now...
					Optional<CCDObservations> saveObservations = repo.save(oObservations);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// Close the entity manager and associated factory
					entityManager.close();
					entityManagerFactory.close();
				}
	}
	
	private CCDObservations generateObservations(CSVRecord record) {
		CCDObservations oObservations =  new CCDObservations();
		oObservations.setPatientId(record.get("Patient ID"));
		oObservations.setObservationDate(record.get("Observation Date"));
		oObservations.setAuthorDate(record.get("Author Date"));
		oObservations.setTest(record.get("Test"));
		oObservations.setTestCodeFlag(record.get("Test Code Flag"));		
		oObservations.setValue(record.get("Value"));
		oObservations.setUnits(record.get("Units"));
		oObservations.setEndDate(record.get("End Date"));
		oObservations.setTime(record.get("Time"));
		oObservations.setStatus(record.get("Status"));
		oObservations.setTypeOfResults(record.get("Type of Result"));
		oObservations.setResultValueFlag(record.get("Result Value Flag"));
		oObservations.setType(record.get("Type"));
		oObservations.setNotDone(record.get("Not Done"));		
		oObservations.setReasonCode(record.get("Reason Code"));
		oObservations.setReasonDate(record.get("Reason Date"));						
		oObservations.setQrdaFlag(record.get("QRDA Flag"));
		oObservations.setEdTextFile(record.get("ED Text File"));
		return oObservations;
	}
	
	/**
	 * @return the oPateint
	 */
	public Patient getPateint() {
		return oPateint;
	}

	/**
	 * @param oPateint the oPateint to set
	 */
	public void setPateint(Patient oPateint) {
		this.oPateint = oPateint;
	}
}
