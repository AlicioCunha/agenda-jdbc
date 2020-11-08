package br.com.agendajdbc.dao;

import br.com.agendajdbc.data.ConexaoJDBC;
import br.com.agendajdbc.data.ConexaoMysqlJDBC;
import br.com.agendajdbc.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Usuario> listar() throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM usuario order by id";

        try {
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getLong("id"), resultSet.getString("nome"));
                usuarios.add(usuario);
            }

            return usuarios;

        } catch (SQLException exception) {
            throw exception;
        }
    }
}
