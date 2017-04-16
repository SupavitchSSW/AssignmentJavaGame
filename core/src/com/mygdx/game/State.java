package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Currency;

import static com.mygdx.game.BearsBattle.batch;
import static com.mygdx.game.BearsBattle.p2;

/**
 * Created by root on 2/4/2560.
 */
public class State {
    /*
    0 menu
    1 character select screen
    2 game play
     */

    private int currentState = 0;
    int p1Select = 0;
    int p2Select = 2;
    private boolean p1Confirm,p2Confirm;


    public void input(){
        switch (currentState) {
            case 0:
//                if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
//                    currentState++;
//                }
//                if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
//                    currentState = -1;
//                }
                currentState++;

                break;
            case 1:
                //character select screen
                if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
//                    if(getP1Select() > 0 && p1Confirm == false ){
//                        setP1Select(getP1Select() - 1);
//                    }
                    if(p1Select > 0 && p1Confirm == false){
                        if(p2Select != p1Select-1){
                            p1Select--;
                        }else if(p1Select == 2) {
                            p1Select-=2;
                        }
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
                    if(p1Select < 2 && p1Confirm == false){
                        if(p2Select != p1Select+1){
                            p1Select++;
                        }else if(p1Select == 0) {
                            p1Select+=2;
                        }
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                    //Assest.selectSound.play();
                    p1Confirm = true;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                    if(p2Select > 0 && p2Confirm == false){
                        if(p2Select-1 != p1Select){
                            p2Select--;
                        }else if(p2Select == 2) {
                            p2Select-=2;
                        }
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                    //Assest.punchSound.play(1f);
                    if(p2Select < 2 && p2Confirm == false){
                        if(p2Select+1 != p1Select){
                            p2Select++;
                        }else if(p2Select == 0) {
                            p2Select+=2;
                        }
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                    //Assest.selectSound.play();
                    p2Confirm = true;
                }
                if(p1Confirm == true && p2Confirm == true){
                    currentState++;
                    setCharacter();
                    Assest.gamePlayBGM.play();
                    Assest.gamePlayBGM.setLooping(true);

                }
                //System.out.println("P1"+p1Select+"P2"+p2Select);
                break;
            case 2:
                // gameplay
                if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
                    BearsBattle.p1.nextAction = 1;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                    BearsBattle.p1.nextAction = 2;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                    BearsBattle.p1.nextAction = 3;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
                    BearsBattle.p1.nextAction = 4;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                    BearsBattle.p1.nextAction = 5;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.I)) {
                    BearsBattle.p2.nextAction = 1;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.O)) {
                    BearsBattle.p2.nextAction = 2;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.P)) {
                    BearsBattle.p2.nextAction = 3;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.K)) {
                    BearsBattle.p2.nextAction = 4;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.L)) {
                    BearsBattle.p2.nextAction = 5;
                }
                break;
        }
    }

    public void setCharacter(){
        switch (p1Select){
            case 0:
                BearsBattle.p1 = new IceBear(100,100,1);
                break;
            case 1:
                BearsBattle.p1 = new Grizzly(100,100,1);
                break;
            case 2:
                BearsBattle.p1 = new Panda(100,100,1);
                break;
        }
        switch (p2Select){
            case 0:
                BearsBattle.p2 = new IceBear(1050,100,2);
                break;
            case 1:
                BearsBattle.p2 = new Grizzly(1050,100,2);
                break;
            case 2:
                BearsBattle.p2 = new Panda(1050,100,2);
                break;
        }
    }

    public void drawMap(){
        switch (currentState){
            case 0:
                break;

            case 1:

                batch.draw(Assest.SelectBG,0,0,1600,800);
                if(p1Select == 0){
                    batch.draw(Assest.p1Pin,480,500,100,100);
                    batch.draw(Assest.icebearPreview,-100,400);
                }else if(p1Select == 1){
                    batch.draw(Assest.p1Pin,780,500,100,100);
                    batch.draw(Assest.grizzlyPreview,-100,400);
                }else if(p1Select == 2){
                    batch.draw(Assest.p1Pin,1050,500,100,100);
                    batch.draw(Assest.pandaPreview,-100,400);
                }

                if(p2Select == 0){
                    batch.draw(Assest.p2Pin,550,500,100,100);
                    batch.draw(Assest.icebearPreview,920,400);
                }else if(p2Select == 1){
                    batch.draw(Assest.p2Pin,850,500,100,100);
                    batch.draw(Assest.grizzlyPreview,920,400);
                }else if(p2Select == 2){
                    batch.draw(Assest.p2Pin,1120,500,100,100);
                    batch.draw(Assest.pandaPreview,920,400);
                }
                break;
            case 2:
                batch.draw(Assest.gameplayBG,0,0,1600,800);
                break;
            case 3:
                break;
        }
    }

    public void gameEnd(){
        p1Select = 0;
        p1Confirm = false;
        p2Select = 2;
        p2Confirm = false;
        currentState = 0;
    }

    public void drawWinner(int c){
        switch (c){
            case 0://draw
                batch.draw(Assest.winnerPic[0],200,0);
                break;
            case 1:
                batch.draw(Assest.winnerPic[1],200,0);
                break;
            case 2:
                batch.draw(Assest.winnerPic[2],200,0);
                break;
            default:
        }
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getP1Select() {
        return p1Select;
    }

    public void setP1Select(int p1Select) {
        this.p1Select = p1Select;
    }

    public int getP2Select() {
        return p2Select;
    }

    public void setP2Select(int p2Select) {
        this.p2Select = p2Select;
    }
}
