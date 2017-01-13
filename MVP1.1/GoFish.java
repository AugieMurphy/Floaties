import cs1.Keyboard;

public class GoFish{

    public int _numPlayers; // number of players in game (AI + HUMAN)
    public Player[] _players; // turn table, player is removed when they're out
    
    public int _turnCount; //how many turns have happened
    public int _totalBooks;

    public GoFish(){
	_numPlayers = 1;
	_players = new Player[1];
	_turnCount = 0;
	_totalBooks = 0;
	
    }

    public GoFish(int numPlayers){
	_numPlayers = numPlayers;
	_players = new Player[numPlayers];
	_turnCount = 0;
	_totalBooks = 0;
    }

    public void setPlayers(int i , Player p){
	_players[i] =p; 
    }

    public void dealTheCards(Deck d){
	d.deal(_players);
    }

    public Player[] getPlayers (){
	return _players;
    }
    /*
    public String _cycleMemory;

    public void turn( Player who ){

	System.out.println( CycleMemory );
	cycleMemory += "\nOn " + who.getName + "'s turn they...";

	boolean turn = true;
	while( turn ){
	    System.out.println( "Here's Your hand" );
	    System.out.println( who.printHand() );
	    
	    System.out.println( "What card do you want to fish for?" );
	    try{ int x = readInt(); }
	    catch( Exception e ){ int x = Card.faceValue( readInt() ); }
	    
	    System.out.println( "Who do you want to ask?" );
	    try{ Player y = new Player( readLine() ) }
	    catch( Exception e ){ Player y = Card.faceValue( readInt() ); }
	    
	    System.out.println( "Asking " + y.getName() + "for a " + x + "...");
	    
	    cycleMemory +=  "\n\tasked " + y.getName() + "for a " + x;
	    
	    who.ask( y, x );
	    if( who.search > 0 ){ turn = false }
	    else{
		
		cycleMemory += "and they got " + who.ask( y,x ) + " cards";
		who.add( y.remove(who.ask(), x ), x );
	    }
	}
	cycleMemory += "AND FISHED!!!\n";	    
	System.out.println( "Go Fish!" );
	System.out.prinln( "You drew a " + x );  
	System.out.println( "You're turn is over." );
    }
    */
    public static void setUp(GoFish game){
	String retStr = "";
	retStr += "\nREADY TO PLAY GOFISH!?!?!?!!";
	retStr += "\nOF COURSE YOU ARE! YOU WERE BORN READY";

	retStr += "\nType 1 or 2:\n1. Single Player NOT READY YET sad face";
	retStr += "\n2. Multiplayer";
	int option = Keyboard.readInt();
	if (option > 2 || option < 1){
	    throw new IllegalArgumentException ("invalid option; can be either 1 or 2");
	}
	else if (option == 1) {
	    retStr += "\nI'm sorry this part of the game isnt ready yet";
	}
	else {
	    //System.out.println("How many players? Can be from 2 to 5 inclusive.");
	    retStr += "\nHow many players? Can be from 2 to 5 inclusive.";
	    int numPlayerz = Keyboard.readInt();
	    if (numPlayerz > 5 || numPlayerz < 3){
		throw new IllegalArgumentException ("invalid num players");
	    }
	    else {
		game = new GoFish(numPlayerz);
		for (int x =0; x < numPlayerz; x++){
		    System.out.println("Type name of player" + x);
		    String name = Keyboard.readWord();
		    game.setPlayers(x , new Human(name));
		}
		System.out.println("Alright, let's deal the cards!");
		Deck deck1 = new Deck();
		game.dealTheCards(deck1);
	    }
	}
    }
    public static void main( String[] args ){	
	try {
	    System.out.println("READY TO PLAY GOFISH!?!?!?!!");
	    System.out.println( "OF COURSE YOU ARE! YOU WERE BORN READY");

	    System.out.println( "Type 1 or 2:\n1. Single Player NOT READY YET sad face");
	    System.out.println("2. Multiplayer");
	    int option = Keyboard.readInt();
	    if (option > 2 || option < 1){
		throw new IllegalArgumentException ("invalid option; can be either 1 or 2");
	    }
	    else if (option == 1) {
		System.out.println("I'm sorry this part of the game isnt ready yet");
	    }
	    else {
		System.out.println("How many players? Can be from 2 to 5 inclusive.");
		int numPlayerz = Keyboard.readInt();
		if (numPlayerz > 5 || numPlayerz < 3){
		    throw new IllegalArgumentException ("invalid num players");
		}
		else {
		    GoFish game1 = new GoFish(numPlayerz);
		    for (int x =0; x < numPlayerz; x++){
			System.out.println("Type name of player" + x);
			String name = Keyboard.readWord();
			game1.setPlayers(x , new Human(name));
		    }
		    System.out.println("Alright, let's deal the cards!");
		    Deck deck1 = new Deck();
		    game1.dealTheCards(deck1);
		    Player[] players = game1.getPlayers();
		    System.out.println (((Human)players[0]).getName() + "'s cards:");
		    System.out.println(players[0].showHand());
		}
	    }
	
	}
	    
	catch (Exception exception) {
	    System.out.println("Please read instructions carefully!");
	}
	
    }


	/*
	System.out.println( "\n\n\nHi! What's your name?" );
	System.out.println( "(Type Here): " );

	try( String _ name = inReadLine() ){ Player player1 = new Human( readLine() ); }
	catch( Exception e ){ }

	System.out.println( "\nHello, " + _name + ", let's get fishing!!!");
	System.out.println( "Single or Multiplayer?" );

	int x = 0;
	//System.out.println( "\t1) Single Player" );
	System.out.println( "\t2) Multiplayer" );
	System.out.println( "\t3) Umm... what???" );
	
	try( x = readLine() ){ if( x = 3 )
		System.out.println( "Read the rulebook!!!" );
	}
	
	catch{};
	System.out.println( "\nHow many players do you want? (haha you don't get to play alone, find a buddy until AI is invented)" );
	System.out.println( "(" + _name + "):" );
	
	numPlayers = readInt();
	
	int c = 2;
	
	while( c < numPlayers + 1 ){
	    System.out.println( "Player " + c + "'s name?"  );
	    //may need to name randomly and use lots of getName() 's
	    String _name = readLine();
	    
	    try{
		Player yippeee = new Human( _name );
		_players[c] = yippeee;
	    }
	    
	    catch{
		Player la = new Human( Mary );
		_players[c] = la;
	    }
	}
	    
	for( int x = 0; _numBooks < 13; x++ ){
	    turn( _players.get( x % numPlayers ) );
	}
	
	System.out.println( "Great Game!!!" );
	
	int winner = 0;
        for( int x = 1; _numBooks < 13; x++ ){
	    if ( ( _players.get( winner ) ).getBooks() ).compareTo( _players.get( x ) ).getBooks() < 0){ winner = x };
    }
    
    System.out.println( _players.get( winner ) ); 
	*/

}

