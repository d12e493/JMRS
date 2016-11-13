package idv.jmrs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import idv.jmrs.service.BaseService;

@Transactional
public abstract class BaseServiceImpl implements BaseService {

	@Autowired
	private EntityManager entityManager;

	@Override
	public <T> T save(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public <T> T update(T t) {
		entityManager.merge(t);
		return t;
	}

	@Override
	public <T> void delete(T t) {
		entityManager.remove(t);
	}

	@Override
	public <T> void delete(Class<T> clazz, Serializable id) {
		T t = entityManager.find(clazz, id);
		if (t != null) {
			delete(t);
		}
	}

	@Override
	public <T> T findOne(Class<T> clazz, Serializable id) {

		return entityManager.find(clazz, id);
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> rootEntry = cq.from(clazz);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
}
