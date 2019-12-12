package lab5.dao.jdbc;

import lab5.dao.BankAccountDao;
import lab5.exception.DaoException;
import lab5.model.BankAccount;
import lab5.model.Card;
import lab5.model.Owner;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BankAccountDaoJdbc extends JdbcDao<BankAccount> implements BankAccountDao {

    private static final String GET_ALL = "SELECT id, number, type FROM accounts";
    private static final String GET_BY_ID = "SELECT id, number, type FROM accounts WHERE id = ?";
    private static final String ADD = "INSERT INTO accounts (number) VALUES (?)";
    private static final String UPDATE = "UPDATE accounts SET number=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM accounts WHERE id = ?";

    public BankAccountDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() { return GET_ALL; }

    @Override
    protected String getSelectOneQuery() { return GET_BY_ID; }

    @Override
    protected String getInsertQuery() { return ADD; }

    @Override
    protected String getUpdateQuery() { return UPDATE; }

    @Override
    protected String getDeleteQuery() { return DELETE; }

    @Override
    protected List<BankAccount> fillFromResultSet(ResultSet rs) throws SQLException {
        List<BankAccount> result = new LinkedList<>();

        while (rs.next()) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(rs.getLong("id"));
            bankAccount.setNumber(rs.getLong("number"));
            bankAccount.setType(rs.getString("type"));
            result.add(bankAccount);
        }

        return result;
    }

    @Override
    protected void fillPreparedStatementForInsert(PreparedStatement ps, BankAccount bankAccount) throws SQLException {
        ps.setLong(1, bankAccount.getNumber());
    }

    @Override
    protected void fillPreparedStatementForUpdate(PreparedStatement ps, BankAccount bankAccount) throws SQLException {
        ps.setString(1, bankAccount.getType());
        ps.setLong(2, bankAccount.getId());
    }

    @Override
    public Optional<BankAccount> findByIdEager(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Owner> getCard(BankAccount bankAccount) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Integer getOwnerName(BankAccount bankAccount, Owner owner) throws DaoException {
        return null;
    }

    @Override
    public Integer getOwnerPassword(BankAccount bankAccount, Owner owner) throws DaoException {
        return null;
    }

    @Override
    public Integer getOwnerType(BankAccount bankAccount, Owner owner) throws DaoException {
        return null;
    }

    @Override
    public int add(BankAccount bankAccount, Owner owner, String name, String password, String type) throws DaoException {
        return 0;
    }

    @Override
    public int removeOwner(BankAccount bankAccount, Owner owner) throws DaoException {
        return 0;
    }

    @Override
    public int changeOwnerName(BankAccount bankAccount, Owner owner, String newName) throws DaoException {
        return 0;
    }

    @Override
    public int changeOwnerPassword(BankAccount bankAccount, Owner owner, String newPassword) throws DaoException {
        return 0;
    }

    @Override
    public int changeOwnerType(BankAccount bankAccount, Owner owner, String newType) throws DaoException {
        return 0;
    }
}