//https://web.stanford.edu/class/archive/cs/cs108/cs108.1092/handouts/27PaintRepaint.pdf
//This class handles all drawing and contains all the game objects in 'Variables game'
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Drawer extends JComponent {
  
  
  
    private JFrame frame;
    private BufferedImage testImage;
    //private int x = 10;
    private Variables game = new Variables();
    private BufferedImage camel = ImageLoader.loadImage("camel_3_large.png");
    private BufferedImage donk = ImageLoader.loadImage("donkey_3_large.png");
    private BufferedImage dead_camel = ImageLoader.loadImage("dead_camel.png");
    private BufferedImage dead_donk = ImageLoader.loadImage("dead_donkey.png");
    
    ///////////////////////////////////////////////////////////////////conSTRUCTORS
    public Drawer(int width,int height,String title) {
      this.setPreferredSize(new Dimension(width,height));
      //testImage = ImageLoader.loadImage("71WdtdZUCKL.jpg");
      frame = new JFrame(title);
      setSize(width,height);
      frame.add(this);
      frame.pack();
      frame.setVisible(true);
    }
      public Drawer() {
        frame = new JFrame("Temp Title");
        setSize(10,10);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }
      /////////////////////////////////////////////////////////////////////Methods
      
      public void process() {
        game.process();
      }
      
      public boolean isDone() {
        return game.isDone();
      }
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      if (game.getStatus() == "game") {
         
        
        g.drawImage(testImage,0,0,null);
        
        //player
        g.drawImage(game.getPlayer().getImage(),game.getPlayer().getX() * 2,game.getPlayer().getY() * 2,null);
        
        //enemies
        for (Enemy i: game.getEnemies()) {
          g.drawImage(i.getImage(),i.getX() * 2,i.getY() * 2,null);
        }
        
        //carrots
        for (Carrot i: game.getCarrots()) {
          g.drawImage(i.getImage(),i.getX() * 2,i.getY() * 2,null);
        }
        
        //UI
        g.setFont(new Font(g.getFont().getFontName(),10 * 2,10 * 2));
        g.drawString("SCORE: " + game.getScore(), 2 * 2,12 * 2);
        g.drawString("HIGH:  " + game.getHighScore(), 2 * 2,24 * 2);
        
        if (game.getNewRecord()) {
          g.setColor(new Color(0,100,0));
          g.setFont(new Font(g.getFont().getFontName(),10 * 2,18 * 2));
          g.drawString("NEW HIGHSCORE!", 225 * 2,25 * 2);
        }
      }
      else if (game.getStatus() == "intro")
      {
        g.setFont(new Font(g.getFont().getFontName(),8 * 2,32 * 2));
        g.drawString("CARROTS AND STICKS", 15 * 2,40 * 2);
        g.setFont(new Font(g.getFont().getFontName(),8 * 2,12 * 2));
        g.drawString("By Shalin \"The Flea\" Chang", 200 * 2,60 * 2);
        
        g.setFont(new Font(g.getFont().getFontName(),8,18 * 2));
        g.drawString("CHOOSE A PLAYER!", 100 * 2,140 * 2);
        
        g.drawImage(camel,36 * 2,190 * 2,null);
        g.drawString("CAMEL", 40 * 2,180 * 2);
        g.drawString("PRESS Z", 30 * 2,270 * 2);
        
        g.drawImage(donk,280 * 2,180 * 2,null);
        g.drawString("DONKEY", 290 * 2,180 * 2);
        g.drawString("PRESS X", 280 * 2,270 * 2);
        
        g.setFont(new Font(g.getFont().getFontName(),8,12 * 2));
        g.drawString("PRESS SPACE TO QUIT", 140 * 2,380 * 2);

      }
      else if (game.getStatus() == "death")
      {
        g.setColor(new Color(0,0,0));
        g.setFont(new Font(g.getFont().getFontName(),10,18 * 2));
        g.drawString("YOU DIED", 150 * 2,200 * 2);
        g.setFont(new Font(g.getFont().getFontName(),10,10 * 2));
        g.drawString("SPACE TO RETRY", 144 * 2,212 * 2);
        g.drawString("SCORE: " + game.getScore() + "     HIGHSCORE: " + game.getHighScore(), 120 * 2,224 * 2);
        if (game.getNewRecord()) {
          g.setColor(new Color(0,100,0));
          g.setFont(new Font(g.getFont().getFontName(),10 * 2,18 * 2));
          g.drawString("NEW HIGHSCORE!", 225 * 2,25 * 2);
        }
        
        if (game.getPlayerCostume() == "camel") {
          g.drawImage(dead_camel,158 * 2,120 * 2,null);
        }
        if (game.getPlayerCostume() == "donkey") {
          g.drawImage(dead_donk,158 * 2,120 * 2,null);
        }
      }
    }
    
    
    public void close() {
      setVisible(false); //you can't see me!
      frame.dispose(); //Destroy the JFrame object

    }
}