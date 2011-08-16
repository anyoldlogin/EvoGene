package com.bitsend.evogene;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitsend.evogene.agents.Agent;

public class Place {
	public int x = 0;
	public int y = 0;
	public Sprite sprite;
	public Agent contents = null;

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
		sprite = new Sprite(com.bitsend.evogene.Assets.grid);
		sprite.setPosition((float) x, (float) y);

	}

	public void render(SpriteBatch batch, int cellWidth, int cellHeight) {
		int newX = this.x * cellWidth;
		int newY = this.y * cellHeight;
		sprite.setPosition((float) newX, (float) newY);
		sprite.draw(batch);
		if (this.contents != null) {
			contents.render(batch, cellWidth, cellHeight);
		} 
	}

}