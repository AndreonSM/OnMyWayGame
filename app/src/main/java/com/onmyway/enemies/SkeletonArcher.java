package com.onmyway.enemies;

public class SkeletonArcher implements Enemy{
    
    @Override
    public void movimentarInimigo(String[][] mapa, Integer linhas, Integer colunas, Integer x_player, Integer y_player, Integer x_enemy, Integer y_enemy) {
  
    }

    @Override
    public Integer getAlcance() {
        return 2;
    }

    @Override
    public Integer getMovimento() {
        return 1;
    }
}