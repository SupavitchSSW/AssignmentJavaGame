package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.game.CuttieBattle.batch;

/**
 * Created by root on 1/4/2560.
 */
public class Grizzly extends Character {

    int buffTime = 0;

    public Grizzly(int x, int y, int whoiam) {
        super(x, y,whoiam);
    }

    @Override
    public void setStatus(){
        action = nextAction;
        if(buffTime > 0){
            atkBuff += 100 ;
            buffTime--;
        }

        if(action == 4){ // skill1 + Atk 100 3turn
            //isBuffActivate = true;
            buffTime += 3;
            atkBuff += 100;
            mana -= 2;
        }
        else if(action == 5){ // skill2 600 Dgm
            //isBuff2Activate = true
            atk += 600;
            mana -= 4;
        }
        else if(action == 1){ // normal attack 150 Dmg
            atk += 150;
            mana -= 1;
        }
        else if(action == 2){ // defedd 100 Def
            def += 100;
        }
        else if(action == 3){ // charge 1 mana
            mana += 1;
        }else {
            action = 0;
        }

        calFinalDamage();
    }

    @Override
    public void playSound() {
        if(action == 1){
            assest.punchSound.play(1.0f);
        }
    }

    @Override
    public void draw(float time) {
        batch.draw((TextureRegion)(assest.grizzlyAnimation[action].getKeyFrame(time,true)) , pos.x,pos.y);
    }

    @Override
    public String toString() {
        return "HP:"+this.hp+" MP:"+this.mana+" nextAction:"+this.nextAction+" atk:"+this.atk+" atkBuff:"+this.atkBuff+" finalAtk:"+this.finalAtk+" def:"+this.def+" defBuff"+this.defBuff+" finalDef:"+this.finalDef + " bufftime:"+buffTime;
    }
}
