package game.character;

import java.util.HashMap;

import game.enums.Facing;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Character {
	
	protected float x;
	protected float y;
	protected Facing facing;
	
	protected HashMap<Facing,Image> sprites;
	protected HashMap<Facing,Animation> movingAnimations;
    protected long lastTimeMoved;
	
	
	public Character(float x, float y) throws SlickException{
		this.x = x;
		this.y = y;
		setSprite(new Image("data/img/characters/player/nerp.png"));
		facing = Facing.RIGHT;
	}
	
	protected void setSprite(Image i){
        sprites = new HashMap<Facing,Image>();
        sprites.put(Facing.RIGHT, i);
        sprites.put(Facing.LEFT , i.getFlippedCopy(true, false));
    }
	
	 public float getX(){
	        return x;
	    }
	 
	    public float getY(){
	        return y;
	    }
	 
	    public void render(){
	    	 
	        //draw a moving animation if we have one and we moved within the last 150 miliseconds
	        if(movingAnimations != null && lastTimeMoved+150 > System.currentTimeMillis()){
	            movingAnimations.get(facing).draw(x-2,y-2);                
	        }else{            
	            sprites.get(facing).draw(x-2, y-2);          
	        }
	    }

}
