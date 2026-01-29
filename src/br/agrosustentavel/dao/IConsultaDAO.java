/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.DAO;
import br.agrosustentavel.Modelo.Consulta;
import java.util.List;

/**
 *
 * @author OdirJM
 */

public interface IConsultaDAO {
    boolean inserir(Consulta consulta);
    boolean atualizar(Consulta consulta);
    boolean deletar(int idConsulta);
    Consulta buscarPorId(int idConsulta);
    List<Consulta> listarPorStatus(String status);
    List<Consulta> listarTodas();
}