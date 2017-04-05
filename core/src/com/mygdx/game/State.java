package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Currency;

import static com.mygdx.game.CuttieBattle.batch;

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
    private int p1Select = 0;
    private int p2Select = 0;
    private boolean p1Confirm,p2Confirm;


    public void input(){
        switch (currentState) {
            case 0:
                if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                    currentState++;
                }
                if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
                    currentState = -1;
                }
                break;
            case 1:
                if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
                    if(getP1Select() > 0 && p1Confirm == false ){
                        setP1Select(getP1Select() - 1);
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
                    if(getP1Select() < 2 && p1Confirm == false){
                        setP1Select(getP1Select() + 1);
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                    p1Confirm = true;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                    if(getP2Select() > 0 && p2Confirm == false){
                        setP2Select(getP2Select() - 1);
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                    if(getP2Select() < 2 && p2Confirm == false){
                        setP2Select(getP2Select() + 1);
                    }
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                    p2Confirm = true;
                }
                System.out.println("P1 select"+p1Select);
                System.out.println("P2 select"+p2Select);
                if(p1Confirm == true && p2Confirm == true){
                    currentState++;
                    setCharacter();
                }
                break;
            case 2:
                // gameplay
                if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
                    CuttieBattle.p1.nextAction = 1;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                    CuttieBattle.p1.nextAction = 2;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                    CuttieBattle.p1.nextAction = 3;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                    CuttieBattle.p1.nextAction = 4;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.T)) {
                    CuttieBattle.p1.nextAction = 5;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) {
                    CuttieBattle.p2.nextAction = 1;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5)) {
                    CuttieBattle.p2.nextAction = 2;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) {
                    CuttieBattle.p2.nextAction = 3;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) {
                    CuttieBattle.p2.nextAction = 4;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) {
                    CuttieBattle.p2.nextAction = 5;
                }
                break;
        }
    }

    public void setCharacter(){
        switch (p1Select){
            case 0:
                CuttieBattle.p1 = new Grizzly(100,200,1);
                break;
            case 1:
                CuttieBattle.p1 = new Panda(100,200,1);
                break;
            case 2:
                CuttieBattle.p1 = new IceBear(100,200,1);
                break;
        }
        switch (p2Select){
            case 0:
                CuttieBattle.p2 = new Grizzly(1100,200,2);
                break;
            case 1:
                CuttieBattle.p2 = new Panda(1100,200,2);
                break;
            case 2:
                CuttieBattle.p2 = new IceBear(1100,200,2);
                break;
        }
    }

    public void drawMap(){
        switch (currentState){
            case 0:
                break;
            case 1:
                if(p1Select == 0){
                    batch.draw(Assest.badlogic,100,700);
                }else if(p1Select == 1){
                    batch.draw(Assest.badlogic,500,700);
                }else if(p1Select == 2){
                    batch.draw(Assest.badlogic,900,700);
                }

                if(p2Select == 0){
                    batch.draw(Assest.badlogic,100,500);
                }else if(p2Select == 1){
                    batch.draw(Assest.badlogic,500,200);
                }else if(p2Select == 2){
                    batch.draw(Assest.badlogic,900,500);
                }
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public void gameEnd(){
        p1Select = 0;
        p1Confirm = false;
        p2Select = 0;
        p2Confirm = false;
        currentState = 0;
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
