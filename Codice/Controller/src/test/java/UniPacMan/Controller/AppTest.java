package UniPacMan.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.GameEngine;
import controller.GestoreRipristinoImmunita;
import controller.Ghost;
import controller.InputManager;
import controller.Player;

public class AppTest 
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
    
    //test per controllare il numero di vite al momento di spawn che deve essere uguale a 3
    @Test
    public void testDefaultLife() {
        player.setDefaultLife();
        assertTrue(player.countLife()==3);
        System.out.println("Pacman all'avvio del gioco ha 3 vite");
    }

    //interazione fantasma, pacman perde una vita
    @Test
    public void testInterazioneFanstasma() {
        // Simuliamo un fantasma che colpisce il giocatore quando il giocatore non è invincibile né attaccante
        player.setDefaultLife(); 
        player.setInvincible(false);
        player.setAttacking(false);
        player.interazioneFanstasma(0); //Supponiamo che il fantasma sia il primo nell'array dei fantasmi

        // Verifichiamo che il giocatore abbia perso una vita
        assertEquals(2, player.countLife());
    }
    //interazione fantsama, pacman perde una vita
    @Test
    public void testInterazioneFanstasmaFalsa1() {
        // Simuliamo un fantasma che colpisce il giocatore quando il giocatore non è invincibile né attaccante
        player.setDefaultLife(); 
        player.setInvincible(false);
        player.setAttacking(false);
        player.interazioneFanstasma(0); // Supponiamo che il fantasma sia il primo nell'array dei fantasmi

        // Verifichiamo che il giocatore abbia perso una vita, il risultato non combacia con l'aspettativa in quanto avremo 2 vite perse
        assertEquals(1, player.countLife());
    }
   
    //Test per controllare che l'immunità dei fantasmi sia di 3000 millisecondi
    @Test
    public void testRun() throws InterruptedException {
        gameEngine.ghost[0] = new Ghost(gameEngine, 0);
        gameEngine.ghost[0].invincible = true;
        gestoreRipristinoImmunita.run();
        // Aspettiamo 3000 millisecondi per far sì che il thread completi l'esecuzione
        Thread.sleep(2000);
        assertFalse(gameEngine.ghost[0].invincible);
       
    }

    //Test per mangiare il fantasma quando vulnerabile
    @Test
    public void testKillMonster() {
        gameEngine.setMonster(); 
        assertNotNull(gameEngine.ghost[0]); 
        gameEngine.killMonster(0); 
        assertNull(gameEngine.ghost[0]); 
    }
    
    //Test per verificare che venga incrementato correttamente il livello di gioco
    @Test
    public void testNextLevel() {
        GameEngine gameEngine = new GameEngine();
        int initialLevel = gameEngine.livelloCorrente;
        gameEngine.nextLevel();
        assertEquals(initialLevel + 1, gameEngine.livelloCorrente);
    }
    //Test settaggio dei fantasmini al momento di inizio del gioco
    @Test
    public void testSetMonster() {
        assertNull(gameEngine.ghost[0]);
        assertNull(gameEngine.ghost[1]);
        assertNull(gameEngine.ghost[2]);
        assertNull(gameEngine.ghost[3]);
        gameEngine.setMonster();
        // Verifica che i fantasmi siano stati correttamente settati
        assertNotNull(gameEngine.ghost[0]);
        assertNotNull(gameEngine.ghost[1]);
        assertNotNull(gameEngine.ghost[2]);
        assertNotNull(gameEngine.ghost[3]);
    }
}
