/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.service;
import br.agrosustentavel.DAO.ProdutorDAO;
import br.agrosustentavel.Modelo.Produtor;
import br.agrosustentavel.Modelo.Validacao;

import java.util.List;
/**
 *
 * @author OdirJM
 */
public class ProdutorService {
private ProdutorDAO dao = new ProdutorDAO();

    public boolean cadastrar(Produtor p) {

        if (p.getNome().isEmpty() || p.getCpf().isEmpty()) {
            System.out.println("Nome e CPF são obrigatórios.");
            return false;
        }

        if (!Validacao.validarCPF(p.getCpf())) {
            System.out.println("CPF inválido.");
            return false;
        }

        if (!Validacao.validarTelefone(p.getTelefone())) {
            System.out.println("Telefone inválido.");
            return false;
        }

        return dao.inserir(p);
    }

    public boolean atualizar(Produtor p) {
        if (p.getId() <= 0) {
            System.out.println("Produtor inválido.");
            return false;
        }
        return dao.atualizar(p);
    }

    public boolean remover(int id) {
        return dao.deletar(id);
    }

    public Produtor buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    public List<Produtor> listarTodos() {
        return dao.listarTodos();
    }
}