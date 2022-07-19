package com.onmyway.player;

public class Player {
    
    String name;

    /**
     * Inicia um turno do jogador, mostrando as opções que ele tem 
     * @param 
     * @return void method; has no return
     */
    public static void mostrarOpcoesJogador(){
        System.out.println("******************");
        System.out.println("Você pode ir para:");
        System.out.println("W) Cima");
        System.out.println("S) Baixo");
        System.out.println("A) Esquerda");
        System.out.println("D) Direita");
        System.out.println("Q) Sair do jogo"); 
        System.out.println("******************");
        System.out.print("Escolha: ");     
    }

    
}
