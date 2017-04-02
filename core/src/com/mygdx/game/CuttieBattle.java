package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CuttieBattle extends ApplicationAdapter {
	static SpriteBatch batch;
	Texture img;
	static Character P1,P2;
	State state;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		state = new State();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		switch (state.getCurrentState()){
			case 0:
				// Home
				//System.out.println("State 0");
				state.input();
				state.drawMap();
				break;
			case 1:
				// Select Character menu
				//System.out.println("State 1");
				state.input();
				state.drawMap();
				break;
			case 2:
				//System.out.println("State 2");
				// set charactor
				state.setCharacter();
				break;
			case 3:
				// gameplay
				boolean playing = true;

		}


		batch.end();
	}


	/*

	public void setCharacter(){
		switch (state.getP1Select()){
			case 0:
				P1 = new Grizzly(100,200);
				break;
			case 1:
				P1 = new Panda(100,200);
				break;
			case 2:
				P1 = new IceBear(100,200);
				break;
		}
		switch (state.getP2Select()){
			case 0:
				P2 = new Grizzly(800,200);
				break;
			case 1:
				P2 = new Panda(800,200);
				break;
			case 2:
				P2 = new IceBear(800,200);
				break;
		}
		state.setCurrentState(3);
	}
	 */

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
