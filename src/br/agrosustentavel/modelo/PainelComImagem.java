/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.agrosustentavel.Modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author OdirJM
 */
public class PainelComImagem extends JPanel {

    private Image imagem;

    public PainelComImagem() {
        try {
            // Carregar a imagem (coloque o caminho correto da imagem)
            imagem = ImageIO.read(new File("F:\\odair\\Odair curso\\estudo\\Curso Tecnico Desenvolvimento de Sistemas\\atividade para mes 7\\etapa 3\\logo.png"));
        } catch (IOException e) {
            e.printStackTrace();  // Caso a imagem não seja carregada, exibe o erro
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        if (imagem != null) {
            // Redimensionar a imagem para um tamanho menor (exemplo: 100x100 pixels)
            Image imagemRedimensionada = imagem.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            
            // Desenhar a imagem redimensionada no canto superior esquerdo
            g.drawImage(imagemRedimensionada, 0, 0, this);  // A imagem será desenhada na posição (0,0)
        }
    }
}