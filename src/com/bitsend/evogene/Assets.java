package com.bitsend.evogene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public static Texture cell = null;
	public static Texture grid = null;
	public static Texture food = null;

	public static void load() {
		grid = new Texture(Gdx.files.internal("data/grid.png"));

		cell = new Texture(Gdx.files.internal("data/cell.png"));

		food = new Texture(Gdx.files.internal("data/food.png"));
	}
}
