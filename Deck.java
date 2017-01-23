import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> _deck;


    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    
    /*********** Deck() ***********
	   default constructor
     // POSTCOND:: a deck of type ArrayList<Card> containing all 52 cards in a standard deck
     // EX:
     ******************************/
    // Creates a deck of 52 cards
    public Deck(){
	_deck = new ArrayList<Card>();
	for (int x =1; x<14; x++){ // 13 cards of each suit
	    for (int y = 0; y < 4 ; y++){ // 4 suits
		Card c = new Card( x,y ); //new card of each suit y of each rank x
		_deck.add( c );
	    }
	}
    }

    public Deck(int num){
	_deck = new ArrayList<Card>();
	for (int x =1; x<4; x++){ // 13 cards of each suit
	    for (int y = 0; y < 4 ; y++){ // 4 suits
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
    

    
    
    /********** shuffle() **********
		shuffles the order of elements in the existing deck
      //PRECOND:: there is a deck (_deck) containing an arraylist of cards
     // POSTCOND:: shuffles the deck so that cards are randomly ordered
     // EX:
     ******************************/
    public void shuffle(){
	for (int x = 0; x < _deck.size() ; x ++){ // for all indices in _deck
	    int randI1 = (int) (Math.random() *51);
	    int randI2 = (int) (Math.random() *51); 
	    _deck.set(randI1, _deck.set(randI2,_deck.get(randI1))); // randomly swap three cards 
	}
    }

    /********** deal() **********
     // PRECOND:: numCards * numPlayers < size of deck, Player class has a draw(Deck,int) method 
     // POSTCOND:: each player in the array has 7 cards if numPlayers <= 3 or 5 cards otherwise in their hand, and these cards have been removed from the deck; the new hands are sorted by rank
     // EX:
     ******************************/
    public void deal( Player[] players ){
	shuffle();
	int numPlayers = players.length; 
	int numCards = 0;
	if( numPlayers <= 3 ){ numCards = 7; }
	else{ numCards = 5; }
	for (int x = 0; x < numPlayers * numCards; x ++){ // keep dealing until all players have recieved numCards
	    players[x%numPlayers].draw(this, 1); // give all players one card, then give them all two, etc...
	}
	
    } //end deal
    
    /********** methodName() **********
		description...
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    //removes the first Card from the _deck
    public Card removeFromDeck(){ 
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
