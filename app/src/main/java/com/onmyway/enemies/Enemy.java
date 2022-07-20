package com.onmyway.enemies;

public interface Enemy {
    // para a versão criada aleatoriamente!

    /**
     * É a função que contém a lógica de movimento no mapa de cada inimigo do jogo; função auxiliar de atualizarPosicaoInimigos()
     * @param mapa a matriz que representa o mapa do jogo
     * @param linhas qtd de linhas
     * @param colunas qtd de colunas
     * @param x_player LINHA em que o JOGADOR, que o inimigo vai caçar, está
     * @param y_player COLUNA em que o JOGADOR, que o inimigo vai caçar, está
     * @param x_enemy LINHA em que o INIMIGO está
     * @param y_enemy COLUNA em que o INIMIGO está
     */
    public void movimentarInimigo(String[][] mapa, Integer linhas, Integer colunas, 
                                  Integer x_player, Integer y_player, 
                                  Integer x_enemy, Integer y_enemy);


}
