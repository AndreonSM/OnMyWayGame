package com.onmyway.game;

import com.mazetest.Maze;
import com.onmyway.player.Player;

public class Rungame {

    public static final int QTD_MAX_TURNOS = 10;

    /**
     * Construtor padrão da classe; feito assim para automatizar o início de jogo
     */
    public Rungame(){
        //Maze jogo = new Maze();
        Maze.prepararJogo();
        runGame();
    }


    /**
     * Método responsável por iniciar e "segurar" o laço do jogo
     * @param 
     * @return void method; has no return
     */
    public static void runGame(){
        int turno_atual = 1;
        while (turno_atual <= QTD_MAX_TURNOS){

            System.out.println("\nTURNO " + turno_atual + "!");
            
            Maze.imprimirMapa(); 

            Player.mostrarOpcoesJogador();

            Integer isJogadaOK;
            isJogadaOK = Maze.atualizarPosicaoJogador();
            
            if(isJogadaOK == 1){
                Maze.atualizarPosicaoInimigos();
                turno_atual++;
            }

            if (Maze.isPlayerVivo()){
                continue;
            }
            else{
                break;
            }


        }
        
        mensagemEncerramentoJogo();  
    }


    private static void mensagemEncerramentoJogo() {
        Maze.imprimirMapa();     
        System.out.println("É isso aí, você conseguiu!!!!");
    }

    /**
     * Função que inicia o jogo em si!
     * 
     */
    public static void main(String[] args){
        new Rungame();
        
    }
}
