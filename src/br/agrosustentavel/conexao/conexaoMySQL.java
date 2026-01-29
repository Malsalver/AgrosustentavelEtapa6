/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;
/**
 *  responsável pela conexão com o banco de dados.
 * @author OdirJM
 */
public class conexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/agrosustentavel";
    private static final String USUARIO = "root";
    private static final String SENHA = "Bbradoke80*";

    public static java.sql.Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
        /**
         * ('admin', '1234'),
('odir', 'senha123'),
('teste', 'teste');
         */
        }
}