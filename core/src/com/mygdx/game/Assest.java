package com.mygdx.game;

import com.badlogic.gdx.Gdx;
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
    public static Texture badlogic = new Texture("badlogic.jpg");
    TextureRegion grizzlyStandBy = new TextureRegion(new Texture("2.jpg"));
    TextureRegion grizzlyAttack1 = new TextureRegion(new Texture("pandaAttack1.png"));
    TextureRegion grizzlyAttack2 = new TextureRegion(new Texture("pandaAttack2.png"));
    Sound punchSound = Gdx.audio.newSound(Gdx.files.internal("Punch Sound Effect.mp3"));

    public Assest(){
        grizzlyAnimation[0] = new Animation(0.25f,grizzlyStandBy,grizzlyAttack1);
        grizzlyAnimation[1] = new Animation(1f,grizzlyAttack1,grizzlyAttack2);
        grizzlyAnimation[2] = new Animation(0.25f,grizzlyAttack1);
        grizzlyAnimation[3] = new Animation(0.25f,grizzlyAttack1);
        grizzlyAnimation[4] = new Animation(0.25f,grizzlyAttack1);
        grizzlyAnimation[5] = new Animation(0.25f,grizzlyAttack1);
        grizzlyAnimation[6] = new Animation(0.25f,new TextureRegion(badlogic));
        grizzlyAnimation[7] = new Animation(0.25f,grizzlyAttack1);
        grizzlyAnimation[8] = new Animation(0.25f,grizzlyStandBy);
    }

}
