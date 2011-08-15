package com.bitsend.evogene;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitsend.evogene.agents.Agent;
import com.bitsend.evogene.agents.Bug;

public class Game implements ApplicationListener {
	private SpriteBatch batch;
	private World world;
	
	public void create() {
		batch = new SpriteBatch();
		world = new World();
		//populate(100, 20);
	}

	public Game() {
		//create();
		
	}
		
	public void populate(int numFood, int numBugs) {
		
		while (numFood>0) {
			int x = (int)(Math.random() * world.worldWidth);
			int y = (int)(Math.random() * world.worldHeight);
	
			if (world.getContents(x, y) == null) {
				world.addAgent(x, y, new Agent((float)x, (float)y, 0f));
				numFood--;
			}
		}
		
		while (numBugs>0) {
			int x = (int)(Math.random() * world.worldWidth);
			int y = (int)(Math.random() * world.worldHeight);
	
			if (world.getContents(x, y) == null) {
				world.addAgent(x, y, new Bug((float)x, (float)y, 0f, 1));
				numBugs--;
			}
		}
		//int x = 1;
		//int y = 1;
		//world.addAgent(x, y, new Bug((float)x, (float)y, 0f, 1));
	}
	
	
	public void render() {
		Gdx.gl.glClearColor(1f, 1f, 1f, 0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL10.GL_BLEND);
		Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.graphics.getGL10().glEnable(GL10.GL_TEXTURE_2D);
		batch.begin();
		world.update();
		world.render(batch);
		batch.end();
	}

	public void resize(int width, int height) {
	}

	public void pause() {
	}

	public void resume() {
	}

	public void dispose() {
	}
}