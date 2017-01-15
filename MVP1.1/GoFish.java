import cs1.Keyboard;

public class GoFish{

    public int _numPlayers; // number of  players in game (HUMAN + AI)
    public Player[] _players; //an array of Human and AI players
    
    public int _turnCount; //how many turns have happened
    public int _totalBooks; //player1.numBooks + player2.numBooks + ... + playerN.numBooks
   

    //default constructor 
    public GoFish(){
	_numPlayers = 1;
	_players = new Player[1];
	_turnCount = 0;
	_totalBooks = 0;
	
    }

    //overloaded constructor
    public GoFish(int numPlayers){
	_numPlayers = numPlayers;
	_players = new Player[numPlayers];
	_turnCount = 0;
	_totalBooks = 0;
    }

    public void dealTheCards(Deck d){
	d.deal(_players);
    }

    //MUTATORS =================================================
    public void setPlayers(int i , Player p){
	_players[i] = p; 
    }
    //==========================================================


    //ACCESSORS================================================
    public Player[] getPlayers (){
	return _players;
    }
    //========================================================
    
    public static GoFish setUp(){
	System.out.println( "READY TO PLAY GOFISH!?!?!?!!");
	System.out.println( "OF COURSE YOU ARE! YOU WERE BORN READY");

	System.out.println("Type 1 or 2:\n1. Single Player NOT READY YET sad face");
	System.out.println( "2. Multiplayer");
	
	int option = Keyboard.readInt();
	
	if (option > 2 || option < 1){
	    throw new IllegalArgumentException ("invalid option; can be either 1 or 2");
	}
	
	else if (option == 1) {
	    System.out.println("I'm sorry this part of the game isnt ready yet"); 
	}
	
	else {
	    System.out.println( "How many players? Can be from 2 to 5 inclusive.");
	    
	    int numPlayerz = Keyboard.readInt();
	    
	    if (numPlayerz > 5 || numPlayerz < 2){
		throw new IllegalArgumentException ("invalid num players");
	    }
	    
	    else {
		GoFish game = new GoFish(numPlayerz);
		for (int x =0; x < numPlayerz; x++){
		    System.out.println("Type name of player" + x);
		    String name = Keyboard.readWord();
		    game.setPlayers(x , new Human(name));
		}
		System.out.println("Alright, let's deal the cards!");
		Deck deck1 = new Deck();
		game.dealTheCards(deck1);
		return game;
	    }
	}
	GoFish game = new GoFish();
	return game;
	
    }//end setUp
 
    // precon: the player taking the current turn is human.... sort out AI turns later!!
    public void takeTurn(){
	// handle intial display
	Player currentPlayer =  _players[_turnCount % _numPlayers];
	System.out.println();
	System.out.println (currentPlayer.getName() + "'s cards:");
	System.out.println(currentPlayer.showHand()); 

	// now handle asking
	System.out.println("\nWho would you like to ask for a card?");
	for (int i = 0; i < _players.length; i++){
	    System.out.println("\n" + i + ": " + _players[i].getName());
	}
    }
  
    public static void main(String[] args){
	try {
	    GoFish game1 = setUp();
	    Player[] playerz = game1.getPlayers();
	    game1.takeTurn();
	    // System.out.println(((Human) playerz[0]).getName() + ":");
	    //System.out.println(playerz[0].showHand());
	}
	catch(Exception exception){
	    System.out.println("Please read instructions carefully!");
	}
    }

}//end class GoFish
