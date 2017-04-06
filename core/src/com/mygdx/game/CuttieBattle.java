package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Date;

public class CuttieBattle extends ApplicationAdapter {
	static SpriteBatch batch;
	Texture img;
	static Character p1,p2;
	private Date startCountTime , currentCountTime;
	State state;
	int gameState =0;
	int tempActionP1,tempActionP2;
	float deltaTime;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		state = new State();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		switch (state.getCurrentState()){
			case 0:
				// Home
				batch.begin();
				//System.out.println("State 0");
				state.input();
				state.drawMap();
				batch.end();
				break;
			case 1:
				// Select Character menu
				batch.begin();
				//System.out.println("State 1");
				state.input();
				state.drawMap();
				System.out.println("P1 = " +state.getP1Select()+" : P2 = "+state.getP2Select());
				batch.end();
				startCountTime = new Date();
				break;
			case 2:
				// gameplay
				batch.begin();
				//System.out.println("State 2");
				state.drawMap();
				boolean playing = true;
				switch (gameState){
					case 0:
						//count time 3 sec and Input Action
						//System.out.println("gamestate 0");
						state.input();
						currentCountTime = new Date();
						int second = currentCountTime.getSeconds() - startCountTime.getSeconds();
						switch (second){
							case 0:
								//System.out.println("Second 1");
								break;
							case 1:
								//System.out.println("Second 2");
								break;
							case 2:
								//System.out.println("Second 3");
								break;
							default:
								gameState++;
						}
						break;
					case 1:
						// move to  middle
						//System.out.println("gamestate 1");
						p1.setDestinationPos(500,300);
						p2.setDestinationPos(800,300);
						p1.goRight();
						if(p2.goLeft() == true){
							gameState++;
						}
						break;
					case 2:
						// cal mana
						System.out.println("P1 = "+p1.nextAction+" | P2 = "+p2.nextAction);
						p1.checkMana();
						p2.checkMana();
						gameState++;
						startCountTime = new Date();
						break;
					case 3:
						// action
						currentCountTime = new Date();
						int s = currentCountTime.getSeconds() - startCountTime.getSeconds();
						switch (s){
							case 0:
								break;
							case 1:
								break;
							default:
								gameState++;
						}
						break;
					case 4:
						// cal HP
						p1.setStatus();
						p2.setStatus();
						boolean p1Hit =  p1.takeDamage(p2.finalAtk);
						boolean p2Hit =  p2.takeDamage(p1.finalAtk);
						p1.resetStatus();
						p2.resetStatus();
						//System.out.println("P1 | "+p1.hp+"/"+p1.mana+" Def"+p1.finalDef+"   P2 | "+p2.hp+"/"+p2.mana + " Def "+(p2.finalDef));
						System.out.println(p1.toString());
						System.out.println(p2.toString());
						// set actio Hit
						if(p1Hit == true){
							p1.action = 6;
						}
						if(p2Hit == true){
							p2.action = 6;
						}

						//check death
						if(p1.isDeath()){
							// p2 win
							System.out.println("P2 WIN !!");
							state.gameEnd();
						}
						else if(p2.isDeath()){
							// p1 win
							System.out.println("P1 WIN !!");
							state.gameEnd();
						}
						gameState++;
						break;
					case 5:
						//move to start position
						//System.out.println("go back");
						p1.setDestinationPos(100,300);
						p2.setDestinationPos(1100,300);
						p1.goLeft();
						if(p2.goRight() == true){
							gameState++;
						}
						break;
					case 6:
						// reset
						gameState = 0;
						p1.action = 0;
						p2.action = 0;
						startCountTime = new Date();
					default:playing = false;
				}
				default:;

				deltaTime += Gdx.graphics.getDeltaTime();
				p1.draw(deltaTime);
				p2.draw(deltaTime);
				batch.end();
				break;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
