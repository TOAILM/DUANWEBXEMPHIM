package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.model.Users;
import com.utils.JpaUtils;

public class UserDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	public Users create(Users entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);

		}
	}

	public Users update(Users entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return (entity);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public Users Remove(String id) {
		try {
			em.getTransaction().begin();
			Users entity = this.findByID(id);
			em.remove(entity);
			em.getTransaction().commit();
			return (entity);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}

	public Users findByID(String id) {
		return em.find(Users.class, id);

	}

	public List<Users> findByRole(boolean role) {
		String jpql = "Select o from Users o where o.admin=:role1";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("role1", role);
		return query.getResultList();
	}

	public List<Users> findByKeyWord(String keyword) {
		String jpql = "Select o from Users o where o.fullname like ?0";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter(0, keyword);
		return query.getResultList();
	}

	public Users findOne(String username, String password) {
		String jpql = "Select o from Users o where o.id=:id and o.password=:pass";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("id", username);
		query.setParameter("pass", password);
		return query.getSingleResult();
	}

	public Users findByEmail(String email) {
		String jpql = "Select o from Users o where o.email=:email";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public List<Users> findPage(int page, int size) {
		String jpql = "Select o from Users o";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	// lấy hết usser lên
	public List<Users> findAll() {
		String jpql = "Select o from Users o";
		TypedQuery<Users> query = em.createQuery(jpql, Users.class);
		return query.getResultList();
	}
}
