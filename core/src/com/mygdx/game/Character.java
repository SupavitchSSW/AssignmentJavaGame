package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by root on 29/3/2560.
 */

/*
    0 standby
    1 attack
    2 defend
    3 charge
    4 skill 1
    5 skill 2
    6 hit
    7 Nomana
    8 move
*/


public abstract class Character{
    int hp = 1000,mana = 0,atk,def,atkBuff,defBuff,finalAtk,finalDef;
    Vector2 pos = new Vector2();
    Vector2 destinationPos = new Vector2();
    Sprite sprite;
    int nextAction;
    int action;
    int whoiam = 0;

    public Character(int x, int y ,int whoiam){
        pos.x = x;
        pos.y = y;
        this.whoiam = whoiam;
    }

    public boolean goRight(){
        action = 8;
        if(pos.x < destinationPos.x){
            pos.x += 6;
            return false;
        }
        else {
            return true;
        }
    }

    public boolean goLeft(){
        action = 8;
        if(pos.x > destinationPos.x){
            pos.x -= 6;
            return false;
        }
        else {
            return true;
        }
    }

    public void checkMana(){
        switch (nextAction){
            case 1: {
                if (mana - 1 < 0) {
                    nextAction = 7;
                    System.out.println("not enought Mana");
                }
                break;
            }
            case 4:{
                if(mana - 2 < 0){
                    nextAction = 7;
                    System.out.println("not enought Mana");
                }
                break;
            }
            case 5:{
                if(mana - 4 < 0){
                    nextAction = 7;
                    System.out.println("not enought Mana");
                }
            }
        }
        action = nextAction;
    }

    public abstract void setStatus();

    public abstract void draw(float time);

    public void resetStatus(){
        atk = 0;
        def = 0;
        atkBuff = 0;
        defBuff = 0;
        finalDef = 0;
        finalAtk = 0;
        nextAction = 0;
    }

    public void calFinalDamage(){
        if(atk > 0 ){
            finalAtk = atk + atkBuff;
        }
        else {
            finalAtk =0;
        }

        if(def > 0){
            finalDef = def + defBuff;
        }else{
            finalDef = 0;
        }
    }

    public boolean takeDamage(int dmg){
        // hit
        int d = this.finalDef - dmg;
        if(d < 0){
            hp += d;
            return true;
        }
        return false;
    }

    public boolean isDeath(){
        if(hp <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setDestinationPos(int x ,int y){
        destinationPos.x = x;
        destinationPos.y = y;
    }

    abstract public void playSound();

    @Override
    public String toString() {
        return this.hp+"/"+this.mana;
    }
}
