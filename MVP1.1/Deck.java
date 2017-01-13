import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> _deck;
    private int _cardsDealt ;

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
    }

    public void shuffle(){
	for (int x = 0; x < _deck.size() ; x ++){
	    int randI1 = (int) (Math.random() *51);
	    int randI2 = (int) (Math.random() *51);
	    _deck.set(randI1, _deck.set(randI2,_deck.get(randI1)));
	}
    }

    public String toString(){
	String retStr = "";
	for (int x =0; x < _deck.size() ; x++){
	    if (x != 0 && x%4 == 0){
		retStr+="\n";
	    }
	    retStr += _deck.get(x) + "     ";
	}
	return retStr;
    }

     public void deal( Player[] players ){
	shuffle();
	int numPlayers = players.length;
	if (numPlayers <= 3){
	    int counter = 0;
	    while(counter <(numPlayers * 7)){
		for (Player p : players){
		    p.addToHand(_deck.get(counter));
		    counter += 1;
		}
	    }
	    _cardsDealt -= (7*numPlayers); 
	}
	else {
	    int counter = 0;
	    while(counter <(numPlayers * 5)){
		for (Player p : players){
		    p.addToHand(_deck.get(counter));
		    counter += 1;
		}
	    }
	    _cardsDealt -= (7*numPlayers); 
	}
     }
   
    public int getSize(){
	return _deck.size();
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
	System.out.println(player1.showHand());
	
    }
}
