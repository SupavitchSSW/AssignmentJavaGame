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
public class Character{
    int hp,mana,atk,def,atkBuff,defBuff,finalAtk,finalDef;
    Vector2 pos = new Vector2();
    Vector2 destinationPos = new Vector2();
    Sprite sprite;
    int nextAction;

    public Character(int x, int y ){
        pos.x = x;
        pos.y = y;
    }

    public boolean goRight(){
        if(pos.x < destinationPos.x){
            pos.x += 6;
            return false;
        }
        else {
            return true;
        }
    }

    public boolean goLeft(){
        if(pos.x > destinationPos.x){
            pos.x -= 6;
            return false;
        }
        else {
            return true;
        }
    }

}
