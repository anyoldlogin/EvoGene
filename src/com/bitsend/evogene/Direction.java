package com.bitsend.evogene;

public enum Direction {
	N 	(0, -1),
	NE 	(1, -1),
	E 	(1, 0),
	SE  (1,1),
	S	(0, 1),
	SW	(-1, 1),
	W	(-1, 0),
	NW	(-1, -1);
	
	public final int xDelta;
	public final int yDelta;
	
	Direction(int xDelta, int yDelta) {
		this.xDelta = xDelta;
		this.yDelta = yDelta;
	}
	
	public int getXDelta() {
		return this.xDelta;
	}
	
	public int getYDelta() {
		return this.yDelta;
	}
	
	public static Direction RandomDirection() {
		int num = (int)Math.floor(Math.random() * 8);
		return Direction.values()[num];
	}
	
}
