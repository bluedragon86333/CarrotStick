import java.awt.image.BufferedImage;
//inspired by Scratch's sprite system


public class Sprite
{
  protected int x,y,width,height;
  protected BufferedImage defaultImage;
  
  public Sprite() {
    goTo(0,0);
    setSize(1,1);
  }
  
  public Sprite(int newX,int newY,int newW,int newH) {
    goTo(newX,newY);
    setSize(newW,newH);
  
  }
  
  
  /////////////////////////////////////////////////ACCESSORS
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }
  
  public BufferedImage getImage() {
    return defaultImage;
    
  }
  
 ///////////////////////////////////////////////METHODS 
  public void goTo(int newX,int newY) {
    x = newX;
    y = newY;
  }
  
  public void setSize(int newW,int newH) {
    width = newW;
    height = newH;
  }
  
  public boolean isTouching(Sprite sp) {
    return (
        x < sp.getX() + sp.getWidth() &&
        x + width > sp.getX() &&
        y < sp.getY() + sp.getHeight() &&
        y + height > sp.getY()
      );
  }
}
