package com.mygdx.game;

/**
 * Created by root on 1/4/2560.
 */
public class Panda extends Character {

    public Panda(int x, int y) {
        super(x, y);
    }

    @Override
    public void setStatus(){

        if(nextAction == 4){ // heal 200 hp

            hp+=200;
            mana -= 2;
        }
        else if(nextAction == 5){ // drack 400

            atk = 400;
            hp+=400;
            mana -= 4;
        }
        else if(nextAction == 1){ // normal attack 100 Dmg
            atk = 100;
            mana -= 1;
        }
        else if(nextAction == 2){ // defedd 100 Def
            def = 100;
        }
        else if(nextAction == 3){ // charge 1 mana
            mana += 1;
        }else{
            nextAction = 0;
        }

        finalAtk = atk + atkBuff;
        finalDef = def + defBuff;
    }


}
