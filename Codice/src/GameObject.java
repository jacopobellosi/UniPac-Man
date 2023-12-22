

import java.util.*;
import java.time.*;

import java.awt.*;

public class GameObject {
    protected int x;
    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        // Implementazione di base per l'aggiornamento dell'oggetto
    }

    public void draw(Graphics g) {
        // Implementazione di base per il disegno dell'oggetto
        // Questa implementazione disegna un semplice rettangolo
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50);
    }
}