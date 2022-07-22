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

        //double absDist = Math.sqrt((Math.pow((x_player - x_enemy), 2) + Math.pow((y_enemy - y_player),2)));
        
        double slope_Y_To_X_Walk_Rate;

        if(x_player - x_enemy != 0)
            slope_Y_To_X_Walk_Rate = (y_enemy - y_player) / (x_player - x_enemy); 
        else
            slope_Y_To_X_Walk_Rate = (y_enemy - y_player);

        if (x_enemy + move >= 0 
         && x_enemy + move < colunas
         && y_enemy + move >=0 
         && y_enemy + move < linhas) {
            if (slope_Y_To_X_Walk_Rate >= 1){ // "se precisar andar mais em Y do que em X..."
                if (! mapa[x_enemy][y_enemy + move].equals("X")) {

                    // garantir o direcionamento correto do inimigo
                    if (Math.max(y_player, y_enemy) == y_enemy){
                        if (move > 0)
                            move = move * (-1);
                    
                        System.out.println(move);
                    }
                    if (! mapa[x_enemy + move][y_enemy].equals("X")){
                        mapa[x_enemy][y_enemy] = ".";
                        mapa[x_enemy + move][y_enemy] = "Z";
                    }
                    else{
                        mapa[x_enemy][y_enemy] = ".";
                        mapa[x_enemy][y_enemy - move] = "Z";
                    }
                }
            } else{ // a grande diferença do seu "if" é a preferencia de eixo a se mover
                if (! mapa[x_enemy + move][y_enemy].equals("X")) {
                
                    // garantir o direcionamento correto do inimigo
                    if (Math.max(x_player, x_enemy) == x_enemy){
                        if (move > 0)
                            move = move * (-1);
                    
                        System.out.println(move);
                    }
                    if (! mapa[x_enemy + move][y_enemy].equals("X")){
                        mapa[x_enemy][y_enemy] = ".";
                        mapa[x_enemy][y_enemy + move] = "Z";
                    }
                    else{
                        mapa[x_enemy][y_enemy] = ".";
                        mapa[x_enemy - move][y_enemy] = "Z";
                    }
                }
                

            }

            // verificar se o Zombie mexeu
            if (! mapa[x_enemy][y_enemy].equals(".")) {
                // Discontinued
            }
        } 
        
    }


}
