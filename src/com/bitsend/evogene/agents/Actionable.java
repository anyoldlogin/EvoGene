package com.bitsend.evogene.agents;

import com.badlogic.gdx.math.Vector3;
import com.bitsend.evogene.Environment;

public interface Actionable {
	public enum Action {
		EAT,
		DIE,
		REPRODUCE,
		MOVE
	}
	public void act(Environment environment);
	public void eat(Agent agent);
	public void kill(Agent agent);
	public Agent[] reproduce(Agent mate);
	public Vector3 move(int x, int y);
}
