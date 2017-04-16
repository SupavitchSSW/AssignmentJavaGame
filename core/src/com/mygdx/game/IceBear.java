package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.game.BearsBattle.batch;

/**
 * Created by root on 1/4/2560.
 */
public class IceBear extends Character {
    //    boolean isBuffActivate = false;
//    boolean isBuff2Activate = false;
    int buffTime1 = 0;
    int buffTime2 = 0;

    public IceBear(int x, int y, int whoiam) {
        super(x, y, whoiam);
        if (whoiam == 1) {
            statusBarPos.x = 0;
            statusBarPos.y = 500;
            hpBarPos.add(statusBarPos.x+366,statusBarPos.y+190);
            manaBarPos.add(statusBarPos.x+30,statusBarPos.y+138);
            skillButtonPos.add(0,0);
            if(Assest.icebearStatusBar.isFlipX() == true){
                Assest.icebearStatusBar.flip(true,false);
            }
        } else {
            statusBarPos.x = 1000;
            statusBarPos.y = 500;
            skillButtonPos.add(1600-405,0);
            if(Assest.icebearStatusBar.isFlipX() != true ){
                Assest.icebearStatusBar.flip(true,false);
            }
            hpBarPos.add(statusBarPos.x+600-366,statusBarPos.y+190);
            manaBarPos.add(statusBarPos.x+457,statusBarPos.y+138);
        }
    }


    @Override
    public void setStatus() {
        //System.out.println("Ice bear Set status");
        if (buffTime1 > 0) {
            def += 100;
            buffTime1--;
        }
        if (buffTime2 > 0) {
            atk += 50;
            buffTime2--;
        }
        if (nextAction == 4) { // skill1 + Def 100 3turn
            //isBuffActivate = true;
            buffTime1 += 2;
            def += 100;
            mana -= 2;
        } else if (nextAction == 5) { // skill2 300 Dmg + 50 posion 2 turn
            //isBuff2Activate = true;
            buffTime2 += 2;
            atk += 50;
            atk += 300;
            mana -= 4;
        } else if (nextAction == 1) { // normal attack 100 Dmg
            atk += 100;
            mana -= 1;
        } else if (nextAction == 2) { // defend 100 Def
            def += 100;
        } else if (nextAction == 3) { // charge 2 mana
            if(mana < 4){
                mana += 2;
            } else if(mana == 4){
                mana += 1;
            }
        } else {
            nextAction = 0;
        }

        calFinalDamage();


    }

    public void drawStatusBar(){
        batch.draw(Assest.icebearStatusBar,statusBarPos.x,statusBarPos.y);
        int hpW = hpBar.getRegionWidth()*hp/1000;
        if(hp <= 0){
            hpW = 0;
        }
        if(whoiam == 2){
            hpW *= -1;
        }
        batch.draw(hpBar,hpBarPos.x,hpBarPos.y,hpW,hpBar.getRegionHeight());
        batch.draw(manaBar[mana],manaBarPos.x,manaBarPos.y);
    }


    @Override
    public void drawSkillButton(){
        int a = nextAction;
        if(nextAction > 5){
            a = 0;
        }
        batch.draw(Assest.icebearSkill[a],skillButtonPos.x,skillButtonPos.y);
    }

    @Override
    public void playSound() {
        switch (action){
            case 1:
                Assest.punchSound.play(1.0f);
                break;
            case 2:
                Assest.defenseSound.play(1.0f);
                break;
            case 3:
                Assest.chargeManaSound.play(1.0f);
                break;
            case 4:
                Assest.icebearSkill1Sound.play(1.0f);
                break;
            case 5:
                Assest.icebearSkill2Sound.play(1.0f);
                break;
        }
    }

    private TextureRegion a, b;

    @Override
    public void draw(float time) {
        //batch.draw((TextureRegion)(Assest.iceBearAnimation[action].getKeyFrame(time,true)) , pos.x,pos.y);
        a = (TextureRegion) (Assest.iceBearAnimation[action].getKeyFrame(time, true));
        if (whoiam == 1 && a.isFlipX() == false && b != a) {
            a.flip(true, false);
            b = a;
        }
        batch.draw(a, pos.x, pos.y);
        drawStatusBar();
        drawSkillButton();
    }

    @Override
    public String toString() {
        return super.toString() + " buffTime1:" + buffTime1 + " bufftime2:" + buffTime2;
    }
}
