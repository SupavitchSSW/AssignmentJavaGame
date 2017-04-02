package com.mygdx.game;

/**
 * Created by root on 1/4/2560.
 */
public class Grizzly extends Character {

    int buffTime = 0;

    public Grizzly(int x, int y) {
        super(x, y);
    }

    @Override
    public void setStatus(){
        if(buffTime > 1){
            atkBuff = 100 ;
            buffTime--;
        }

        if(nextAction == 4){ // skill1 + Atk 100 3turn
            //isBuffActivate = true;
            buffTime += 3;
            atkBuff = 100;
            mana -= 2;
        }
        else if(nextAction == 5){ // skill2 600 Dgm
            //isBuff2Activate = true
            atk = 600;
            mana -= 4;
        }
        else if(nextAction == 1){ // normal attack 150 Dmg
            atk = 150;
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
