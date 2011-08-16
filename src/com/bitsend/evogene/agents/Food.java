package com.bitsend.evogene.agents;


public class Food extends Agent {
	public int energy = 10;
	
	public Food() {
		super();
		
	}
	
	public Food(float x, float y, float z) {
		super(x, y, z);
	}
	
	@Override
	public String toString() {
		return "How Many: " + Food.HOW_MANY +  " Type: " + this.getClass().getName() + " Energy: " + this.energy;
	}
}
