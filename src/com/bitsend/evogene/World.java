package com.bitsend.evogene;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitsend.evogene.agents.Agent;

public class World {
	public int worldWidth = 25;
	public int worldHeight = 25;
	public int cellWidth = 32;
	public int cellHeight = 32;
	public int screenWidth = 1200;
	public int screenHeight = 800;

	ArrayList<Place> places;
	ArrayList<Agent> agents;

	public World() {
		create();
	}

	public World(int screenWidth, int screenHeight, int worldWidth,
			int worldHeight, int cellWidth, int cellHeight) {
		this.cellHeight = cellHeight;
		this.cellWidth = cellWidth;
		this.worldHeight = worldHeight;
		this.worldWidth = worldWidth;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		create();
	}

	public void create() {
		places = new ArrayList<Place>();
		agents = new ArrayList<Agent>();
		for (int x = 0; x < this.worldWidth + 1; x++) {
			for (int y = 0; y < this.worldHeight + 1; y++) {
				places.add(new Place(x, y));
			}
		}
	}


	public void update(float delta) {
		for (Place place : places) {
			if (place.contents != null) {
				Agent contents = place.contents;
				if (!contents.isAlive()) {
					resetContents(
							(int) contents.position.x, 
							(int) contents.position.y
					);
				}
				place.contents.update(this, delta);
			}

		}
	}

	public void render(SpriteBatch batch) {

		for (Place place : places) {
			place.render(batch, this.cellWidth, this.cellHeight);
		}
	}

	public boolean inWorld(int x, int y) {
		if (x > this.worldWidth || x < 0 || y > this.worldHeight || y < 0)
			return false;
		else
			return true;
	}

	public HashMap<Direction, Agent> getSurroundings(int x, int y, int level) {
		HashMap<Direction, Agent> map = new HashMap<Direction, Agent>();

		for (Direction dir : Direction.values()) {
			Agent agent = this.get(x, y, dir);
			map.put(dir, agent);
		}
		return map;
	}

	public Agent get(int x, int y, Direction dir) {
		return getContents(x + dir.getXDelta(), y + dir.getYDelta());
	}

	public void addAgent(int x, int y, Agent agent) {
		setContents(x, y, agent);
		agent.setPosition(x, y);
	}

	public void removeAgent(Agent agent) {
		resetContents((int) agent.position.x, (int) agent.position.y);
		agents.remove(agent);
	}

	public int rotateX(int x) {
		if (x < 0) {
			return this.worldWidth;
		} else if (x > this.worldWidth) {
			return 0;
		} else
			return x;

	}

	public int rotateY(int y) {
		if (y < 0) {
			return this.worldHeight;
		} else if (y > this.worldHeight) {
			return 0;
		} else
			return y;

	}

	protected int coordToIndex(int x, int y) {
		int index = (y * worldHeight + x);
		Gdx.app.log("CoordToCoord", "CoordToIndex: (" + x + ", " + y + ") => "
				+ index);

		return index;
	}

	public Agent getContents(int x, int y) {
		int index = coordToIndex(x, y);
		if (index < places.size()) {
			return places.get(coordToIndex(x, y)).contents;
		}
		return null;
	}

	public void setContents(int x, int y, Agent agent) {
		places.get(coordToIndex(x, y)).contents = agent;
		agent.setPosition(x, y);
		if (agent != null) {
			agents.add(agent);
		}
	}

	public void resetContents(int x, int y) {
		Agent contents = places.get(coordToIndex(x, y)).contents;
		places.get(coordToIndex(x, y)).contents = null;
		agents.remove(contents);
	}

}
