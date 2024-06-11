import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
//yooo guys it's inheritance!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Player extends Sprite
{

  private int speed = 8;
  private int frame = 0;
  private String direction = "left";
  private BufferedImage [] frames;
  private boolean moved = false;
  
  public Player(int newX,int newY,int newW,int newH,String type) {
    super(newX,newY,newW,newH);
    //if (type == "camel") {
      frames = new BufferedImage[4];
      frames[0] = ImageLoader.loadImage(type + "_1.png");
      frames[1] = ImageLoader.loadImage(type + "_2.png");
      frames[2] = ImageLoader.loadImage(type + "_3.png");
      frames[3] = ImageLoader.loadImage(type + "_4.png");
    //}

  }
  
  public BufferedImage getImage() {
    if (direction == "left") {
      if (moved) {
        if (frame > 4) {
          return frames[0];
        } else {
          return frames[1];
        }
      } else {
        return frames[0];
      }
    } else {
      if (moved) {
        if (frame > 4) {
          return frames[2];
        } else {
          return frames[3];
        }
      } else {
        return frames[2];
      }
    }

  }
  
  
  public void process() {
    if (frame == 8) {
      frame = 0;
    } else {
      frame++;
    }
    moved = false;
    
    if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && x >= 0) {
      x -= speed;
      direction = "left";
      moved = true;
    }
    if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && x < 400 - width) {
      x += speed;
      direction = "right";
      moved = true;
    }
    if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && y >= 0) {
      y -= speed;
      moved = true;
    }
    if (Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && y < 400 - height) {
      y += speed;
      moved = true;
    }
    
  }
}
