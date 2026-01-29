/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.DAO;


import br.agrosustentavel.Modelo.Consulta;
import br.agrosustentavel.conexao.conexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author OdirJM
 */
public class ConsultaDAO implements IConsultaDAO {

        @Override
    public boolean inserir(Consulta c) {
        String sql = "INSERT INTO consulta (produtor, propriedade, tipo, data, consumo_agua, consumo_energia) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getProdutor());
            stmt.setString(2, c.getPropriedade());
            stmt.setString(3, c.getTipo());
            stmt.setString(4, c.getData());
            stmt.setString(5, c.getConsumoAgua());
            stmt.setString(6, c.getConsumoEnergia());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean atualizar(Consulta c) {
        String sql = "UPDATE consulta SET produtor=?, propriedade=?, tipo=?, data=?, consumo_agua=?, consumo_energia=? "
                   + "WHERE id=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getProdutor());
            stmt.setString(2, c.getPropriedade());
            stmt.setString(3, c.getTipo());
            stmt.setString(4, c.getData());
            stmt.setString(5, c.getConsumoAgua());
            stmt.setString(6, c.getConsumoEnergia());
            stmt.setInt(7, c.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(int idConsulta) {
        String sql = "DELETE FROM consulta WHERE id=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idConsulta);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Consulta buscarPorId(int idConsulta) {
        String sql = "SELECT * FROM consulta WHERE id=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idConsulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Consulta(
                    rs.getInt("id"),
                    rs.getString("produtor"),
                    rs.getString("propriedade"),
                    rs.getString("tipo"),
                    rs.getString("data"),
                    rs.getString("consumo_agua"),
                    rs.getString("consumo_energia")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Consulta> listarPorStatus(String status) {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta WHERE tipo=?";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Consulta(
                    rs.getInt("id"),
                    rs.getString("produtor"),
                    rs.getString("propriedade"),
                    rs.getString("tipo"),
                    rs.getString("data"),
                    rs.getString("consumo_agua"),
                    rs.getString("consumo_energia")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Consulta> listarTodas() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta";

        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Consulta(
                    rs.getInt("id"),
                    rs.getString("produtor"),
                    rs.getString("propriedade"),
                    rs.getString("tipo"),
                    rs.getString("data"),
                    rs.getString("consumo_agua"),
                    rs.getString("consumo_energia")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}