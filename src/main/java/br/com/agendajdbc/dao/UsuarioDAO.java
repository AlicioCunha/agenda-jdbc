package br.com.agendajdbc.dao;

import br.com.agendajdbc.data.ConexaoJDBC;
import br.com.agendajdbc.data.ConexaoMysqlJDBC;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private final ConexaoJDBC conexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoMysqlJDBC();
    }

    public void inserir(String nomeUsuario) throws SQLException, ClassNotFoundException {
        String sqlQuery = "INSERT INTO usuario (nome) values (?)";

        try {
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(sqlQuery);
            statement.setString(1, nomeUsuario);
            statement.execute();

            this.conexao.commit();
        } catch (SQLException exception) {
            this.conexao.rollback();
            throw exception;
        }
    }
}
