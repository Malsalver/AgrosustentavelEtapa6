/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.service;
import br.agrosustentavel.DAO.UsuarioDAO;
import br.agrosustentavel.Modelo.Usuario;
/**
 *
 * @author OdirJM
 */




public class UsuarioService {
     private final UsuarioDAO dao = new UsuarioDAO();

    public Usuario autenticar(String usuario, String senha) {
        if (usuario == null || senha == null || usuario.isEmpty() || senha.isEmpty()) {
            System.out.println("Usuário e senha são obrigatórios.");
            return null;
        }
        return dao.autenticar(usuario, senha);
    }

    public boolean cadastrarUsuario(Usuario u) {
        if (u == null || u.getUsuario().isEmpty() || u.getSenha().isEmpty()) {
            System.out.println("Campos obrigatórios.");
            return false;
        }
        return dao.inserir(u);
    }

    public String recuperarSenha(String usuario) {
        return dao.recuperarSenha(usuario);
    }
}