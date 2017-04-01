package com.mygdx.game;

/**
 * Created by root on 1/4/2560.
 */
public class Grizzly extends Character {

    int buffTime1 = 0;

    public Grizzly(int x, int y) {
        super(x, y);
    }


    public void setStatus(){
        if(buffTime1 > 1){
            defBuff = 100;
            buffTime1--;
        }
        if(nextAction == 4) { // skill1 + atk 100 3turn
            //isBuffActivate = true;
            buffTime1 += 3;
            atkBuff = 100;
        }
        else if(nextAction == 5){ // skill2 600
            atkBuff = 50;
            atk = 300;
        }
        else if(nextAction == 1){ // normal attack 100 Dmg
            atk = 100;
        }
        else if(nextAction == 2){ // defedd 100 Def
            def = 100;
        }
        else if(nextAction == 3) { // charge 2 mana
            mana += 2;
        }

        finalAtk = atk + atkBuff;
        finalDef = def + defBuff;
    }

    public void reSetStatus(){
        atk = 0;
        def = 0;
        finalDef = 0;
        finalAtk = 0;

    }

}
