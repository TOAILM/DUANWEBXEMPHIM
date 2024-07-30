package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.model.Videos;
import com.utils.JpaUtils;

public class VideoDAO {
	private EntityManager em = JpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	public Videos create(Videos entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch(Exception ex) {
			em.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
	}
	
	public Videos update(Videos entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch(Exception ex) {
			em.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
	}
	
	public Videos remove(String id) {
		try {
			em.getTransaction().begin();
			Videos entity = this.findById(id);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch(Exception ex) {
			em.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
	}
	
	public Videos findById(String id) {
		return em.find(Videos.class, id);
	}
	
	public List<Videos> findAll(){
		String jpql = "Select o from Videos o";
		TypedQuery<Videos> query = em.createQuery(jpql, Videos.class);
		List<Videos> list = query.getResultList();
		return list;
	}
}
