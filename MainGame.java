//this class manages the fps and big picture stuff like that
public class MainGame extends Thread
{
  private boolean isRunning = true;
  //Date timer = new Date();
  private boolean frameAvailable = true;
  private Drawer window = new Drawer(800,800,"Carrots and Sticks");
  
  
  public void init() {
    //window.setBounds(80,40,16,16);
  }
  
  
  public void draw() {
    
    //window.preprocess(game);
    window.repaint();
  }
  
  public void process() {
    window.process();
    if (window.isDone()) {
      isRunning = false;
    }
  }
  
  public void loop() {
    init();
    while (isRunning) {
      try {
          Thread.sleep( 30 );
      } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }//catch
      process();
      draw();
        
    }
    window.close();
    window = null;
  }  
        
        
        
        
        
        
        
        
        
        
        
        
        
      /*
      long mils = System.currentTimeMillis();
      mils = mils % 55;
      if (mils < 8) {
        if (frameAvailable) {
          frameAvailable = false;
          
          //game code///////////////////////////////////////////////////////////////////////
          //System.out.println("hi " + mils);
          process();
          draw();
          //////////////////////////////////////////////////////////////////////////////////////
        }
      } else {
        frameAvailable = true;
      }
      */


}
