//this is a bunch of game variables that will be passed to the drawer class when it is time to draw

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Variables
{
  private String status = "intro";
  public String playerCostume = "camel";
  private Player player;
  
  private ArrayList<Enemy> enemies;
  private ArrayList<Carrot> carrots;
  
  private int score,highscore;
  private boolean newRecord; //whether the player has gotten a new highscore in the current game
  private boolean isTitleReady = false;
  private boolean done = false;
  
  
  public Variables() {
    reset();
    highscore = 0;
  }
  
  public void reset() {
    player = new Player(200,200,32,32,playerCostume);
    enemies = new ArrayList<Enemy>();
    carrots = new ArrayList<Carrot>();
    score = 0;
    newRecord = false;
  }
  
  public String getStatus() {
    return status;
  }
  
  public void process() {
    if (getStatus() == "game") 
    {
      player.process();
      
      //SPAWN NEW OBJECTS
      if ((score >= 10 && Math.random() > 0.9) || (score < 10 && Math.random() > 0.96)) 
      {
        enemies.add(new Enemy());
      }
      if (Math.random() > 0.985) 
      {
        carrots.add(new Carrot());
      }
      
      
      //ENEMIES
      for (int i = 0; i < enemies.size(); i++) 
      {
        enemies.get(i).process();
        if (enemies.get(i).isTouching(player)) 
        {
          status = "death";
        }
        if (enemies.get(i).isCondemned()) 
        {
          enemies.remove(i);
        }
      }
      //CARROTS
      for (int i = 0; i < carrots.size(); i++) 
      {
        carrots.get(i).process();
        if (carrots.get(i).isTouching(player)) 
        {
          carrots.get(i).condemn();
          updateScore();
        }
        if (carrots.get(i).isCondemned()) 
        {
          carrots.remove(i);
        }
  
      }
    
    }
    else if (getStatus() == "intro") 
    {
      if (isTitleReady && Keyboard.isKeyPressed(KeyEvent.VK_Z)) 
      {
        playerCostume = "camel";
        status = "game";
        reset();
      }
      if (isTitleReady && Keyboard.isKeyPressed(KeyEvent.VK_X)) 
      {
        playerCostume = "donkey";
        status = "game";
        reset();
      }
      if (isTitleReady && Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) 
      {
        done = true;
        
      }
      if (!Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) 
      {
        isTitleReady = true;
      }
    }
    else if (getStatus() == "death") 
    {
      if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) 
      {
        status = "intro";
        isTitleReady = false;
      }
    }
  }
  
  public boolean isDone() {
    return done;
  }
  
  public void updateScore() 
  {
    score++;
    if (score > highscore) 
    {
      highscore = score;
      newRecord = true;
    }
  }
  
  public ArrayList<Carrot> getCarrots() 
  {
    return carrots;
  }
  public ArrayList<Enemy> getEnemies() 
  {
    return enemies;
  }
  
  public Player getPlayer() 
  {
    return player;
  }
  
  public String getPlayerCostume()
  {
    return playerCostume;
  }
  
  public int getScore() 
  {
    return score;
  }
  public int getHighScore() 
  {
    return highscore;
  }
  
  public boolean getNewRecord() 
  {
    return newRecord;
  }
}
