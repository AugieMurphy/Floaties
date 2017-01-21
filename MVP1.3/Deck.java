import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> _deck;
    private int _cardsDealt ;
    //private ArrayList<Card> _pool; 

    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    
    /*********** Deck() ***********
	   default constructor
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    // Creates a deck of 52 cards
    public Deck(){
	_cardsDealt = 0;
	_deck = new ArrayList<Card>();
	for (int x =1; x<14; x++){
	    for (int y = 0; y < 4 ; y++){
		Card c = new Card( x,y ); //new card of each suit y of each rank x
		_deck.add( c );
	    }
	}
	//_pool = new ArrayList<Card>();
    }

    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~~~~~
      These methods allow the deck to interact with these classes by other info, etc...(info here)
      -------------------------------------------------*/
   
    //ACCESSORS ============================================
    public int getCardsDealt() {
	//return _cardsDealt;
	return 52 - _deck.size();
    }

    public ArrayList<Card> getDeck(){
	return _deck;
    }
    //====================================================
    //overwritten toString()
    public String toString(){
	return _deck.toString();
    }
    

    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~
      These methods allow the deck to interact with these classes by other info, etc...(info here)
      -------------------------------------------------*/
    
    /********** methodName() **********
		description...
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public void shuffle(){
	for (int x = 0; x < _deck.size() ; x ++){ //if ur doing it this way you might as well use a for each loop for(Card c: _deck)
	    int randI1 = (int) (Math.random() *51);
	    int randI2 = (int) (Math.random() *51); //you only need one, you already have x
	    _deck.set(randI1, _deck.set(randI2,_deck.get(randI1)));
	}
    }

    /********** methodName() **********
		description...
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public void deal( Player[] players ){
	shuffle();
	int numPlayers = players.length;
	
	// what if we condensed both sequences into one!!!
	// if( numPlayers <= 3 ){ numCards = 7; }
	// else{ numCards = 5; }
	//
	// if( numPlayers*numCards < deck.size() )
	// for( int x = 0; x < numPlayers*numCards; x++){ players[x%numPlayers].draw(); }
	
	if (numPlayers <= 3){ // with 3 players or less, deal 7 cards each
	    int counter = 0; 
	    while( counter < (numPlayers * 7) ){
		for (Player p : players){ 
		    p.addToHand(_deck.get(counter)); 
		    _deck.remove(counter);
		    counter += 1;
		}
	    }
	    // _cardsDealt += (7*numPlayers); // see final comment
	}
	else { // with 4-5 players (inclusive). deal 5 cards each 
	    int counter = 0;
	    while( counter < (numPlayers*5) ){
		for (Player p : players){
		    p.addToHand(_deck.get(counter));
		    _deck.remove(counter);
		    counter += 1;
		}
	    }
	    //_cardsDealt += (5*numPlayers); // check out getCardsDealt: also, why do we need this?
	}
    }
    
    /********** methodName() **********
		description...
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    //removes the first Card from the _deck
    public Card removeFromDeck(){ //should return a card because we can use this in other places
	return _deck.remove(0); //_deck.remove(d.size() - 1) is the best case scenario, might as well use it
	//_cardsDealt += 1; // see CardsDealt
    }
    
    public static void main( String[] args ){
	Deck deck1 = new Deck();	
	//	System.out.println(deck1);
	//	System.out.println(deck1.getSize());
	//deck1.shuffle();
	//System.out.println(deck1);
	Player player1 = new Human("jake");
	Player player2 = new Human("mary");
	Player[] exPlayers = {player1, player2};
	deck1.deal(exPlayers);
	//System.out.println(player1.showHand());
	//System.out.println(player2.showHand());
	//System.out.println(deck1.getCardsDealt());
	System.out.println(deck1.getDeck().size());
	deck1.removeFromDeck();
	System.out.println(deck1.getDeck().size());	
	
	
    }
}
