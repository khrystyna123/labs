package lab5.dao.jdbc;
import lab5.dao.OwnerDao;
import lab5.exception.DaoException;
import lab5.model.Owner;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OwnerDaoJdbc extends JdbcDao<Owner> implements OwnerDao {

    private static final String GET_ALL = "SELECT id, name, password, type FROM owners";
    private static final String GET_BY_ID = "SELECT id, name, password, type FROM owners WHERE id = ?";
    private static final String ADD = "INSERT INTO owners (name, password, type) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE owners SET name=?, password=?, type=? WHERE id=?";
    private static final String DELETE = "DELETE FROM owners WHERE id=?";
    private static final String GET_BY_NAME = "SELECT id, name, password, type FROM owners WHERE name LIKE ?";

    public OwnerDaoJdbc(Connection connection) {
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
    protected List<Owner> fillFromResultSet(ResultSet rs) throws SQLException {
        List<Owner> result = new LinkedList<>();
        while (rs.next()) {
            Owner owner = new Owner.Builder()
                    .setId(rs.getLong("id"))
                    .setOwner(rs.getString("name"))
                    .setPassword(rs.getString("password"))
                    .setType(rs.getString("type"))
                    .build();
            result.add(owner);
        }
        return result;
    }

    @Override
    protected void fillPreparedStatementForInsert(PreparedStatement ps, Owner owner) throws SQLException {
        fillPreparedStatement(ps, 1, owner);
    }

    @Override
    protected void fillPreparedStatementForUpdate(PreparedStatement ps, Owner owner) throws SQLException {
        int counter = fillPreparedStatement(ps, 1, owner);
        ps.setLong(++counter, owner.getId());
    }

    private int fillPreparedStatement(PreparedStatement ps, int counter, Owner owner) throws SQLException {
        ps.setString(counter++, owner.getOwner());
        ps.setString(counter++, owner.getPassword());
        ps.setString(counter++, owner.getType());
        return counter;
    }

    @Override
    public List<Owner> findAllWithNameLike(String name) throws DaoException {
        List<Owner> result;
        Connection connection = getConnection();
        try (PreparedStatement ps = connection.prepareStatement(GET_BY_NAME)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            result = fillFromResultSet(rs);
            rs.close();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return result;
    }
}