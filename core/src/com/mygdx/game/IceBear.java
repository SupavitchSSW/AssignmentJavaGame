package com.mygdx.game;

/**
 * Created by root on 1/4/2560.
 */
public class IceBear extends Character {
//    boolean isBuffActivate = false;
//    boolean isBuff2Activate = false;
    int buffTime1 = 0;
    int buffTime2 = 0;

    public IceBear(int x, int y) {
        super(x, y);
    }

    public void checkMana(){
        switch (nextAction){
            case 1: {
                if (mana - 1 < 0) {
                    nextAction = 7;
                }
                break;
            }
            case 4:{
                if(mana - 2 < 0){
                    nextAction = 7;
                }
                break;
            }
            case 5:{
                if(mana - 4 < 0){
                    nextAction = 7;
                }
            }
        }
    }

    public void setStatus(){
        if(buffTime1 > 1){
            defBuff = 100;
            buffTime1--;
        }
        if(buffTime2 > 1){
            atkBuff = 50;
            buffTime2--;
        }
        if(nextAction == 4){ // skill1 + Def 100 3turn
            //isBuffActivate = true;
            buffTime1 += 3;
            defBuff = 100;
            mana -= 2;
        }
        else if(nextAction == 5){ // skill2 300 Dmg + 50 posion 2 turn
            //isBuff2Activate = true;
            buffTime2 += 2;
            atkBuff = 50;
            atk = 300;
            mana -= 4;
        }
        else if(nextAction == 1){ // normal attack 100 Dmg
             atk = 100;
             mana -= 1;
        }
        else if(nextAction == 2){ // defedd 100 Def
            def = 100;
        }
        else if(nextAction == 3){ // charge 2 mana
            mana += 2;
        }else{
          nextAction = 0;
        }

        finalAtk = atk + atkBuff;
        finalDef = def + defBuff;
    }

    public void resetStatus(){
        atk = 0;
        def = 0;
        finalDef = 0;
        finalAtk = 0;
    }


}
