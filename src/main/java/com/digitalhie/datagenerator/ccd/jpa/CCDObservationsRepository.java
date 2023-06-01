/**
 * 
 */
package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.CCDObservations;

/**
 * @author svalluripalli
 *
 */
public class CCDObservationsRepository {
	private EntityManager entityManager;

	public CCDObservationsRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<CCDObservations> findById(String id) {
		CCDObservations oObservations = entityManager.find(CCDObservations.class, id);
		if (oObservations != null) {
			return Optional.of(oObservations);
		}
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public List<CCDObservations> findAll() {
		return entityManager.createQuery("from Observations").getResultList();
	}

	public Optional<CCDObservations> save(CCDObservations oObservations) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(oObservations);
			entityManager.getTransaction().commit();
			return Optional.of(oObservations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
