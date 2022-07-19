package com.onmyway.enemies;

public class EnemyFactory {
    
    private String picker;
    private Enemy enemy;

    EnemyFactory(String pick){
        this.picker = pick;
    }
    
    public Enemy criarEnemy(){
        
        switch (picker) {
            case "W":
                enemy = new SwarmOfWasps();
                break;  
            default:
                enemy = new Zombie(); 
                break;
        }
     
        return enemy;

    }

    
}
