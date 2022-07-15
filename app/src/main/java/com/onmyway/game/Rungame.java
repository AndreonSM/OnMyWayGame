package com.onmyway.game;

import com.mazetest.Maze;
import com.onmyway.player.Player;

public class Rungame {

    /**
     * Método responsável por iniciar e "segurar" o laço do jogo
     * @param 
     * @return void method; has no return
     */
    public static void comecarJogo(boolean a){
        while (!a){
            Maze.imprimirMapa(); 
            Player.mostrarOpcoesJogador();
            Maze.atualizarPosicaoJogador();
            // movimentoInimigo

        }
        
        Maze.imprimirMapa();     
        System.out.println("É isso aí, você conseguiu!!!!");  
    }
}
