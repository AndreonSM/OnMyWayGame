package com.mazetest;

import java.util.Scanner;

import com.openfile.Openfile;

//Note to self: usar uma classe de Fábrica para instanciar os mapas?

public class Maze{

    public static Scanner mazeFile;
    public static Scanner playerScanner;

    // Atribs para construção do mapa
    public static int linhas;
    public static int colunas;
    static String [][] mapa;

    // Atribs para o personagem do jogador
    static int pos_x; 
    static int pos_y; 



    /**
     * Prepara o mapa de acordo com as instruções do arquivo txt lido (mapa pronto)
     * @param 
     * @return void method; não tem retorno
     */
    public static void prepararJogo(){ // RETORNAR O BOLLEAN AQ?
        playerScanner = new Scanner(System.in); // Esse vai ser o Scanner pro jogador/usuario

        mazeFile = Openfile.lerArquivo(mazeFile);
        System.out.println("\t'P' é onde você está; \n\t'X' são paredes; \n\t'.' são locais onde você pode andar.");

        linhas = mazeFile.nextInt();
        colunas = mazeFile.nextInt();

        mazeFile.nextLine(); // Uma mera "pula de linha" para os próximos dados - não soube fazer de outro jeito

        mapa = new String[linhas][colunas]; 

        montarMapa();  
        mazeFile.close();

    }

    private static void montarMapa() {
        for (int i = 0; i < linhas; i++){
            String coladorLinha = mazeFile.nextLine(); 
            for (int j = 0; j < colunas; j++){

                mapa[i][j] = coladorLinha.substring(j, j+1);
                
                if (mapa[i][j].equals("P")){ 
                    pos_x = j; 
                    pos_y = i;
                }
            }
        }
    }
  
    /**
     * Imprime o mapa em seu estado atual no terminal
     * @param 
     * @return void method; não tem retorno
     */
    public static void imprimirMapa(){
        System.out.println("\n### MAPA ATUAL");
        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                System.out.print(mapa[i][j]);
                System.out.print(" ");
        }
        System.out.println();
      }  
    }

    /**
     * Muda a posição do jogador no mapa de acordo com a escolha do jogador no método "mostrarOpcoesJogador()".
     * @param 
     * @return void method; has no return
     */
     public static void atualizarPosicaoJogador(){
        String inputJogador = playerScanner.next(); 
        int mudar_x = 0; 
        int mudar_y = 0;
       
        switch (inputJogador.toLowerCase()){
            // tratamento do y => é só lembrar como os indices de matrizes funcionam...
            case "q": System.exit(0);
            case "w": mudar_x = 0;  mudar_y = -1; break;
            case "s": mudar_x = 0;  mudar_y = 1;  break;
            case "a": mudar_x = -1; mudar_y = 0;  break;
            case "d": mudar_x = 1;  mudar_y = 0;  break;
            //default: System.out.println("Você digitou algo não reconhecível; tente de novo...");
        }

        // Checando se o jogador não tenta sair do mapa

        if (pos_x + mudar_x >= 0 
         && pos_x + mudar_x < colunas 
         && pos_y + mudar_y >=0 
         && pos_y + mudar_y < linhas) {
            // Checando a (im)possibilidade do movimento do jogador

            if (mapa[pos_y+mudar_y][pos_x+mudar_x].equals("X")) {
                System.out.println("Você não pode passar paredes; escolha outra direção!");
            }
            else{// Tudo em ordem; prosseguindo com a atualização do mapa

                mapa[pos_y][pos_x] =".";

                // Teste para gerar a saída do loop do jogo; não vai precisar disso na versão final (hopefully)
                /* if (mapa[pos_y+mudar_y][pos_x+mudar_x].equals("T")) {
                    a = true;
                } */

                pos_x = pos_x + mudar_x; 
                pos_y = pos_y + mudar_y; 
                mapa[pos_y][pos_x] = "P"; 
                System.out.println("Jogada reconhecida; próximo turno!");
            }
        }else{
            System.out.println("Seu comando não está de acordo com o jogo! Tente de novo...");
        }   
    } 

    /**
     * Muda a posição dos inimigos no mapa.
     * @param 
     * @return void method; has no return
     */
    public void atualizarPosicaoInimigos(){
        // TODO
    }


}
    
