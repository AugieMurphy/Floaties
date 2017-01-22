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

    public int getTotalBooks(){
	return _totalBooks;
    }
    //========================================================
    
    public static GoFish setUp(Deck deck){
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
	    System.out.println( "\nHow many players? Can be from 2 to 5 inclusive.");


	    int numPlayerz = Keyboard.readInt();
	    
	    while (numPlayerz > 5 || numPlayerz < 2){
		System.out.print("\nInvalid num players. Must be from 2 to 5 inclusive. Try again:\n");
		numPlayerz = Keyboard.readInt();
	    }
	    
	    game = new GoFish(numPlayerz);
	    for (int x =0; x < numPlayerz; x++){
		System.out.println("\nType name of player" + x);
		String name = Keyboard.readWord();
		game.setPlayers(x , new Human(name));
	    }
	    System.out.println("\nAlright, let's deal the cards!");
	    game.dealTheCards(deck);
	    //return game;   
	}
	return game;
	
    }//end setUp
 
    // precon: the player taking the current turn is human.... sort out AI turns later!!
    public void takeTurn(Deck deck){
	// handle intial display
	Player currentPlayer =  _players[_turnCount % _numPlayers];
	int iCurrentPlayer = _turnCount % _numPlayers; 
	System.out.println("\n================ " + currentPlayer.getName().toUpperCase() + "'S TURN ==========================");
	System.out.println (currentPlayer.getName() + "'s cards:");
	System.out.println(currentPlayer.showHand()); 

	// now handle asking
	System.out.println("\nWho would you like to ask for a card? Please type their corresponding number in the list.");
	for (int i = 0; i < _numPlayers; i++){
	    System.out.println( i + ": " + _players[i].getName());
	}
	System.out.println();
	
	int iplayerBeingAsked = Keyboard.readInt();
	while (iplayerBeingAsked < 0 || iplayerBeingAsked > (_numPlayers - 1) || iplayerBeingAsked == iCurrentPlayer){
	    if (iplayerBeingAsked == iCurrentPlayer) {
		System.out.println("That's you! Share the love, ask someone else!");
		iplayerBeingAsked = Keyboard.readInt();
	    }
	    else {
		System.out.println("Index out of bounds: please pick an existing player");
		iplayerBeingAsked = Keyboard.readInt();
	    }
	}

	System.out.println("\nWhat rank of cards would you like to ask " + _players[iplayerBeingAsked].getName() + " for? For any specifications about ranks type 'specs'");


	int rank = rankStrToInt(Keyboard.readString());


	while(rank < 1){
	    if (rank == -1){
		System.out.println("\nInvalid rank please try again: ranks are from 2-10 inclusive as well as 'jacks' , 'queens', 'kings' , and 'aces' with that spelling (case INsensitive).");
	    }
	    else {
		System.out.println("\nRanks are from 2-10 also including Jacks, Queens, Kings, and Aces. Enter one of these options. Be sure to type 'jacks' , 'queens' , 'kings', or 'aces' with that spelling (case INsensitive).");
	    }
	    rank = rankStrToInt(Keyboard.readString());
	}



	int cardsRecieved = _players[iCurrentPlayer].ask(rank, _players[iplayerBeingAsked]);



	
	while (cardsRecieved < 0) {
	    System.out.println("\n" + _players[iCurrentPlayer].getName() + ", you can only ask for a rank of cards that you currently have in your hand. Please enter a different rank");
	    rank = rankStrToInt(Keyboard.readString());
	    cardsRecieved = _players[iCurrentPlayer].ask(rank, _players[iplayerBeingAsked]);
	}

	System.out.println("\n******************************");
	System.out.println( _players[iCurrentPlayer].getName() + " asked " + _players[iplayerBeingAsked].getName() + " for " + Card.numToRank(rank) + "s.");

	if (cardsRecieved == 0){
	    System.out.println(_players[iplayerBeingAsked].getName() + " says Go Fish!");
	    _turnCount += 1;
	}
	else {
	    System.out.println("\n" + _players[iplayerBeingAsked].getName() + " has " + cardsRecieved + " " +  Card.numToRank(rank) + "(s) and has given the card(s) to "+ _players[iCurrentPlayer].getName());
	    System.out.println(_players[iCurrentPlayer].getName() + " gets to go again!");
	}

	
	int newBooks = _players[iCurrentPlayer].checkForBooks();
	_totalBooks += newBooks;
	
	if (newBooks == 0){
	    System.out.println (_players[iCurrentPlayer].getName() + " has gotten no new books");
	}
	else {
	    System.out.println(_players[iCurrentPlayer].getName() + " has gotten " + newBooks + " new books\n" + _players[iCurrentPlayer].getName() + "'s " + _players[iCurrentPlayer].printNewBooks(newBooks));
	}

	if ((_players[iCurrentPlayer].getHand()).size() == 0){
	    int numCards = 0;
	    if (_numPlayers <= 3) {numCards =7;}
	    else {numCards = 5;}
	    System.out.println(_players[iCurrentPlayer].getName() + " must draw " + numCards + "cards because they have run out of cards");
	    _players[iCurrentPlayer].draw(deck, numCards); 
	}
	System.out.println("******************************");

	System.out.println ("\n\n" + currentPlayer.getName() + "'s cards:");
	System.out.println( _players[iCurrentPlayer].showHand());
	System.out.println("\n================ END " + currentPlayer.getName().toUpperCase() + "'S TURN ==========================\n\n\n");




	
    }//end takeTurn

    public int rankStrToInt(String rank){
	try {
	    if ((rank.toLowerCase()).equals("aces")){
		return Card.ACE;
	    }
	    else if ((rank.toLowerCase()).equals("kings")){
		return Card.KING;
	    }
	    else if ((rank.toLowerCase()).equals("queens")){
		return Card.QUEEN;
	    }
	    else if ((rank.toLowerCase()).equals("jacks")){
		return Card.JACK;
	    }
	    else if ((rank.toLowerCase()).equals("specs")){
       		return 0;
	    }
	    else if (Integer.parseInt(rank) > 1 && Integer.parseInt(rank) < 13)  {
		return Integer.parseInt(rank);
	    }
	  
	    else {
		return -1;
	    }
	}
	catch (Exception exception){
	    return -1;
	}
	
    }
  
    public static void main(String[] args){
	try {
	    Deck deck1 = new Deck();
	    GoFish game1 = setUp(deck1);
	    Player[] playerz = game1.getPlayers();
	    while (game1.getTotalBooks() < 13){
		game1.takeTurn(deck1);
	    }
	    // System.out.println(((Human) playerz[0]).getName() + ":");
	    //System.out.println(playerz[0].showHand());
	}
	catch(Exception exception){
	    System.out.println(exception);
	    // System.out.println
	}
    }

}//end class GoFish
