/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.DAO;

import br.agrosustentavel.Modelo.Usuario;

/**
 *
 * @author OdirJM
 */


public interface IUsuarioDAO {
    Usuario autenticar(String usuario, String senha);
    boolean inserir(Usuario usuario);
    boolean atualizar(Usuario usuario);
    boolean deletar(int idUsuario);
    String recuperarSenha(String usuario);
}