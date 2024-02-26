package UniPacMan.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.GameEngine;
import controller.GestoreRipristinoImmunita;
import controller.Ghost;
import controller.InputManager;
import controller.Player;

public class TestMoviemntoRight
{
    private InputManager inputManager;
    private Player player;
    private GameEngine gameEngine;
    private GestoreRipristinoImmunita gestoreRipristinoImmunita;
    
    @Before
    public void setUp() {
        gameEngine = new GameEngine();
        inputManager = new InputManager(gameEngine);
        player = new Player(gameEngine, inputManager);
        gestoreRipristinoImmunita = new GestoreRipristinoImmunita(gameEngine, 0);
        
    }
    @After
    public void tearDown() {
        gameEngine = null;
        inputManager = null;
        player = null;
    }

    @Test 
    public void testPlayerMovesRightWhenRightKeyPressed() {
        InputManager.rightPressed = true;
        int initialX = player.x;
        player.update();
        assertTrue(player.x > initialX);
        System.out.println("Pacman dovrebbe muoversi verso destra quando viene premuto D");
    }
}
