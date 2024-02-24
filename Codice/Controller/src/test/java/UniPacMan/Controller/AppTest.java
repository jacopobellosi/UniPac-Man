package UniPacMan.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.GameEngine;
import controller.InputManager;
import controller.Player;

public class AppTest 
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
   /*
    @Test
    public void testPlayerMovesUpWhenUpKeyPressed() {
    	//Simula l'input di direzione di pacman e controlla se segue effettivamente quella direzione
        InputManager.upPressed = true;
        int initialY = player.y;
        player.update();
        assertTrue(player.y < initialY);
        System.out.println("Pacman dovrebbe muoversi verso l'alto quando viene premuto W");
    }
    
    @Test 
    public void testPlayerMovesDownWhenDownKeyPressed() {
        InputManager.downPressed = true;
        int initialY = player.y;
        player.update();
        assertTrue(player.y > initialY);
        System.out.println("Pacman dovrebbe muoversi verso il basso quando viene premuto S");
    }
    
    @Test 
    public void testPlayerMovesLeftWhenLeftKeyPressed() {
        InputManager.leftPressed = true;
        int initialX = player.x;
        player.update();
        assertTrue(player.x < initialX);
        System.out.println("Pacman dovrebbe muoversi verso sinistra quando viene premuto A");
    }
    
    @Test 
    public void testPlayerMovesRightWhenRightKeyPressed() {
        InputManager.rightPressed = true;
        int initialX = player.x;
        player.update();
        assertTrue(player.x > initialX);
        System.out.println("Pacman dovrebbe muoversi verso destra quando viene premuto D");
    }
    */
    @Test
    public void testMangiaPalline() {
        // Simula il mangiare di una pallina e verifica il conteggio dei punti e delle palline
        player.mangiaPalline(0); 
        assertEquals(6, player.getPunteggio());
        assertEquals(1, player.getHashKey());
       
    }
}
