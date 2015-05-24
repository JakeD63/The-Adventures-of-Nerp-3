package game.controller;

import org.newdawn.slick.Input;

import game.character.Player;

public class MouseAndKeyboardPlayerController extends PlayerController {

    public MouseAndKeyboardPlayerController(Player player) {
        super(player);
    }

    public void handleInput(Input i, int delta) {
        handleKeyboardInput(i, delta);
    }

    private void handleKeyboardInput(Input i, int delta) {

        if (i.isKeyDown(Input.KEY_A) || i.isKeyDown(Input.KEY_LEFT)) {
            player.moveLeft(delta);
        } else if (i.isKeyDown(Input.KEY_D) || i.isKeyDown(Input.KEY_RIGHT)) {
            player.moveRight(delta);
        }

    }

}
