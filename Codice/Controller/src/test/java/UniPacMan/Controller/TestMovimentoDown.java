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

public class TestMovimentoDown 
{
    private InputManager inputManager;
    private Player player;
    private GameEngine gameEngine;
    
    @Before
    public void setUp() {
        gameEngine = new GameEngine();
        inputManager = new InputManager(gameEngine);
        player = new Player(gameEngine, inputManager);
        
    }
    @After
    public void tearDown() {
        gameEngine = null;
        inputManager = null;
        player = null;
    }
    @Test 
    public void testPlayerMovesDownWhenDownKeyPressed() {
        InputManager.downPressed = true;
        int initialY = player.y;
        player.update();
        assertTrue(player.y > initialY);
        System.out.println("Pacman dovrebbe muoversi verso il basso quando viene premuto S");
    }
}

