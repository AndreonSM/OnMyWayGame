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

    /**
     * É a função que dita quantas unidades de espaço o inimigo pode se mover
     * @return quantidade de passos do inimigo
     */                          
    public Integer getMovimento();

    /**
     * É a função que dita o alcance de ataque (em unidades de distância do mapa) de um inimigo em relação ao jogador
     * @return alcance do inimigo
     */
    public Integer getAlcance();

    /**
     * É o método que dita, quando chamado, se o jogador pode (ou não) ser morto por um inimigo. 
     * @param enemy inimigo analisado
     * @param mapa o mapa do jogo
     * @param x_player posição x do jogador
     * @param y_player posição y do jogador
     * @param x_enemy posição x do inimigo
     * @param y_enemy posição y do inimigo
     * @return true, se o jogador pode ser morto; false, caso contrário
     */
    public static boolean podeMatarPlayer(Enemy enemy, String[][] mapa, Integer x_player, Integer y_player, Integer x_enemy, Integer y_enemy){
        if (x_player == x_enemy ) {
            return checarObstaculos(enemy, mapa, y_player, y_enemy);
        } else if (y_player == y_enemy){
            return checarObstaculos(enemy, mapa, x_player, x_enemy);
        } else
            return false;

    }

    /**
     * Método auxiliar que checa a distância entre um jogador e um dado inimigo que está na mesma linha ou coluna que ele
     * @param enemy inimigo analisados
     * @param mapa o mapa do jogo
     * @param pos_player posição do jogador
     * @param pos_enemy posição do inimigo
     * @return true, caso o jogador esteja no alcançe do monstro; false, caso contrário
     */
    public static boolean checarObstaculos(Enemy enemy, String[][] mapa, Integer pos_player, Integer pos_enemy) {
        if(Math.abs((pos_player - pos_enemy)) <= enemy.getAlcance()){
            return true;
        }

        return false;
    }
  
    /**
     * É a função remove o caractere do jogador do mapa, efetivamente matando-o.
     * @param mapa a matriz que representa o mapa do jogo
     * @param linhas qtd de linhas
     * @param colunas qtd de colunas
     * @param x_player LINHA em que o JOGADOR, que o inimigo vai matar, está
     * @param y_player COLUNA em que o JOGADOR, que o inimigo vai matar, está
     */
    public static void matarPlayer(String[][] mapa, Integer x, Integer y){

       mapa[x][y] = "D";
                                
    }

   

    

}
