/**
 * 
 */
package com.digitalhie.datagenerator.ccd.persist;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.digitalhie.datagenerator.ccd.entity.CCDProcedures;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.CCDProceduresRepository;

/**
 * @author svalluripalli
 *
 */
public class LoadProcedures {
	private Patient oPatient;

	public LoadProcedures(Patient oPatient) {
		this.setPatient(oPatient);
	}

	public LoadProcedures() {
		// TODO Auto-generated constructor stub
	}

	public List<CCDProcedures> readProcedures() {
		String interventionInfo = "D:\\work\\shared\\Proc_Modified.txt";
		// Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
		List<CCDProcedures> procedures = new ArrayList<CCDProcedures>();
		try {
			FileReader input = new FileReader(interventionInfo);
			Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(input);
			records.forEach(record -> {
				CCDProcedures oProcedures = generateProcedures(record);
				procedures.add(oProcedures);
				//loadProcedures(oProcedures);
				//threadPool.submit(() -> oProcedures);
			});

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("Created procedures");
		}
		return procedures;
	}

	private void loadProcedures(CCDProcedures oProcedures) {
		// Create our entity manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			CCDProceduresRepository repo = new CCDProceduresRepository(entityManager);
			// Create a Intervention now...
			Optional<CCDProcedures> saveIntervention = repo.save(oProcedures);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the entity manager and associated factory
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	private CCDProcedures generateProcedures(CSVRecord record) {
		CCDProcedures oProcedures = new CCDProcedures();
		oProcedures.setPatientId(record.get("Patient ID"));
		oProcedures.setStartDate(record.get("Start Date"));
		oProcedures.setAuthorDate(record.get("Author Date"));
		oProcedures.setRelaventDateTime(record.get("Relevant dateTime"));
		oProcedures.setProcedureCode(record.get("Procedure Code"));
		oProcedures.setCodeFlag(record.get("Code Flag"));
		oProcedures.setEndDate(record.get("End Date"));
		oProcedures.setServiceStatus(record.get("Service Status"));
		oProcedures.setAttribute(record.get("Attribute"));
		oProcedures.setAttributeText(record.get("Attribute Text"));
		oProcedures.setDeviceId(record.get("Device Id"));
		oProcedures.setNotDone(record.get("Not Done"));
		oProcedures.setReasonCode(record.get("Reason Code"));
		oProcedures.setReasonDate(record.get("Reason Date"));
		oProcedures.setQrdaFlag(record.get("QRDA Flag"));
		return oProcedures;
	}

	/**
	 * @return the oPatient
	 */
	public Patient getPatient() {
		return oPatient;
	}

	/**
	 * @param oPatient
	 *            the oPatient to set
	 */
	public void setPatient(Patient oPatient) {
		this.oPatient = oPatient;
	}
}
