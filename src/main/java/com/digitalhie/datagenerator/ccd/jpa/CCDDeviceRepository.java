/**
 * 
 */
package com.digitalhie.datagenerator.ccd.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.digitalhie.datagenerator.ccd.entity.CCDDevice;

/**
 * @author svalluripalli
 *
 */
public class CCDDeviceRepository {
	private EntityManager entityManager;

	public CCDDeviceRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Optional<CCDDevice> findById(String id) {
		CCDDevice oDevice = entityManager.find(CCDDevice.class, id);
		if (oDevice != null) {
			return Optional.of(oDevice);
		}
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public List<CCDDevice> findAll() {
		return entityManager.createQuery("from Device").getResultList();
	}

	public Optional<CCDDevice> save(CCDDevice oDevice) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(oDevice);
			entityManager.getTransaction().commit();
			return Optional.of(oDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public List<CCDDevice> saveAll(List<CCDDevice> devices) {
        try {
            entityManager.getTransaction().begin();
            for(CCDDevice device : devices) {
            	entityManager.persist(device);
            }
            entityManager.getTransaction().commit();
            return devices;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
