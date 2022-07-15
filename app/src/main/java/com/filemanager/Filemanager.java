package com.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filemanager {

    private static final String caminhoArquivo = "app/src/main/resources/mapa.txt";

    /**
     * Lê um arquivo designado na variável "caminhoArquivo"; faz com que o scanner do mapa aponte para o arquivo determinado
     * @param mazeFile é o scanner especifico para ler as instruções de construção do mapa
     * @return o mesmo scanner
     */
    public static Scanner abrirArquivo(Scanner mazeFile){
        try{
            mazeFile = new Scanner(new File(caminhoArquivo));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.err.println("ERRO: O arquivo não pode ser encontrado...");
            System.out.println("*** Encerrando abruptamente o jogo ****\n");
        }

        System.out.println("O arquivo foi lido com sucesso.");
        System.out.println("QUE O JOGO COMECE!");
        System.out.println("******************\n");

        return mazeFile;
    }

    public static void fecharArquivo(Scanner file){
        file.close();
    }
}
