public class GoFish{

    public int _numPlayers; // number of players in game (AI + HUMAN)
    public Player[] players; // turn table, player is removed when they're out
    
    public int _turnCount; //how many turns have happened
    public int _numString; //
    
    public String _cycleMemory;

    public turn( Player who ){

	System.out.println( CycleMemory );
	cycleMemory += "\nOn " + who.getName + "'s turn they...";

	boolean turn = true;
	while( turn ){
	    System.out.println( "Here's Your hand" );
	    System.out.println( who.printHand() );
	    
	    System.out.println( "What card do you want to fish for?" );
	    try{ int x = readInt(); }
	    catch{ int x = Card.faceValue( readInt() ); }
	    
	    System.out.println( "Who do you want to ask?" );
	    try( Player y = new Player( readLine() ) ){ }
	    catch{ Player y = Card.faceValue( readInt() ); }
	    
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

    public static void main( String[] args ){
	
	System.out.println( "\n\n\nHi! What's your name?" );
	System.out.println( "(Type Here): " );

	try( String _name = inReadLine() ){ Player _name = new Human( readLine() ); }
	catch( Exception e ){ }

	System.out.println( "\nHello, " + _name + ", let's get fishing!!!");
	System.out.println( "Single or multiplayer?" );

	int x = 0;
	System.out.println( "\t1) Single Player" );
	System.out.println( "\t2) Multiplayer" );
	System.out.println( "\t3) Umm... what???" );
	
	try( x = readLine() ){};
	catch{};
	System.out.println( "\nHow many players do you want?" );
	System.out.println( "(" + _name + "):" );

	numPlayers = readInt();
	
	int c = 2;
	while( c > numPlayers + 1 ){
	    System.out.println( "Player " + c + "'s name?"  );
	}
	
        //may need to name randomly and use lots of getName() 's
	_name = readLine();
	try( Player _name = new Player( _name ) ){ _players[c] = _name }
	catch{
	    Player idk = new Player ( Mary );
	    _players[c] = new Player( _name );
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

    }
}
