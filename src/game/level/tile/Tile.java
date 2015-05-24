package game.level.tile;

import game.physics.BoundingShape;

public class Tile {

	protected int x;
	protected int y;
	protected BoundingShape boundingShape;
	
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		boundingShape = null;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public BoundingShape getBoundingShape(){
		return this.boundingShape;
	}
}
