package lab5.dao;

import lab5.exception.DaoException;
import lab5.model.*;

import java.util.Set;

public interface CardDao extends Dao<Card> {

    int addCatalog(Card card, BankAccount bankAccount) throws DaoException;

    int removeCatalog(Card card, BankAccount bankAccount) throws DaoException;

    Set<BankAccount> getCatalogs(BankAccount bankAccount) throws DaoException;

}