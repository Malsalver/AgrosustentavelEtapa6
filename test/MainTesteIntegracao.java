/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OdirJM
 */


import br.agrosustentavel.DAO.UsuarioDAO;
import br.agrosustentavel.Modelo.Usuario;

public class MainTesteIntegracao {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // Teste de login
        Usuario u = dao.autenticar("admin", "1234");
        System.out.println(u != null ? "Login OK: " + u.getUsuario() : "Falha no login.");

        // Teste de recuperação de senha
        String senha = dao.recuperarSenha("admin");
        System.out.println("Senha recuperada: " + senha);
    }
}
