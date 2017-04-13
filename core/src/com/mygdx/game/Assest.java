package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.xml.soap.Text;

/**
 * Created by root on 1/4/2560.
 */
public class Assest {

    static Animation grizzlyAnimation[] = new Animation[9];
    static Animation pandaAnimation[] = new Animation[9];
    static Animation iceBearAnimation[] = new Animation[9];
    static TextureRegion grizzlyStatusBar = new TextureRegion(new Texture("assets/pic/Game/GrizzlyHPManamix.png"));
    static TextureRegion pandaStatusBar = new TextureRegion(new Texture("assets/pic/Game/PandaHPManamix.png"));
    static TextureRegion icebearStatusBar = new TextureRegion(new Texture("assets/pic/Game/IcebearHPManamix.png"));
    static TextureRegion grizzlySkill[] = new TextureRegion[6];
    static TextureRegion icebearSkill[] = new TextureRegion[6];
    static TextureRegion pandaSkill[] = new TextureRegion[6];

    static Texture SelectBG = new Texture("assets/pic/Game/characterSelectBG.jpg");
    static Texture gameplayBG = new Texture("assets/pic/Game/gameplayBg.jpg");
    static Texture p1Pin = new Texture("assets/pic/Game/Player1.png");
    static Texture p2Pin = new Texture("assets/pic/Game/Player2.png");
    static Texture grizzlyPreview = new Texture("assets/pic/SkillPreview/GrizzlySkillPreview.png");
    static Texture icebearPreview = new Texture("assets/pic/SkillPreview/IcebearSkillPreview.png");
    static Texture pandaPreview = new Texture("assets/pic/SkillPreview/PandaSkillPreview.png");
    static Sound punchSound = Gdx.audio.newSound(Gdx.files.internal("assets/Punch Sound Effect.mp3"));
    static Music gamePlayBGM = Gdx.audio.newMusic(Gdx.files.internal("assets/sound/music/BG03.wav"));


    public Assest(){
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
    }

    public static void load(){

        //skill button
        for(int i = 0 ;i < 6 ;i++){
            grizzlySkill[i] = new TextureRegion(new Texture("assets/pic/SkillPreview/GrizzlySkillButton"+i+".png"));
        }
        for(int i = 0 ;i < 6 ;i++){
            icebearSkill[i] = new TextureRegion(new Texture("assets/pic/SkillPreview/IcebearSkillButton"+i+".png"));
        }
        for(int i = 0 ;i < 6 ;i++){
            pandaSkill[i] = new TextureRegion(new Texture("assets/pic/SkillPreview/PandaSkillButton"+i+".png"));
        }

        // grizzly standby animation
        TextureRegion grizzlyStandBy[] = new TextureRegion[4];
        grizzlyStandBy[0] = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyStand1.png"));
        grizzlyStandBy[1] = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyStand2.png"));
        grizzlyStandBy[2] = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyStand3.png"));
        grizzlyStandBy[3] = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyStand4.png"));
        grizzlyAnimation[0] = new Animation(0.25f,grizzlyStandBy);

        // grizzly attack
        TextureRegion grizzlyAttack[] = new TextureRegion[2];
        grizzlyAttack[0] = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyAttack1.png"));
        grizzlyAttack[1] = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyAttack2.png"));
        grizzlyAnimation[1] = new Animation(1.25f,grizzlyAttack);

        // grizzly def
        TextureRegion grizzlyDef = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyProtect.png"));
        grizzlyAnimation[2] = new Animation(0.25f,grizzlyDef);

        //grizzly charge
        TextureRegion grizzlyCharge = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyCharge.png"));
        grizzlyAnimation[3] = new Animation(0.25f,grizzlyCharge);

        //grizzly skill 1
        TextureRegion grizzlySkill1 = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlySkill1.png"));
        grizzlyAnimation[4] = new Animation(0.25f,grizzlySkill1);

        //grizzly skill 2
        TextureRegion grizzlySkill2[] = new TextureRegion[12];
        for(int i = 0;i<12;i++){
            String p = "assets/pic/CharacterReal/GrizzlySkill2_"+(i+1)+".png";
            grizzlySkill2[i] = new TextureRegion(new Texture(p));
        }
        grizzlyAnimation[5] = new Animation(0.3f,grizzlySkill2);

        //grizzly hit
        TextureRegion grizzlyHit = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyBroken.png"));
        grizzlyAnimation[6] = new Animation(0.25f,grizzlyHit);

        //grizzly Nomana
        TextureRegion grizzlyNomana = new TextureRegion(new Texture("assets/pic/CharacterReal/GrizzlyFail.png"));
        grizzlyAnimation[7] = new Animation(0.25f,grizzlyNomana);

        //grizzly walk
        grizzlyAnimation[8] = new Animation(0.25f,grizzlyStandBy);

//-------------------------------------------------------------

        // grizzly standby animation
        TextureRegion icebearStandby[] = new TextureRegion[2];
        icebearStandby[0] = new TextureRegion(new Texture("assets/pic/CharacterReal/IcebearStand1.png"));
        icebearStandby[1] = new TextureRegion(new Texture("assets/pic/CharacterReal/IcebearStand2.png"));
        iceBearAnimation[0] = new Animation(0.25f,icebearStandby);

        // grizzly attack
        TextureRegion icebearAttack = new TextureRegion(new Texture("assets/pic/CharacterReal/IcebearAttact.png"));
        iceBearAnimation[1] = new Animation(1.25f,icebearAttack);

        // grizzly def
        TextureRegion icebearDef = new TextureRegion(new Texture("assets/pic/CharacterReal/IcebearProtect.png"));
        iceBearAnimation[2] = new Animation(0.25f,icebearDef);

        //grizzly charge
        TextureRegion icebearCharge = new TextureRegion(new Texture("assets/pic/CharacterReal/IcebearCharge.png"));
        iceBearAnimation[3] = new Animation(0.25f,icebearCharge);

        //grizzly skill 1
        TextureRegion icebearSkill1 = new TextureRegion(new Texture("assets/pic/CharacterReal/icebearSkill1.png"));
        iceBearAnimation[4] = new Animation(0.25f,icebearSkill1);

        //grizzly skill 2
        TextureRegion icebearSkill2 = new TextureRegion(new Texture("assets/pic/CharacterReal/icebearSkill2.png"));
        iceBearAnimation[5] = new Animation(0.4f,icebearSkill2);

        //grizzly hit
        TextureRegion icebearHit = new TextureRegion(new Texture("assets/pic/CharacterReal/IcebearBroken.png"));
        iceBearAnimation[6] = new Animation(0.25f,icebearHit);

        //grizzly Nomana
        TextureRegion icebearNomana = new TextureRegion(new Texture("assets/pic/CharacterReal/icebearFail.png"));
        iceBearAnimation[7] = new Animation(0.25f,icebearNomana);

        //grizzly walk
        iceBearAnimation[8] = new Animation(0.25f,icebearStandby);

//-------------------------------------------------------------

        // grizzly standby animation
        TextureRegion pandaStandby[] = new TextureRegion[2];
        pandaStandby[0] = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaStand1.png"));
        pandaStandby[1] = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaStand2.png"));
        pandaAnimation[0] = new Animation(0.25f,pandaStandby);

        // grizzly attack
        TextureRegion pandaAttack[] = new TextureRegion[2];
        pandaAttack[0] = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaAttact1.png"));
        pandaAttack[1] = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaAttact2.png"));
        pandaAnimation[1] = new Animation(1f,pandaAttack);

        // grizzly def
        TextureRegion pandaDef = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaProtect.png"));
        pandaAnimation[2] = new Animation(0.25f,pandaDef);

        //grizzly charge
        TextureRegion pandaCharge = new TextureRegion(new Texture("assets/pic/CharacterReal/PandanCharge.png"));
        pandaAnimation[3] = new Animation(0.25f,pandaCharge);

        //grizzly skill 1
        TextureRegion pandaSkill1 = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaSkill1.png"));
        pandaAnimation[4] = new Animation(0.25f,pandaSkill1);

        //grizzly skill 2
        TextureRegion pandaSkill2 = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaSkill2.png"));
        pandaAnimation[5] = new Animation(0.4f,pandaSkill2);

        //grizzly hit
        TextureRegion pandaHit = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaBroken.png"));
        pandaAnimation[6] = new Animation(0.25f,pandaHit);

        //grizzly Nomana
        TextureRegion pandaNomana = new TextureRegion(new Texture("assets/pic/CharacterReal/PandaFail.png"));
        pandaAnimation[7] = new Animation(0.25f,pandaNomana);

        //grizzly walk
        pandaAnimation[8] = new Animation(0.25f,pandaStandby);
    }
}
