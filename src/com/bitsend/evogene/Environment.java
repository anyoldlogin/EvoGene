package com.bitsend.evogene;

import java.util.HashMap;

public class Environment {
	public HashMap<Direction,Place> env = null;
	
	public Environment(HashMap<Direction, Place> environment) {
		this.env = environment;
	}
	
	public Place get(Direction dir) {
		return env.get(dir);
	}
}
