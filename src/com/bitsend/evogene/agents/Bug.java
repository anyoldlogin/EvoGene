package com.bitsend.evogene.agents;

import com.bitsend.evogene.World;

public class Bug extends Agent {
	public int speed;
	public Bug(float x, float y, float z, int speed) {
		super(x,y,z);
		this.speed = speed;
		this.filename = "assets/cell.png";
		create();
	}
	
	public void update(World world) {
//			Direction dir = Direction.RandomDirection();
//			int nextX = world.rotateX((int)position.x + dir.getXDelta());
//			int nextY = world.rotateY((int)position.y + dir.getYDelta());
//			moveTo(nextX * world.cellHeight, nextY * world.cellHeight);
//			
	}
	
}
