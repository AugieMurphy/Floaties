import java.util.ArrayList;
public class Hand{

    private OrderedCards _hand;

    public Hand(){
	_hand = new OrderedCards();
    }

    public Card get( int index ){
	return _hand.get(index);
    }

    public void set( int index , Card c){
	_hand.set(index, c);
    }

    public boolean add( int numCards, Card c ){
	for (int i = 0; i < numCards; i++){
	    _hand.addBinary(c);
	}
	return true;
    }

    public Card draw(Deck pool){
	Card retCard = pool.remove(0);
	pool.remove(0);
	return retCard;
    }

    public boolean add( Card c ){
        _hand.addBinary(c);
	return true;
    }

    public Card remove( int r ){
	for( int x = 0; x < _hand.size(); x++ ){
	    if( ((_hand.get(x)).getRank()) == r ){
		Card retCard = _hand.get(x);
		_hand.remove(x);
		return retCard;
	    }
	}
	return null;
    }

    public int frequency( int rank ){
	int count = 0;
	for( int x = 0; x < _hand.size(); x++ ){
	    if( ((_hand.get(x)).getRank()) == rank ){ count++; }
	}
	return count;
    }

    public boolean search(int r){
	return frequency( r ) > 0;
    }
	
    public String toString(){
	return _hand.toString();
    }

    public static void main(String[] args){

	System.out.println("Creating new Hand: mine...");
	Hand mine = new Hand();

	System.out.println("Adding random cards...");

	int x = 5;
	while( x > 0 ){
	    
	    int suit = (int)(Math.random() * 3); //random suit
	    int rank = (int)(Math.random() * 12); //random rank
	    
	    Card c = new Card(rank,suit);
	    mine.add(c);
	    
	    x--;
	}

	System.out.println("Full mine: ");
	System.out.println( mine.toString() );
	
	System.out.println("\nSearching for an eight... ");
	System.out.println("mine has an eight --> " + mine.search(8) );


	System.out.println("Creating new Hand: repeat...");
	Hand repeat = new Hand();

	System.out.println("Adding three fours...");

	Card w = new Card(4,0);
	Card m = new Card(4,0);
	Card n = new Card(4,0);
	
	repeat.add(w);
	repeat.add(m);
	repeat.add(n);

	System.out.println("\nFinding frequency of 4 in repeat... " + repeat.frequency(4) );


	
    }
}
