//you don't have to import ArrayList

public class Deck extends Card{

    private ArrayList<Card> _deck;
    //private int _cardsDealt ;

    // Creates a deck of 52 cards
    public Deck(){
	//_cardsDealt = 0;
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
	_deck.toString(); //why not this
	/***
	String retStr = "";
	for (int x =0; x < _deck.size() ; x++){
	    if (x != 0 && x%4 == 0){
		retStr+="\n";
	    }
	    retStr += _deck.get(x) + "     ";
	}
	return retStr;
	***/
    }

    public void deal( Player[] _players ){
	shuffle();
	for( Player p: _players ){
	    for( int x = 0; x > 5 ; x-- ){
		p.add( _deck.remove( x ) );
	    }
	}
    }
   
    public int getSize(){
	return _deck.size();
    }

    
    public static void main( String[] args ){
	Deck deck1 = new Deck();	
	//	System.out.println(deck1);
	//	System.out.println(deck1.getSize());
	deck1.shuffle();
	System.out.println(deck1);
	
    }
}
