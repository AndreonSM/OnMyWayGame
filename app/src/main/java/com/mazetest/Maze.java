package com.mazetest;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Note to self: usar uma classe de Fábrica para instanciar os mapas?

public class Maze{

    Scanner mazefileTest;
    Scanner playerScanner;

    // Atribs para construção do mapa
    int linhas;
    int colunas;
    String [][] mapa;

    // Atribs para o personagem do jogador
    int pos_x; 
    int pos_y; 

    // Apenas parar testar o fim do laço "comecarJogo()", mais abaixo; na versão final, idealiza-se não existir!
    boolean localObjetivo;

    /**
     * Construtor padrão da classe; feito assim para automatizar o início de jogo
     */
    public Maze(){
        prepararJogo(); 
        comecarJogo();
        mazefileTest.close();
        playerScanner.close();  
    }

    /**
     * Prepara o mapa de acordo com as instruções do arquivo txt lido (mapa pronto)
     * @param 
     * @return void method; não tem retorno
     */
    public void prepararJogo(){
        playerScanner = new Scanner(System.in); // Esse vai ser o Scanner pro jogador/usuario

        // Scanneando o arquivo txt com os dados de construção do mapa 

        try{
            mazefileTest = new Scanner(new File("app/src/main/resources/mapa.txt"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.err.println("ERRO: O arquivo não pode ser encontrado...");
            System.out.println("*** Encerrando abruptamente o jogo ****");
        }

        System.out.println("O arquivo foi lido com sucesso.");
        System.out.println("QUE O JOGO COMECE!");
        System.out.println("******************");

        System.out.println("'P' é onde você está; \n 'X' são paredes; \n '.' são locais onde você pode andar.");

        // Construindo o mapa com os dados lidos

        linhas = mazefileTest.nextInt();
        colunas = mazefileTest.nextInt();

        mazefileTest.nextLine(); // Uma mera "pula de linha" para os próximos dados - não soube fazer de outro jeito

        mapa = new String[linhas][colunas]; 

        for (int i = 0; i < linhas; i++){
            String coladorLinha = mazefileTest.nextLine(); 
            for (int j = 0; j < colunas; j++){

                mapa[i][j] = coladorLinha.substring(j, j+1);
                
                if (mapa[i][j].equals("P")){ 
                    pos_x = j; 
                    pos_y = i;
                }
            }
        }  
        localObjetivo = false;
    }

  
    /**
     * Imprime o mapa em seu estado atual no terminal
     * @param 
     * @return void method; não tem retorno
     */
    public void imprimirMapa(){
        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                System.out.print(mapa[i][j]);
                System.out.print(" ");
        }
        System.out.println();
      }  
    }

    
    /**
     * Inicia um turno do jogador, mostrando as opções que ele tem 
     * @param 
     * @return void method; has no return
     */
    public void mostrarOpcoesJogador(){
        System.out.println("******************");
        System.out.println("Você pode ir para:");
        System.out.println("W) Cima");
        System.out.println("S) Baixo");
        System.out.println("A) Esquerda");
        System.out.println("D) Direita");
        System.out.println("Q) Sair do jogo"); 
        System.out.println("******************");
        System.out.print("Escolha:");     
    }

    /**
     * Muda o mapa de acordo com a escolha do jogador no método "mostrarOpcoesJogador()"
     * @param 
     * @return void method; has no return
     */
    public void atualizarPosicaoJogador(String inputJogador){
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
                if (mapa[pos_y+mudar_y][pos_x+mudar_x].equals("T")) {
                    localObjetivo = true;
                }

                pos_x = pos_x + mudar_x; 
                pos_y = pos_y + mudar_y; 
                mapa[pos_y][pos_x] = "P"; 
            }
        }else{
            System.out.println("Seu comando não está de acordo com o jogo! Tente de novo...");
        }   
    }

    /**
     * Método responsável por iniciar e "segurar" o laço do jogo
     * @param 
     * @return void method; has no return
     */
    public void comecarJogo(){
        while (!localObjetivo){
            imprimirMapa(); 
            mostrarOpcoesJogador();
            String userInput = playerScanner.next(); 
            atualizarPosicaoJogador(userInput);
        }
        
        imprimirMapa();     
        System.out.println("É isso aí, você conseguiu!!!!");  
    }

    public static void main(String[] args){
        Maze m = new Maze();
        
    }

}
    
