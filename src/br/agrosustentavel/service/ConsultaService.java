/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.service;
import br.agrosustentavel.DAO.ConsultaDAO;
import br.agrosustentavel.DAO.ProdutorDAO;
import br.agrosustentavel.Modelo.Consulta;
import br.agrosustentavel.Modelo.Validacao;


/**
 *
 * @author OdirJM
 */
public class ConsultaService {
    
public boolean cadastrarConsulta(
            String produtor,
            String consumoAgua,
            String consumoEnergia,
            String data
    ) {

        if (produtor == null || produtor.isEmpty() || data.isEmpty()) {
            throw new IllegalArgumentException("Produtor e data são obrigatórios");
        }

        if (!Validacao.validarData(data)) {
            throw new IllegalArgumentException("Data inválida");
        }

        if (!consumoAgua.isEmpty() && !consumoAgua.endsWith("L")) {
            consumoAgua += "L";
        }

        if (!consumoEnergia.isEmpty() && !consumoEnergia.endsWith("kWh")) {
            consumoEnergia += "kWh";
        }

        String tipo;
        if (!consumoAgua.isEmpty() && !consumoEnergia.isEmpty()) {
            tipo = "Água/Energia";
        } else if (!consumoAgua.isEmpty()) {
            tipo = "Água";
        } else if (!consumoEnergia.isEmpty()) {
            tipo = "Energia";
        } else {
            throw new IllegalArgumentException("Informe consumo de Água ou Energia");
        }

       ProdutorDAO produtorDAO = new ProdutorDAO();
       String propriedade = produtorDAO.buscarPropriedadePorNome(produtor);


        Consulta nova = new Consulta(
                produtor,
                propriedade,
                tipo,
                data,
                consumoAgua,
                consumoEnergia
        );

      ConsultaDAO dao = new ConsultaDAO();
return dao.inserir(nova);
       
    }
}