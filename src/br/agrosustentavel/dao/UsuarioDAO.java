/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.DAO;




import br.agrosustentavel.Modelo.Usuario;
import br.agrosustentavel.conexao.conexaoMySQL;
import java.sql.*;

/**
 *
 * @author OdirJM
 */
 public class UsuarioDAO implements IUsuarioDAO {


   @Override
    public Usuario autenticar(String usuario, String senha) {
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean inserir(Usuario u) {
        String sql = "INSERT INTO usuario (usuario, senha) VALUES (?, ?)";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getSenha());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean atualizar(Usuario u) {
        String sql = "UPDATE usuario SET usuario=?, senha=? WHERE idUsuario=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE idUsuario=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String recuperarSenha(String usuario) {
        String sql = "SELECT senha FROM usuario WHERE usuario = ?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("senha");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}