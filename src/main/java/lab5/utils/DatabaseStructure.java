package lab5.utils;

import lab5.exception.DatabaseConnectionException;
import lab5.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStructure {
    private static final String CREATE_OWNERS = "CREATE TABLE catalog_items (id integer NOT NULL PRIMARY KEY, name VARCHAR(15) NOT NULL, password VARCHAR(25) NOT NULL, type VARCHAR(15) NOT NULL";
    private static final String DROP_OWNERS = "DROP TABLE catalog_items";

    private static final String CREATE_ACCOUNTS = "CREATE TABLE accounts (id SERIAL NOT NULL PRIMARY KEY, number integer NOT NULL, type VARCHAR(15) NOT NULL, owner_id INTEGER REFERENCES owners(id))";
    private static final String DROP_ACCOUNTS = "DROP TABLE accounts";

    private static final String CREATE_CARDS = "CREATE TABLE cards (id SERIAL NOT NULL PRIMARY KEY, account_id INTEGER REFERENCES accounts(id), number integer NOT NULL, pin integer NOT NULL, type VARCHAR(25) NOT NULL, currency VARCHAR(5) NOT NULL, balance integer NOT NULL)";
    private static final String DROP_CARDS = "DROP TABLE cards";

    public static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE_OWNERS);
        statement.executeUpdate(CREATE_ACCOUNTS);
        statement.executeUpdate(CREATE_CARDS);
    }

    public static void dropTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(DROP_CARDS);
        statement.executeUpdate(DROP_ACCOUNTS);
        statement.executeUpdate(DROP_OWNERS);
    }


}