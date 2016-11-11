package idv.jmrs.service;

import java.io.Serializable;

public interface BaseService {

	<T> T save(T t);

	<T> T update(T t);

	<T> void delete(T t);

	<T> void delete(Class<T> clazz, Serializable id);

	<T> T findOne(Class<T> clazz, Serializable id);
}
