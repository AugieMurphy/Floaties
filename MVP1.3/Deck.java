import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> _deck;
    private int _cardsDealt ;
    //private ArrayList<Card> _pool; 

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

    public void shuffle(){
	for (int x = 0; x < _deck.size() ; x ++){
	    int randI1 = (int) (Math.random() *51);
	    int randI2 = (int) (Math.random() *51);
	    _deck.set(randI1, _deck.set(randI2,_deck.get(randI1)));
	}
    }

    /*
    public void makePool() {
	//System.out.println(_cardsDealt);
	for (int x = _cardsDealt; x < 52; x++){
	    // System.out.println("counter: " + x); 
	    _pool.add(_deck.get(x));
	}
    }
    */


     public void deal( Player[] players ){
	shuffle();
	int numPlayers = players.length;
	if (numPlayers <= 3){ //3 players or less = 7 cards each
	    int counter = 0;
	    while(counter <(numPlayers * 7)){
		for (Player p : players){
		    p.addToHand(_deck.get(counter));
		    _deck.remove(counter);
		    counter += 1;
		}
	    }
	    _cardsDealt += (7*numPlayers); 
	}
	else { //4-5 inclusive players = 5 cards each 
	    int counter = 0;
	    while(counter <(numPlayers * 5)){
		for (Player p : players){
		    p.addToHand(_deck.get(counter));
		    _deck.remove(counter);
		    counter += 1;
		}
	    }
	    _cardsDealt += (5*numPlayers); 
	}
	//makePool();
     }

    
    //removes the first Card from the _deck
    public void removeFromDeck(){
	_deck.remove(0);
	_cardsDealt += 1;
    }
					     

    //ACCESSORS ============================================
    public int getCardsDealt() {
	return _cardsDealt;
    }

    public ArrayList<Card> getDeck(){
	return _deck;
    }
    //====================================================

    
    //overwritten toString()
    public String toString(){
	return _deck.toString();
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
