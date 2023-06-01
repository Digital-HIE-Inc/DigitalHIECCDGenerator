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

import com.digitalhie.datagenerator.ccd.entity.CCDDiagnosis;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.CCDDiagnosisRepository;

public class LoadDiagnosis {
	private Patient oPateint;
	
	public LoadDiagnosis(Patient oPatient)
	{
		this.setPateint(oPatient);
	}
	
	public LoadDiagnosis() {
		// TODO Auto-generated constructor stub
	}

	public List<CCDDiagnosis> readDiagnosis() {
		String diagnosisInfo = "D:\\work\\shared\\Diag_Modified.txt";
		// Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
		List<CCDDiagnosis> diagnosises = new ArrayList<>();
		try {
			FileReader input = new FileReader(diagnosisInfo);
			Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(input);
			records.forEach(record -> {
				CCDDiagnosis diagnosis = generateDiagnosis(record);
				diagnosises.add(diagnosis);
				//loadDiagnosis(oDevice);
				//threadPool.submit(() -> oDevice);
			});

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("Created diagnosises");
		}
		return diagnosises;
	}
	
	private void loadDiagnosis(CCDDiagnosis oDiagnosis) {
		// Create our entity manager
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				try {
					CCDDiagnosisRepository repo = new CCDDiagnosisRepository(entityManager);
					// Create a Intervention now...
					Optional<CCDDiagnosis> saveDiagnosis = repo.save(oDiagnosis);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// Close the entity manager and associated factory
					entityManager.close();
					entityManagerFactory.close();
				}
	}
	
	private CCDDiagnosis generateDiagnosis(CSVRecord record) {
		CCDDiagnosis oDiagnosis =  new CCDDiagnosis();
		oDiagnosis.setPatientId(record.get("Patient ID"));
		oDiagnosis.setAttribute(record.get("Attribute"));
		oDiagnosis.setAttributeText(record.get("Attribute Text"));
		oDiagnosis.setDiagnosisCode(record.get("Diagnosis Code"));
		oDiagnosis.setDiagnosisFlag(record.get("Diagnosis Flag"));
		oDiagnosis.setEndDate(record.get("End Date"));
		oDiagnosis.setOrdinality(record.get("Ordinality"));
		oDiagnosis.setQrdaFlag(record.get("QRDA Flag"));
		oDiagnosis.setRelation(record.get("Relation"));
		oDiagnosis.setRelationText(record.get("Relation Text"));
		oDiagnosis.setStartDate(record.get("Start Date"));
		oDiagnosis.setSymtomFlag(record.get("Diagnosis/Symptom Flag"));
		oDiagnosis.setTargetSiteCode(record.get("TargetSiteCode"));
		oDiagnosis.setTargetSiteCodeText(record.get("TargetSiteCode Text"));
		return oDiagnosis;
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
