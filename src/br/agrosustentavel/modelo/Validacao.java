/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author OdirJM
 */
public class Validacao {
    
    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", ""); // Remove pontos, traços etc.
        return cpf.matches("\\d{11}"); // Verifica se tem 11 dígitos numéricos
    }

    public static boolean validarTelefone(String telefone) {
        telefone = telefone.replaceAll("[^\\d]", ""); // Remove parênteses, hífen etc.
        return telefone.matches("\\d{10,11}"); // Aceita 10 ou 11 dígitos (com/sem DDD)
    }

    public static boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
