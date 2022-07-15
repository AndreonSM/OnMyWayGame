package com.onmyway.game;

import com.mazetest.Maze;
import com.onmyway.player.Player;

public class Rungame {

    public static final int QTD_MAX_TURNOS = 10;

    /**
     * Construtor padrão da classe; feito assim para automatizar o início de jogo
     */
    public Rungame(){
        Maze.prepararJogo();
        comecarJogo();
    }


    /**
     * Método responsável por iniciar e "segurar" o laço do jogo
     * @param 
     * @return void method; has no return
     */
    public static void comecarJogo(){
        int turno_atual = 1;
        while (turno_atual <= QTD_MAX_TURNOS){
            System.out.println("\nTURNO " + turno_atual + "!");
            Maze.imprimirMapa(); 
            Player.mostrarOpcoesJogador();
            Maze.atualizarPosicaoJogador();
            // movimentoInimigo
            turno_atual++;

        }
        
        Maze.imprimirMapa();     
        System.out.println("É isso aí, você conseguiu!!!!");  
    }

    public static void main(String[] args){
        new Rungame();
        
    }
}
