package lab5.dao;

import lab5.exception.DaoException;
import lab5.model.Owner;

import java.util.List;

public interface OwnerDao extends Dao<Owner> {

    List<Owner> findAllWithNameLike(String name) throws DaoException;

}