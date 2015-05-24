package game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;
import game.character.Player;
import game.controller.MouseAndKeyboardPlayerController;
import game.controller.PlayerController;
import game.level.Level;

public class LevelState extends BasicGameState {

    Level level;
    String startingLevel;
    private Player player;
    PlayerController playerController;

    public LevelState(String startingLevel) {
        this.startingLevel = startingLevel;

    }

    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {

        level = new Level(startingLevel);

        player = new Player(128, 416);
        level.addCharacter(player);

        playerController = new MouseAndKeyboardPlayerController(player);

    }

    public void render(GameContainer container, StateBasedGame sbg, Graphics g)
            throws SlickException {
        g.scale(Game.SCALE, Game.SCALE);
        level.render();

    }

    public void update(GameContainer container, StateBasedGame sbg, int delta)
            throws SlickException {

        playerController.handleInput(container.getInput(), delta);

    }

    public void keyPressed(int key, char code) {
        // if the key is escape, close our application
        if (key == Input.KEY_ESCAPE) {
            System.exit(0);
        }
    }

    public int getID() {
        return 0;
    }

}
