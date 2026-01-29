/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.DAO;
import br.agrosustentavel.Modelo.Produtor;
import java.util.List;

/**
 *
 * @author OdirJM
 */


public interface IProdutorDAO {
    boolean inserir(Produtor produtor);
    boolean atualizar(Produtor produtor);
    boolean deletar(int idProdutor);
    Produtor buscarPorId(int idProdutor);
    List<Produtor> listarTodos();
}