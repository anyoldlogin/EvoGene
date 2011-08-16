package com.bitsend.evogene.agents;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.bitsend.evogene.Environment;
import com.bitsend.evogene.World;

public class Agent implements  Actionable {
	
	public static int HOW_MANY = 0; 
	public Vector3 position;
	public Sprite sprite;
	int width = 32;
	int height= 32;
	public int energyUsedPerTurn = 0;
	public int energy = 0;
	public enum State {
		DEAD,
		ALIVE
	};
	
	public State state;
	
	public Agent() {
		HOW_MANY += 1;
		this.position = new Vector3(0f, 0f, 0f);
		create();
	}

	public Agent(float x, float y, float z) {
		this.position = new Vector3(x, y, z);
		create();
	}
	
	public boolean isAlive() {
		if (state == State.DEAD) {
			return false;
		}
		return true;
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
	
	public void create() {
		sprite = new Sprite(com.bitsend.evogene.Assets.food);
		sprite.setPosition(0f, 0f);
		state = State.ALIVE;
	}

	public void update(World world, float delta) {
	}

	public void render(SpriteBatch batch, int xSize, int ySize) {
		sprite.setPosition((float)position.x * xSize, (float)position.y * ySize);
		sprite.draw(batch);
	}
	
	public String toString() {
		return "How Many: " + Agent.HOW_MANY +  " Type: " + this.getClass().getName() + " Energy: " + this.energy;
	}

	@Override
	public void act(Environment environment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat(Agent agent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill(Agent agent) {
		state = State.DEAD;
		
	}

	@Override
	public Agent[] reproduce(Agent mate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector3 move(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
