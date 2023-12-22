// Aggiornamento della classe Player

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject {
    private int speed;  // Velocità di movimento del giocatore
    private int dx;     // Cambiamento della coordinata x

    public Player(int x, int y) {
        super(x, y);
        speed = 5;  // Imposta una velocità iniziale
    }

    public void update() {
        // Aggiorna la posizione del giocatore in base al cambiamento della coordinata x
        x += dx;
    }

    public  void draw(Graphics g) {
        // Disegna il giocatore (puoi personalizzare il disegno)
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
    }

    // Metodo per gestire la pressione di un tasto
    public void handleKeyPress(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
            dx = -speed;  // Sposta il giocatore a sinistra
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            dx = speed;   // Sposta il giocatore a destra
        }
        // Puoi aggiungere gestione per altri tasti se necessario
    }

    // Metodo per gestire il rilascio di un tasto
    public void handleKeyRelease(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            dx = 0;  // Ferma il movimento quando il tasto è rilasciato
        }
    }
}
