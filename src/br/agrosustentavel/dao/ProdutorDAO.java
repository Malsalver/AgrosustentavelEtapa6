/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.DAO;


import br.agrosustentavel.Modelo.Produtor;
import br.agrosustentavel.conexao.conexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OdirJM
 */
public class ProdutorDAO implements IProdutorDAO{

   
    @Override
    public boolean inserir(Produtor p) {
        String sql = "INSERT INTO produtor (nome, cpf, telefone, endereco, propriedade) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getEndereco());
            stmt.setString(5, p.getPropriedade());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean atualizar(Produtor p) {
        String sql = "UPDATE produtor SET nome=?, cpf=?, telefone=?, endereco=?, propriedade=? WHERE id=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getEndereco());
            stmt.setString(5, p.getPropriedade());
            stmt.setInt(6, p.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(int idProdutor) {
        String sql = "DELETE FROM produtor WHERE id=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProdutor);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Produtor buscarPorId(int idProdutor) {
        String sql = "SELECT * FROM produtor WHERE id=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProdutor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produtor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("propriedade")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produtor> listarTodos() {
        List<Produtor> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtor";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Produtor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("propriedade")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    

    public String buscarPropriedadePorNome(String nomeProdutor) {
    String sql = "SELECT propriedade FROM produtor WHERE nome = ?";

    try (Connection conn = conexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nomeProdutor);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("propriedade");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public String buscarProdutorPorPropriedade(String propriedade) {
    String sql = "SELECT nome FROM produtor WHERE propriedade = ?";

    try (Connection conn = conexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, propriedade);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("nome");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return "Não encontrado";
}

}