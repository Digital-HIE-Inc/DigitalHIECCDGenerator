package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.CCDIntervention;

public class CCDRepository {
	private EntityManager entityManager;

	/**
	 * 
	 * @param entityManager
	 */
	public CCDRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * 
	 * @param id
	 * @return CCDIntervention
	 */
	public Optional<CCDIntervention> findById(Integer id) {
		CCDIntervention ii = entityManager.find(CCDIntervention.class, id);
		if (null != ii) {
			return Optional.of(ii);
		}
		return Optional.empty();
	}
	
	/**
	 * 
	 * @return CCDIntervention
	 */
	@SuppressWarnings("unchecked")
	public List<CCDIntervention> findAll() {
		return entityManager.createQuery("from Intervention").getResultList();
	}
	
	/**
	 * 
	 * @param ii
	 * @return CCDIntervention
	 */
	public Optional<CCDIntervention> save(CCDIntervention ii) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ii);
            entityManager.getTransaction().commit();
            return Optional.of(ii);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
