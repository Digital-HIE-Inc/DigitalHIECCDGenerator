/**
 * 
 */
package com.digitalhie.datagenerator.ccd.generator;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.Procedure;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.consol.ConsolFactory;
import org.openhealthtools.mdht.uml.cda.consol.ProceduresSection;
import org.openhealthtools.mdht.uml.cda.consol.ReasonForVisitSection;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;

import com.digitalhie.datagenerator.ccd.entity.CCDDevice;
import com.digitalhie.datagenerator.ccd.entity.CCDDiagnosis;
import com.digitalhie.datagenerator.ccd.entity.CCDIntervention;
import com.digitalhie.datagenerator.ccd.entity.CCDObservations;
import com.digitalhie.datagenerator.ccd.entity.CCDProcedures;
import com.digitalhie.datagenerator.ccd.entity.CCDVisits;
import com.digitalhie.datagenerator.ccd.entity.Patient;
import com.digitalhie.datagenerator.ccd.jpa.PatientRepository;
import com.digitalhie.datagenerator.ccd.persist.LoadDevice;
import com.digitalhie.datagenerator.ccd.persist.LoadDiagnosis;
import com.digitalhie.datagenerator.ccd.persist.LoadIntervention;
import com.digitalhie.datagenerator.ccd.persist.LoadObservations;
import com.digitalhie.datagenerator.ccd.persist.LoadPatients;
import com.digitalhie.datagenerator.ccd.persist.LoadProcedures;
import com.digitalhie.datagenerator.ccd.persist.LoadVisits;

/**
 * @author svalluripalli
 *
 */
public class CCDGenerator {

	private static List<Patient> oPatientList = new ArrayList<>();

	private static void setPatientFromRepo() {
		// Create our entity manager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Patient");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			Map<String, Patient> patients = LoadPatients.readPatient();
			// load devices
			LoadDevice loadDevice = new LoadDevice();
			List<CCDDevice> devices = loadDevice.readDevice();
			// load Devices
			LoadObservations loadObs = new LoadObservations();
			List<CCDObservations> observations = loadObs.readObservations();
			// load visit
			LoadVisits loadVisit = new LoadVisits();
			List<CCDVisits> visits = loadVisit.persistVisits();
			// load diagnosis
			LoadDiagnosis loadDiagnosis = new LoadDiagnosis();
			List<CCDDiagnosis> diagnosises = loadDiagnosis.readDiagnosis();
			// load Interventions
			LoadIntervention loadII = new LoadIntervention();
			List<CCDIntervention> interventions = loadII.readIntervention();
			// Load Procedures
			LoadProcedures loadProcedures = new LoadProcedures();
			List<CCDProcedures> procedures = loadProcedures.readProcedures();

			if (null != patients) {

				if (null != devices) {
					devices.stream().forEach(device -> {
						Patient patient = patients.get(device.getPatientId());
						patient.getDevices().add(device);
					});
				}
				if (null != observations) {
					observations.stream().forEach(observation -> {
						Patient patient = patients.get(observation.getPatientId());
						patient.getObservations().add(observation);
					});
				}
				if (null != visits) {
					visits.stream().forEach(visit -> {
						Patient patient = patients.get(visit.getPatientId());
						patient.getVisits().add(visit);
					});
				}
				if (null != diagnosises) {
					diagnosises.stream().forEach(diagnosis -> {
						Patient patient = patients.get(diagnosis.getPatientId());
						patient.getDiagnostics().add(diagnosis);
					});

				}
				if (null != interventions) {
					interventions.stream().forEach(intervention -> {
						Patient patient = patients.get(intervention.getPatientId());
						patient.getInterventions().add(intervention);
					});
				}
				if (null != procedures) {
					procedures.stream().forEach(procedure -> {
						Patient patient = patients.get(procedure.getPatientId());
						patient.getProcedures().add(procedure);
					});
				}
				// Create our repositories
				PatientRepository oPatientRepository = new PatientRepository(entityManager);

				// Get Patient List...
				oPatientRepository.saveAll(patients.values().stream().collect(Collectors.toCollection(ArrayList::new)));

				oPatientList = oPatientRepository.findAll();

			}
		} catch (Exception exp) {
			throw exp;
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
	}

	private static void createCCD(Patient oPatient) throws Exception {
		if (null != oPatient) {
			ClinicalDocument oClinicalDocument = ConsolFactory.eINSTANCE.createContinuityOfCareDocument().init();
			InfrastructureRootTypeId typeId = CDAFactory.eINSTANCE.createInfrastructureRootTypeId();
			typeId.setExtension("POCD_HD000040");
			typeId.setRoot("2.16.840.1.113883.1.3");
			oClinicalDocument.setTypeId(typeId);
			oClinicalDocument.setLanguageCode(DatatypesFactory.eINSTANCE.createCS("en-US"));
			
			//DocumentationOf documentationOf = CDAFactory.eINSTANCE.createDocumentationOf();

			// ccdDocument.getDocumentationOfs().add(documentationOf);

			II id = DatatypesFactory.eINSTANCE.createII("2.16.840.1.113883.19.4", "c266");
			oClinicalDocument.setId(id);
			TS effectiveTime = DatatypesFactory.eINSTANCE.createTS("20000407");
			oClinicalDocument.setEffectiveTime(effectiveTime);

			CE confidentialityCode = DatatypesFactory.eINSTANCE.createCE("N", "2.16.840.1.113883.5.25");
			oClinicalDocument.setConfidentialityCode(confidentialityCode);
			
			RecordTarget recordTarget = CDAFactory.eINSTANCE.createRecordTarget();
			oClinicalDocument.getRecordTargets().add(recordTarget);
			
			PatientRole patientRole = CDAFactory.eINSTANCE.createPatientRole();
			patientRole.getIds().add(DatatypesFactory.eINSTANCE.createII(oPatient.getPatientId()));
			
			AD ad = DatatypesFactory.eINSTANCE.createAD();
			ad.addStreetAddressLine(oPatient.getMailingAddress1());
			ad.addCity(oPatient.getCity());
			ad.addState(oPatient.getState());
			patientRole.getAddrs().add(ad);
			
			TEL telephone = DatatypesFactory.eINSTANCE.createTEL(oPatient.getTelePhone());
			patientRole.getTelecoms().add(telephone);
			
			recordTarget.setPatientRole(patientRole);

			org.openhealthtools.mdht.uml.cda.Patient patient = CDAFactory.eINSTANCE.createPatient();
			patientRole.setPatient(patient);
			
			PN name = DatatypesFactory.eINSTANCE.createPN();
			if (null != oPatient.getMiddleName() && oPatient.getMiddleName().length() > 0) {
				name.addGiven(oPatient.getFirstName()).addFamily(oPatient.getLastName())
						.addGiven(oPatient.getMiddleName());
			} else {
				name.addGiven(oPatient.getFirstName()).addFamily(oPatient.getLastName());
			}
			patient.getNames().add(name);
			
			CE administrativeGenderCode = DatatypesFactory.eINSTANCE.createCE(oPatient.getGender(),"2.16.840.1.113883.5.1");
			patient.setAdministrativeGenderCode(administrativeGenderCode);
			
			TS birthTime = DatatypesFactory.eINSTANCE.createTS(oPatient.getDob());
			patient.setBirthTime(birthTime);
			
			//set orgaanization
			
			
			// reason for visit
			oPatient.getVisits().stream().forEach(visit -> {
				ReasonForVisitSection visitSection = ConsolFactory.eINSTANCE.createReasonForVisitSection();
				// visitSection.
				oClinicalDocument.addSection(visitSection);
			});
			//procedures
			if(null != oPatient.getProcedures() && !oPatient.getProcedures().isEmpty()) {
				System.out.println("setProcedures");
				ProceduresSection proceduresSection = ConsolFactory.eINSTANCE.createProceduresSection().init();
				oClinicalDocument.addSection(proceduresSection);
				//setEntries
				oPatient.getProcedures().stream().forEach(procedureData ->{
					Procedure procedure = ConsolFactory.eINSTANCE.createProcedureActivityProcedure().init();
					IVL_TS proEffectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS(procedureData.getStartDate(), procedureData.getEndDate());
					//procedure.setMoodCode(x_DocumentEncounterMood.EVN);
					procedure.setEffectiveTime(proEffectiveTime);
					
					//ConsolFactory.eINSTANCE.createProcedures
					proceduresSection.addProcedure(procedure);
			});
			}
			// write to file
			String fileName = "D:\\work\\Inovalon\\Out\\" + oPatient.getLastName() + "_" + oPatient.getPatientId()
					+ ".xml";
			FileOutputStream fos = new FileOutputStream(fileName);
			CDAUtil.save(oClinicalDocument, fos);
			fos.close();

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("-- Beging Processing ---");
			setPatientFromRepo();
			System.out.println("Total records from Database: " + oPatientList.size());
			if (oPatientList != null && oPatientList.size() > 0) {
				System.out.println("-- Inside If ---");
				for (Patient aPatient : oPatientList) {
					// setCCDTemplate();
					createCCD(aPatient);
				}
				System.out.println("-- End If ---");
			}
			System.out.println("-- End Processing ---");
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
