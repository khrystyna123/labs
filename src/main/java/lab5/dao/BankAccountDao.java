package lab5.dao;

import lab5.exception.DaoException;
import lab5.model.*;

import java.util.Optional;

public interface BankAccountDao extends Dao<BankAccount> {

    Optional<BankAccount> findByIdEager(Long id) throws DaoException;

    Optional<Owner> getCard(BankAccount bankAccount) throws DaoException;

    Integer getOwnerName(BankAccount bankAccount, Owner owner) throws DaoException;

    Integer getOwnerPassword(BankAccount bankAccount, Owner owner) throws DaoException;

    Integer getOwnerType(BankAccount bankAccount, Owner owner) throws DaoException;

    int add(BankAccount bankAccount, Owner owner, String name, String password, String type) throws DaoException;

    int removeOwner(BankAccount bankAccount, Owner owner) throws DaoException;

    int changeOwnerName(BankAccount bankAccount, Owner owner, String newName) throws DaoException;

    int changeOwnerPassword(BankAccount bankAccount, Owner owner, String newPassword) throws DaoException;

    int changeOwnerType(BankAccount bankAccount, Owner owner, String newType) throws DaoException;

}