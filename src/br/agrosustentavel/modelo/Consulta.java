/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.Modelo;

/**
 *
 * @author OdirJM
 */
public class Consulta {
    private int id;
    private String produtor;
    private String propriedade;
    private String tipo;
    private String data;
    private String consumoAgua;
    private String consumoEnergia;

    public Consulta(int id, String produtor, String propriedade, String tipo, String data, String consumoAgua, String consumoEnergia) {
        this.id = id;
        this.produtor = produtor;
        this.propriedade = propriedade;
        this.tipo = tipo;
        this.data = data;
        this.consumoAgua = consumoAgua;
        this.consumoEnergia = consumoEnergia;
    }

    public Consulta(String produtor, String propriedade, String tipo, String data, String consumoAgua, String consumoEnergia) {
        this.produtor = produtor;
        this.propriedade = propriedade;
        this.tipo = tipo;
        this.data = data;
        this.consumoAgua = consumoAgua;
        this.consumoEnergia = consumoEnergia;
    }

    public int getId() {
        return id;
    }

    public String getProdutor() {
        return produtor;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getData() {
        return data;
    }

    public String getConsumoAgua() {
        return consumoAgua;
    }

    public String getConsumoEnergia() {
        return consumoEnergia;
    }
}