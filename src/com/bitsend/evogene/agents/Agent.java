package com.bitsend.evogene.agents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.bitsend.evogene.World;

public class Agent {
	public Vector3 position;
	public Texture texture;
	public Sprite sprite;
	public String filename = "assets/food.png";
	int width = 32;
	int height= 32;
	
	public Agent() {
		this.position = new Vector3(0f, 0f, 0f);
		create();
	}

	public Agent(float x, float y, float z) {
		this.position = new Vector3(x, y, z);
		create();
	}
	
	public void moveTo(int x, int y) {
		position.x = (float)x;
		position.y = (float)y;
		
		
	}
	public void setPosition(int x,  int y, int z) {
		position.x = (float)x;
		position.y = (float)y;
		position.z = (float)z;
	}
	
	public void setPosition(int x, int y) {
		setPosition(x, y, 0);
	}
	public void setFileName(String filename) {
		this.filename = filename;
	}
	
	public void create() {
		FileHandle imageFileHandle = Gdx.files.internal(filename);
		texture = new Texture(imageFileHandle);
		sprite = new Sprite(texture);
		sprite.setPosition(0f, 0f);
	}

	public void update(World world) {
	}

	public void render(SpriteBatch batch, int xSize, int ySize) {
		sprite.setPosition((float)position.x * xSize, (float)position.y * ySize);
		sprite.draw(batch);
	}
	
}
