package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.game.CuttieBattle.batch;

/**
 * Created by root on 1/4/2560.
 */
public class Panda extends Character {

    public Panda(int x, int y, int whoiam) {
        super(x, y,whoiam);
        if(whoiam == 2){
            hpBarPos.x = 0;
            hpBarPos.y = 500;
        }else{
            hpBarPos.x = 1000;
            hpBarPos.y = 500;
            Assest.icebearHpBar.flip(true,false);
        }
    }

    @Override
    public void setStatus(){

        if(nextAction == 4){ // heal 200 hp

            hp+=200;
            mana -= 2;
        }
        else if(nextAction == 5){ // drack 400

            atk = 300;
            hp+=300;
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

        calFinalDamage();
    }
    public void drawHpBar(){
        batch.draw(Assest.pandaHpBar,hpBarPos.x,hpBarPos.y);
    }

    @Override
    public void playSound() {

    }
    private TextureRegion a,b;
    @Override
    public void draw(float time) {
        //batch.draw((TextureRegion)(Assest.pandaAnimation[action].getKeyFrame(time,true)) , pos.x,pos.y);
        a = (TextureRegion)(Assest.pandaAnimation[action].getKeyFrame(time,true));
        if(whoiam == 1 && a.isFlipX() == false &&  b!= a){
            a.flip(true,false);
            b = a;
        }
        batch.draw(a,pos.x,pos.y);
        drawHpBar();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
