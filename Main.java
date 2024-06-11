//this class pretty much just runs the game.
public class Main
{
  public static void main(String[] args) {
    MainGame game = new MainGame();
    System.out.println("game started");
    //game.init();
    
    game.loop();
    System.out.println("thanks for playing");
  }
}
