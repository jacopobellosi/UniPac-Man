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

public class AppTest 
{
    private InputManager inputManager;
    private Player player;
    private GameEngine gameEngine;
    private GestoreRipristinoImmunita gestoreRipristinoImmunita;
    /*
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
   //Per testare il movimento di Pacman effettuare un test alla volta
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
    /*
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
   
    //test per controllare il numero di vite al momento di spawn
    @Test
    public void testDefaultLife() {
        player.setDefaultLife();
        assertTrue(player.countLife()==3);
        System.out.println("Pacman all'avvio del gioco ha 3 vite");
    }
    //da errore nell'array che è null
    
    @Test
    public void testMangiaPW() {
        player.mangiaPW(1); 
        assertTrue(Player.punteggio==12);
        System.out.println("Pacman ha mangiato un PowerUp");
    }
    //interazione fantsama, pacman perde una vita
    @Test
    public void testInterazioneFanstasma() {
        // Simuliamo un fantasma che colpisce il giocatore quando il giocatore non è invincibile né attaccante
        player.setDefaultLife(); 
        player.setInvincible(false);
        player.setAttacking(false);
        player.interazioneFanstasma(0); // Supponiamo che il fantasma sia il primo nell'array dei fantasmi

        // Verifichiamo che il giocatore abbia perso una vita
        assertEquals(2, player.countLife());
    }
    */
    //da mettere a codice a parte, bisogna fare un setup differente, si testa se effettivamente il ripristino dell'immunita avviene in 3000ms
    @Before
    public void setUp1() {
        gameEngine = new GameEngine();
        // Supponiamo che gameEngine sia stato inizializzato correttamente con dati di esempio
        gestoreRipristinoImmunita = new GestoreRipristinoImmunita(gameEngine, 0); // Supponiamo che index sia 0 per questo test
    }
    
    @Test
    public void testRun() throws InterruptedException {
        // Impostiamo lo stato iniziale di un fantasma a invincibile
        gameEngine.ghost[0] = new Ghost(gameEngine, 0);
        gameEngine.ghost[0].invincible = true;
        
        // Eseguiamo il thread per il ripristino dell'immunità
        gestoreRipristinoImmunita.run();
        
        // Aspettiamo 3000 millisecondi per far sì che il thread completi l'esecuzione
        Thread.sleep(3000);
        
        // Verifichiamo che lo stato di invincibilità del fantasma sia stato ripristinato a false
        assertFalse(gameEngine.ghost[0].invincible);
        
        // Aggiungi altri test se necessario per verificare ulteriori comportamenti del thread
    }
    
}
