
//yooo guys it's inheritance!!!!!!!!!!!!!!!!!!!!!!!!!!!

import java.awt.image.BufferedImage;

public class Carrot extends Sprite
{
  private int speed = 6;
  private int xv,yv; //0,-1, or 1; multiplied by speed
  private boolean condemned = false;
  
  private int frame = 0;
  private BufferedImage [] frames;
  private int frameLen = 3;
  
  
  public Carrot(int newX,int newY,int newW,int newH,int xvel,int yvel) {
    super(newX,newY,newW,newH);
    defaultImage = ImageLoader.loadImage("carrot_1.png");
    xv = xvel;
    yv = yvel;
    frames = new BufferedImage[4];
    frames[0] = ImageLoader.loadImage("carrot_1.png");
    frames[1] = ImageLoader.loadImage("carrot_2.png");
    frames[2] = ImageLoader.loadImage("carrot_3.png");
    frames[3] = ImageLoader.loadImage("carrot_4.png");
  }
  
  
  public Carrot() {
    super(0,0,32,32);
    defaultImage = ImageLoader.loadImage("carrot_1.png");
    if (Math.random() < 0.5) {
      xv = 1 - (int) (Math.random() * 2) * 2;
      yv = 0;
    } else {
      xv = 0;
      yv = 1 - (int) (Math.random() * 2) * 2;
    }
    
    
    if (xv > 0) {
      goTo(-width,(int) (Math.random() * 400 - height));
    }
    if (xv < 0) {
      goTo(400,(int) (Math.random() * 400 - height));
    }
    if (yv > 0) {
      goTo((int) (Math.random() * 400 - width),-height);
    }
    if (yv < 0) {
      goTo((int) (Math.random() * 400 - width),400);
    }
    
    frames = new BufferedImage[4];
    frames[0] = ImageLoader.loadImage("carrot_1.png");
    frames[1] = ImageLoader.loadImage("carrot_2.png");
    frames[2] = ImageLoader.loadImage("carrot_3.png");
    frames[3] = ImageLoader.loadImage("carrot_4.png");
  }
  
  public boolean isCondemned() {
    return condemned;
  }
  
  public void condemn() {
    condemned = true;
  }
  
  public void process() {
    goTo(x + xv * speed,y + yv * speed);
    
    
    if (xv < 0) { //LEFT
      if (x < 0 - width) {
        condemned = true;
      }
    }
    else if (xv > 0) { //RIGHT
      if (x > 400) {
        condemned = true;
      }
    }
    else if (yv > 0) { //DOWN
      if (y > 400) {
        condemned = true;
      }
    }    
    else if (yv < 0) { //UP
      if (y < 0 - height) {
        condemned = true;
      }
    }
    
    
    if (frame >= 4 * frameLen - 1) {
      frame = 0;
    } else {
      frame++;
    }
    
    defaultImage = frames[frame / frameLen];
  }
}
