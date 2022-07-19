package com.onmyway.enemies;

public enum EnumEnemy {
    WASPS("W"), ZOMBIE("Z");

    private final String monsterType;
    
    EnumEnemy(String str){
        monsterType = str;
    }

    public String getMonsterType(){
        return monsterType;
    }
}
