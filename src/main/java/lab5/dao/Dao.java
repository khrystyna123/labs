package lab5.dao;

import lab5.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(Long id) throws DaoException;

    List<T> findAll() throws DaoException;

    Long insert(T t) throws DaoException;

    int update(T t) throws DaoException;

    int delete(Long id) throws DaoException;

}