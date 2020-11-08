package br.com.agendajdbc.data;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoMysqlJDBC implements ConexaoJDBC {

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void rollback() {

    }
}
