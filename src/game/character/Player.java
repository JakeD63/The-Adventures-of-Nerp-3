package game.character;

import java.util.HashMap;

import game.enums.Facing;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {

    public Player(float x, float y) throws SlickException {
        super(x, y);
        setSprite(new Image("data/img/characters/player/nerpina_1.png"));

        setMovingAnimation(new Image[] {
                new Image("data/img/characters/player/nerpina_1.png"),
                new Image("data/img/characters/player/nerpina_2.png"),
                new Image("data/img/characters/player/nerpina_3.png"),
                new Image("data/img/characters/player/nerpina_4.png") }, 125);

    }

    protected void setMovingAnimation(Image[] images, int frameDuration) {
        movingAnimations = new HashMap<Facing, Animation>();

        // we can just put the right facing in with the default images
        movingAnimations
                .put(Facing.RIGHT, new Animation(images, frameDuration));

        Animation facingLeftAnimation = new Animation();
        for (Image i : images) {
            facingLeftAnimation.addFrame(i.getFlippedCopy(true, false),
                    frameDuration);
        }
        movingAnimations.put(Facing.LEFT, facingLeftAnimation);

    }

    public void moveLeft(int delta) {
        x = x - (0.15f * delta);
        facing = Facing.LEFT;
        lastTimeMoved = System.currentTimeMillis();
    }

    public void moveRight(int delta) {
        x = x + (0.15f * delta);
        facing = Facing.RIGHT;
        lastTimeMoved = System.currentTimeMillis();
    }

}
