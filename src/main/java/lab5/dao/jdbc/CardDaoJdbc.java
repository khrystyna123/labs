package lab5.dao.jdbc;


import lab5.dao.CardDao;
import lab5.exception.DaoException;
import lab5.model.BankAccount;
import lab5.model.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CardDaoJdbc extends JdbcDao<Card> implements CardDao {

    private static final String GET_ALL = "SELECT id, number, pin, type, currency, balance FROM cards";
    private static final String GET_BY_ID = "SELECT id, number, pin, type, currency, balance FROM cards WHERE id = ?";
    private static final String ADD = "INSERT INTO cards(number, pin, type, currency, balance) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE cards SET number=?,pin=?,type=?,currency=?,balance=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cards WHERE id=?";

    public CardDaoJdbc(Connection connection) {
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
    protected List<Card> fillFromResultSet(ResultSet rs) throws SQLException {
        List<Card> result = new LinkedList<>();

        while (rs.next()) {
            Card card = new Card.Builder()
                 .setId(rs.getLong("id"))
                    .setCardNumber(rs.getLong("number"))
                    .setPin(rs.getInt("pin"))
                    .setType(Card.CardType.valueOf(rs.getString("type")))
                    .setCurrency(Card.Currency.valueOf(rs.getString("currency")))
                    .setBalance(rs.getDouble("balance"))
                    .build();   ;

            result.add(card);
        }

        return result;
    }

    @Override
    protected void fillPreparedStatementForInsert(PreparedStatement ps, Card card) throws SQLException {
        fillPreparedStatement(ps, 1, card);
    }

    @Override
    protected void fillPreparedStatementForUpdate(PreparedStatement ps, Card card) throws SQLException {
        int counter = fillPreparedStatement(ps, 1, card);
        ps.setLong(++counter, card.getId());
    }

    private int fillPreparedStatement(PreparedStatement ps, int counter, Card card) throws SQLException {
        ps.setLong(counter++, card.getCardNumber());
        ps.setLong(counter++, card.getPin());
        ps.setString(counter++, card.getType().toString());
        ps.setString(counter++, card.getCurrency().toString());
        ps.setDouble(counter, card.getBalance());
        return counter;
    }

    @Override
    public int addCatalog(Card card, BankAccount bankAccount) throws DaoException {
        return 0;
    }

    @Override
    public int removeCatalog(Card card, BankAccount bankAccount) throws DaoException {
        return 0;
    }

    @Override
    public Set<BankAccount> getCatalogs(BankAccount bankAccount) throws DaoException {
        return null;
    }
}