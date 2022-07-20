package com.onmyway.enemies;

public class Zombie implements Enemy{

    @Override
    public Integer getAlcance() {
        return 1;
    }

    @Override
    public Integer getMovimento() {
        return 1;
    }

    int move;

    @Override
    public void movimentarInimigo(String[][] mapa, Integer linhas, Integer colunas, Integer x_player, Integer y_player, Integer x_enemy, Integer y_enemy) {

        move = getMovimento();

        System.out.println(move);
        System.out.println("HEH XD");

        int absDistX = Math.abs(x_player - x_enemy);
        int absDistY = Math.abs(y_player - y_enemy);

        if (absDistX < absDistY){
            if (!mapa[x_enemy][y_enemy + move].equals("X")) {

                // garantir o direcionamento correto do inimigo
                if (Math.max(y_player, y_enemy) == x_enemy){
                    Math.negateExact(move);
                }

                mapa[x_enemy][y_enemy] = ".";
                mapa[x_enemy][y_enemy + move] = "Z";
            }
        } else{ // a grande diferença do seu "if" é a preferencia de eixo a se mover
            if (!mapa[x_enemy +move][y_enemy].equals("X")) {
                
                // garantir o direcionamento correto do inimigo
                if (Math.max(x_player, x_enemy) == x_enemy){
                    Math.negateExact(move);
                }

                mapa[x_enemy][y_enemy] = ".";
                mapa[x_enemy + move][y_enemy] = "Z";
            }

        }
        
    }


}
