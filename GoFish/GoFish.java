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
	GoFish game;
	
	System.out.println( "READY TO PLAY GOFISH!?!?!?!!");
	System.out.println( "OF COURSE YOU ARE! YOU WERE BORN READY");

	String introMsg = "\nType 1 or 2:\n1. Single Player NOT READY YET sad face\n2. Multiplayer\n";
	System.out.print(introMsg);
	
	int option = Keyboard.readInt();
	while (option >2 || option <1){
	    System.out.println("Invalid option. Try again:\n" +  introMsg);
	    option = Keyboard.readInt();
	}
	
	if (option == 1) {
	    System.out.println("I'm sorry this part of the game isnt ready yet");
	    game = new GoFish();
	}
	
	else {
	    System.out.println( "How many players? Can be from 2 to 5 inclusive.");
	    
	    int numPlayerz = Keyboard.readInt();
	    
	    while (numPlayerz > 5 || numPlayerz < 2){
		System.out.print("Invalid num players. Must be from 2 to 5 inclusive. Try again:");
		numPlayerz = Keyboard.readInt();
	    }
	    
	    game = new GoFish(numPlayerz);
	    for (int x =0; x < numPlayerz; x++){
		System.out.println("Type name of player" + x);
		String name = Keyboard.readWord();
		game.setPlayers(x , new Human(name));
	    }
	    System.out.println("Alright, let's deal the cards!");
	    Deck deck1 = new Deck();
	    game.dealTheCards(deck1);
	    //return game;   
	}
	return game;
	
    }//end setUp
 
    // precon: the player taking the current turn is human.... sort out AI turns later!!
    public void takeTurn(){
	// handle intial display
	Player currentPlayer =  _players[_turnCount % _numPlayers];
	int iCurrentPlayer = _turnCount % _numPlayers; 
	System.out.println("\n================ " + currentPlayer.getName().toUpperCase() + "'S TURN ==========================");
	System.out.println (currentPlayer.getName() + "'s cards:");
	System.out.println(currentPlayer.showHand()); 

	// now handle asking
	System.out.println("\nWho would you like to ask for a card?");
	for (int i = 1; i < _numPlayers; i++){
	    System.out.println( i + ": " + _players[i].getName());
	}
	System.out.println();
	
	int indexAskPlayer = Keyboard.readInt();
	while (indexAskPlayer < 0 || indexAskPlayer > (_numPlayers - 1) || indexAskPlayer == iCurrentPlayer){
	    if (indexAskPlayer == iCurrentPlayer) {
		System.out.println("That's you! Share the love, ask someone else!");
		indexAskPlayer = Keyboard.readInt();
	    }
	    else {
		System.out.println("Index out of bounds: please pick an existing player");
		indexAskPlayer = Keyboard.readInt();
	    }
	}
	
	
    }//end takeTurn
  
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
