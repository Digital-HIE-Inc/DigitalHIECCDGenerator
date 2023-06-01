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

import com.digitalhie.datagenerator.ccd.entity.CCDVisits;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.CCDVisitsRepository;

/**
 * @author svalluripalli
 *
 */
public class LoadVisits {
	private Patient oPatient;

	public LoadVisits(Patient oPatient) {
		this.setPatient(oPatient);
	}

	public LoadVisits() {
		// TODO Auto-generated constructor stub
	}

	public List<CCDVisits> persistVisits() {
		String interventionInfo = "D:\\work\\shared\\Visit_Modified.txt";
		// Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
		List<CCDVisits> visits = new ArrayList<>();
		try {
			FileReader input = new FileReader(interventionInfo);
			Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(input);
			records.forEach(record -> {
				CCDVisits oVisits = generateVisits(record);
				visits.add(oVisits);
				//loadVisits(oVisits);
				//threadPool.submit(() -> oVisits);
			});

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("Created Intervention");
		}
		return visits;
	}

	private void loadVisits(CCDVisits oVisits) {
		// Create our entity manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			CCDVisitsRepository repo = new CCDVisitsRepository(entityManager);
			// Create a Intervention now...
			Optional<CCDVisits> saveIntervention = repo.save(oVisits);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the entity manager and associated factory
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	private CCDVisits generateVisits(CSVRecord record) {
		CCDVisits oVisits = new CCDVisits();
		oVisits.setPatientId(record.get("Patient ID"));
		oVisits.setServiceDate(record.get("Service Date"));
		oVisits.setActivityType(record.get("Activity Type"));
		oVisits.setCodeFlag(record.get("Code Flag"));
		oVisits.setEndDate(record.get("End Date"));
		oVisits.setStatus(record.get("Status"));
		oVisits.setProviderId(record.get("Provider Id"));
		oVisits.setProviderSpecialty(record.get("Provider Speciality"));
		oVisits.setFacilityLocation(record.get("Facility Location"));
		oVisits.setDischargeDispositionTranslationCode(record.get("Discharge Disposition Translation Code"));
		oVisits.setDischargeDispositionTranslationFlag(record.get("Discharge Disposition Translation Flag"));
		oVisits.setDischargeDispositionStatusCode(record.get("Discharge Disposition Status Code"));
		oVisits.setDischargeDispositionStatusCodeFlag(record.get("Discharge Disposition Status Code Flag"));
		oVisits.setDiagnosisCode(record.get("Diagnosis code"));
		oVisits.setDiagnosisFlag(record.get("Diagnosis Flag"));
		oVisits.setQrdaFlag(record.get("QRDA Flag"));
		return oVisits;
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
