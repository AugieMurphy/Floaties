import cs1.Keyboard;

public class GoFish{

    private int _numPlayers;
    private ArrayList<Player> _players;
    //private New Exception RuleBreakerException;

    public GoFish(){
    }
    
    public static void main( String[] args ){
	
	System.out.println("Welcome to GoFish!!!");
	System.out.println("What's you're name? ");
	System.out.println("(You Type Here): ");

	String name = readString();

	try{ _players[1] = new Player( name ); }
	catch( Exception e ){ }
	
	System.out.println(" ");
	System.out.println(" ");

	System.out.println(" ");
	System.out.println(" ");
     	System.out.println(" ");
	System.out.println(" ");
	System.out.println(" ");
	
    }
}


