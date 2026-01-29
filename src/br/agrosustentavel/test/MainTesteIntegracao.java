/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.test;

        
/**
 *
  * @author OdirJM
 */
import br.agrosustentavel.Modelo.Consulta;
import br.agrosustentavel.Modelo.Produtor;
import br.agrosustentavel.Modelo.Usuario;

import br.agrosustentavel.service.UsuarioService;
import br.agrosustentavel.service.ProdutorService;
import br.agrosustentavel.service.ConsultaService;
import br.agrosustentavel.Modelo.Usuario;
import br.agrosustentavel.service.UsuarioService;
public class MainTesteIntegracao {

 public static void main(String[] args) {

        System.out.println("=== TESTE DE INTEGRAÇÃO AGROSUSTENTÁVEL ===");

        // 1️⃣ Teste de Login
        UsuarioService usuarioService = new UsuarioService();
        Usuario usuario = usuarioService.autenticar("admin", "1234");

        if (usuario != null) {
            System.out.println("✔ Login realizado com sucesso!");
        } else {
            System.out.println("❌ Falha no login!");
        }

        // 2️⃣ Teste de Cadastro de Produtor
        ProdutorService produtorService = new ProdutorService();
        Produtor produtor = new Produtor(
                "João da Silva",
                "123.456.789-00",
                "(48)99999-9999",
                "Rua Central, 100",
                "Sítio Boa Esperança"
        );

        boolean produtorCadastrado = produtorService.cadastrar(produtor);
        System.out.println(produtorCadastrado
                ? "✔ Produtor cadastrado com sucesso!"
                : "❌ Erro ao cadastrar produtor!");

        // 3️⃣ Teste de Cadastro de Consulta
  ConsultaService consultaService = new ConsultaService();

boolean consultaCadastrada = consultaService.cadastrarConsulta(
        "João da Silva",
        "1500L",
        "300kWh",
        "10/02/2026"
);

System.out.println(consultaCadastrada
        ? "✔ Consulta cadastrada com sucesso!"
        : "❌ Erro ao cadastrar consulta!");


    }
}