package com.bitsend.evogene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitsend.evogene.agents.Agent;

public class Place {
	public String filename = "assets/grid.png";
	public int x = 0;
	public int y = 0;
	public Sprite sprite;
	public Agent contents = null;
	public Texture texture;
	
	public Place(int x, int y) {
		this.x = x;
		this.y = y;
		this.contents = null;
		create(x, y);
	}
	
	public Place(int x, int y, Agent agent) {
		this.x = x;
		this.y = y;
		this.contents = agent;
		create(x, y);
	}
	
	public void create(int x, int y) {
		if (this.contents == null) {
			FileHandle imageFileHandle = Gdx.files.internal(filename);
			texture = new Texture(imageFileHandle);
			sprite = new Sprite(texture);
			sprite.setPosition((float)x, (float)y);
		}
		else {
			this.contents.create();
		}
	}
	public void render(SpriteBatch batch, int cellWidth, int cellHeight) {
		if (this.contents != null) {
			contents.render(batch, cellWidth, cellHeight);
		}
		else {
			int newX = this.x * cellWidth;
			int newY = this.y * cellHeight;
			sprite.setPosition((float)newX, (float)newY);
			sprite.draw(batch);
		}
	}

}