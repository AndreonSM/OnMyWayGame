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

    int move = getMovimento();

    @Override
    public void movimentarInimigo(String[][] mapa, Integer linhas, Integer colunas, Integer x_player, Integer y_player, Integer x_enemy, Integer y_enemy) {

        System.out.println(move);
        System.out.println("movimentando inimigos: ");
        System.out.println("X PLAYER: " + x_enemy);
        System.out.println("Y PLAYER: " + y_enemy);

        System.out.println("X E: " + x_player);
        System.out.println("Y E: " + y_player);

        int absDistX = Math.abs(y_player - x_enemy);
        int absDistY = Math.abs(x_player - y_enemy);

        if (x_enemy + move >= 0 
         && x_enemy + move < colunas
         && y_enemy + move >=0 
         && y_enemy + move < linhas) {
            if (absDistX < absDistY){
                if (! mapa[x_enemy][y_enemy + move].equals("X")) {

                    // garantir o direcionamento correto do inimigo
                    if (Math.max(y_player, x_enemy) == x_enemy){
                        if (move > 0)
                            move = move * (-1);
                    
                        System.out.println(move);
                    }

                    mapa[x_enemy][y_enemy] = ".";
                    mapa[x_enemy + move][y_enemy] = "Z";
                }
            } else{ // a grande diferença do seu "if" é a preferencia de eixo a se mover
                if (! mapa[x_enemy + move][y_enemy].equals("X")) {
                
                    // garantir o direcionamento correto do inimigo
                    if (Math.max(x_player, y_enemy) == y_enemy){
                        if (move > 0)
                            move = move * (-1);
                    
                        System.out.println(move);
                    }

                    mapa[x_enemy][y_enemy] = ".";
                    mapa[x_enemy][y_enemy + move] = "Z";
                }

            }
        } 
        
    }


}
