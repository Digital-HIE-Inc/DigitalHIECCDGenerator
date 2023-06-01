/**
 * 
 */
package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.CCDProcedures;

/**
 * @author svalluripalli
 *
 */
public class CCDProceduresRepository {
	private EntityManager entityManager;

	public CCDProceduresRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<CCDProcedures> findById(String id) {
		CCDProcedures oProcedures = entityManager.find(CCDProcedures.class, id);
		if (oProcedures != null) {
			return Optional.of(oProcedures);
		}
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public List<CCDProcedures> findAll() {
		return entityManager.createQuery("from Procedures").getResultList();
	}

	public Optional<CCDProcedures> save(CCDProcedures oProcedures) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(oProcedures);
			entityManager.getTransaction().commit();
			return Optional.of(oProcedures);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
