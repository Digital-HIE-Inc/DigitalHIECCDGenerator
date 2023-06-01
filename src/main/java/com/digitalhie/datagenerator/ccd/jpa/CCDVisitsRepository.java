/**
 * 
 */
package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.CCDVisits;

/**
 * @author svalluripalli
 *
 */
public class CCDVisitsRepository {
	private EntityManager entityManager;

	public CCDVisitsRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<CCDVisits> findById(String id) {
		CCDVisits oVisits = entityManager.find(CCDVisits.class, id);
		if (oVisits != null) {
			return Optional.of(oVisits);
		}
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public List<CCDVisits> findAll() {
		return entityManager.createQuery("from Visits").getResultList();
	}

	public Optional<CCDVisits> save(CCDVisits oVisits) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(oVisits);
			entityManager.getTransaction().commit();
			return Optional.of(oVisits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
