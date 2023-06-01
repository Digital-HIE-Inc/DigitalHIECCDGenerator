package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.Patient;

public class PatientRepository {
	private EntityManager entityManager;
	
	public PatientRepository(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	public Optional<Patient> findById(String id) {
		Patient patient = entityManager.find(Patient.class, id);
		if(patient != null) {
			return Optional.of(patient);
		}
        return Optional.empty();
    }

	@SuppressWarnings("unchecked")
	public List<Patient> findAll() {
        return entityManager.createQuery("from Patient").getResultList();
    }
	
	public Optional<Patient> save(Patient patient) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(patient);
            entityManager.getTransaction().commit();
            return Optional.of(patient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }	
	
	public List<Patient> saveAll(List<Patient> patients) {
        try {
            entityManager.getTransaction().begin();
            for(Patient patient : patients) {
            	entityManager.persist(patient);
            }
            entityManager.getTransaction().commit();
            return patients;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
}
