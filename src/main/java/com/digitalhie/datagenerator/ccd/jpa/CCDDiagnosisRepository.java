package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.CCDDiagnosis;

public class CCDDiagnosisRepository {
	private EntityManager entityManager;

	public CCDDiagnosisRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<CCDDiagnosis> findById(String id) {
		CCDDiagnosis oDiagnosis = entityManager.find(CCDDiagnosis.class, id);
		if (oDiagnosis != null) {
			return Optional.of(oDiagnosis);
		}
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public List<CCDDiagnosis> findAll() {
		return entityManager.createQuery("from Diagnosis").getResultList();
	}

	public Optional<CCDDiagnosis> save(CCDDiagnosis oDiagnosis) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(oDiagnosis);
			entityManager.getTransaction().commit();
			return Optional.of(oDiagnosis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
