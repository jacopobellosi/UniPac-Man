

import java.util.*;
import java.time.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
   public int x,y;
   public int speed;
   public Image up1,up2, down1,down2,left,right;
   public String direction;
   
   public Rectangle solidArea;
   public boolean collisionON = false;

}