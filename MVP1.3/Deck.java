import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> _deck;


    
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
	_deck = new ArrayList<Card>();
	for (int x =1; x<14; x++){
	    for (int y = 0; y < 4 ; y++){
		Card c = new Card( x,y ); //new card of each suit y of each rank x
		_deck.add( c );
	    }
	}
    }

   
    //ACCESSORS ============================================
    public int getCardsDealt() {
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
     // PRECOND:: numCards * numPlayers < size of deck, Player class has a draw(Deck,int) method 
     // POSTCOND:: returns nothing and removes cards from the _deck and adds them to each player in the given array 7 cards if there are less than 4 players or 5 cards otherwise 
     // EX:
     ******************************/
    public void deal( Player[] players ){
	shuffle();
	int numPlayers = players.length;
	int numCards = 0;
	if( numPlayers <= 3 ){ numCards = 7; }
	else{ numCards = 5; }
	for (int x = 0; x < numPlayers * numCards; x ++){
	    players[x%numPlayers].draw(this, 1);
	}
	
    } //end deal
    
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
       	//System.out.println(deck1);
	System.out.println("Size of deck1: " + deck1.getDeck().size());
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
	//deck1.removeFromDeck();
	System.out.println(player1.showHand());
	System.out.println(player2.showHand());
	//System.out.println(deck1.getDeck().size());	
	
	
    }
}
