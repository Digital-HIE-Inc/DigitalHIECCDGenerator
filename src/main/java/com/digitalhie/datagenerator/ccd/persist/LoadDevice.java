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

import com.digitalhie.datagenerator.ccd.entity.CCDDevice;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.CCDDeviceRepository;

public class LoadDevice {
	private Patient oPatient;
	public LoadDevice() {}
	public LoadDevice(Patient oPatient) {
		this.setPatient(oPatient);
	}

	public List<CCDDevice> readDevice() {
		String interventionInfo = "D:\\work\\shared\\Device_Modified.txt";
		// Read data from CSV file....
		//ExecutorService threadPool = Executors.newFixedThreadPool(8);
		List<CCDDevice> devices = new ArrayList<>();
		try {
			
			FileReader input = new FileReader(interventionInfo);
			Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(input);
			records.forEach(record -> {
				CCDDevice oDevice = generateDevice(record);
				//loadDevice(oDevice);
				devices.add(oDevice);
				//threadPool.submit(() -> oDevice);
			});

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("Created Devices");
		}
		return devices;
	}

	private void loadDevice(CCDDevice oDevice) {
		// Create our entity manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			CCDDeviceRepository repo = new CCDDeviceRepository(entityManager);
			// Create a Intervention now...
			Optional<CCDDevice> saveIntervention = repo.save(oDevice);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the entity manager and associated factory
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	private CCDDevice generateDevice(CSVRecord record) {
		CCDDevice oDevice = new CCDDevice();
		oDevice.setAuthor(record.get("Author"));
		oDevice.setAuthorDate(record.get("Author Date"));
		oDevice.setCodeFlag(record.get("Code Flag"));
		oDevice.setDateApplied(record.get("Date Applied"));
		oDevice.setDeviceCode(record.get("Device Code"));
		oDevice.setDeviceId(record.get("Device Id"));
		oDevice.setEndDae(record.get("End Date"));
		oDevice.setNotDone(record.get("Not Done"));
		oDevice.setPatientId(record.get("Patient ID"));
		oDevice.setQrdaFlag(record.get("QRDA Flag"));
		oDevice.setReasonCode(record.get("Reason Code"));
		oDevice.setReasonDate(record.get("Reason Date"));
		oDevice.setServiceStatus(record.get("Service Status"));
		return oDevice;
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
