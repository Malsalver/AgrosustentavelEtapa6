/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.Modelo;

/**
 *
 * @author OdirJM
 */
public class Produtor {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String propriedade;

    public Produtor(int id, String nome, String cpf, String telefone, String endereco, String propriedade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.propriedade = propriedade;
    }

    public Produtor(String nome, String cpf, String telefone, String endereco, String propriedade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.propriedade = propriedade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPropriedade() {
        return propriedade;
    }
}