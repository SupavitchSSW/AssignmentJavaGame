package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

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
                }
        }
    }

    public void setCharacter(){
        switch (p1Select){
            case 0:
                CuttieBattle.P1 = new Grizzly(100,200);
                break;
            case 1:
                CuttieBattle.P1 = new Panda(100,200);
                break;
            case 2:
                CuttieBattle.P1 = new IceBear(100,200);
                break;
        }
        switch (p2Select){
            case 0:
                CuttieBattle.P2 = new Grizzly(800,200);
                break;
            case 1:
                CuttieBattle.P2 = new Panda(800,200);
                break;
            case 2:
                CuttieBattle.P2 = new IceBear(800,200);
                break;
        }
        currentState++;
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
                    batch.draw(Assest.badlogic,500,500);
                }else if(p2Select == 2){
                    batch.draw(Assest.badlogic,900,500);
                }
                break;
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
