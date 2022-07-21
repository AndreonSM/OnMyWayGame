package com.mazetest;

import java.util.Scanner;

import com.filemanager.Filemanager;
import com.onmyway.enemies.*;

//Note to self: usar uma classe de Fábrica para instanciar os mapas?

public class Maze{

    public static Scanner mazeFile;
    public static Scanner playerScanner;

    // Atribs para construção do mapa
    public static int linhas;
    public static int colunas;
    public static String [][] mapa;

    // Atribs para o personagem do jogador
    static int pos_x; // COLUNA
    static int pos_y; // LINHA

    static int pos_x_enemy;
    static int pos_y_enemy;

    /**
     * Prepara o mapa de acordo com as instruções do arquivo txt lido (mapa pronto)
     * @param 
     * @return void method; não tem retorno
     */
    public static void prepararJogo(){ 
        playerScanner = new Scanner(System.in); // Esse vai ser o Scanner pro jogador/usuario

        mazeFile = Filemanager.abrirArquivo(mazeFile);
        System.out.println("\t'P' é onde você está; \n\t'X' são paredes; \n\t'.' são locais onde você pode andar.");

        linhas = mazeFile.nextInt();
        colunas = mazeFile.nextInt();

        mazeFile.nextLine(); // Uma mera "pula de linha" para os próximos dados - não soube fazer de outro jeito

        mapa = new String[linhas][colunas]; 

        montarMapa();  
        Filemanager.fecharArquivo(mazeFile);

    }

    /**
     * Faz o trabalho bruto de preencher a matriz com os elementos do mapa; função auxiliar (refatorada)
     * @param 
     * @return void method; não tem retorno
     */
    private static void montarMapa() {
        for (int i = 0; i < linhas; i++){
            String coladorLinha = mazeFile.nextLine(); 
            for (int j = 0; j < colunas; j++){

                mapa[i][j] = coladorLinha.substring(j, j+1);
                
                // para que não tenha problemas com duplicação de "P", usa-se o equals();
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
        System.out.println("Jogador na coluna " + pos_x);

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
     * @return -1, se for uma jogada inválida; 1, caso contrário
     */
     public static Integer atualizarPosicaoJogador(){ // retorno adicionado para permitir a passagem de turno apenas com jogadas válidas
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
            default: System.out.println("Você digitou algo não reconhecível; tente de novo..."); return -1;
        }

        // Checando se o jogador não tenta sair do mapa
        if (pos_x + mudar_x >= 0 
         && pos_x + mudar_x < colunas
         && pos_y + mudar_y >=0 
         && pos_y + mudar_y < linhas) {

            // Checando a (im)possibilidade do movimento do jogador
            if (mapa[pos_y + mudar_y][pos_x + mudar_x].equals("X")) {
                System.out.println("Você não pode passar paredes; escolha outra direção!");
                return -1;
            }
            else{// Tudo em ordem; prosseguindo com a atualização do mapa

                mapa[pos_y][pos_x] =".";

                pos_x = pos_x + mudar_x; 
                pos_y = pos_y + mudar_y; 
                mapa[pos_y][pos_x] = "P"; 
                
                System.out.println("Jogada reconhecida; próximo turno!");
                return 1;
            }
        }else{
            System.out.println("Seu comando não está de acordo com o jogo! Tente de novo...");
            return -1;
        }   
    } 


    public static Enemy e = new Zombie();

    /**
     * Muda a posição dos inimigos no mapa.
     * @param 
     * @return void method; has no return
     */
    public static void atualizarPosicaoInimigos(){
        // TODO
 
       System.out.println("ELES SE MOVEM RÁPIDO...");

       for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                 if (mapa[i][j].equals("Z")){
                    pos_x_enemy = i;
                    pos_y_enemy = j;
                    // TO SELF: fazer um switch que caça os caracteres de Enemy, joga os que encontrar numa lista (GENERICS), movimente-os fora!
                    
                }  
                
          
            }
            
        }
        e.movimentarInimigo(mapa, linhas, colunas, pos_x, pos_y, pos_x_enemy, pos_y_enemy);
   
    }

    public static void checarVida(){
        if(Enemy.podeMatarPlayer(e, mapa, pos_x, pos_y, pos_x_enemy, pos_y_enemy)){
            Enemy.matarPlayer(mapa, pos_x, pos_y);
        }
    }



    /**
     * Checa a existência do personagem/caractere do jogador no mapa.
     * @return true, se existir; false, caso contrário.
     */
    public static boolean isPlayerVivo(){

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                 if (mapa[i][j].equals("P")){
                    return true;
                }  
          
            }
        }

        return false;

    }


}
    
