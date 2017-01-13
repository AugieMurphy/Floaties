public class Hand{

    //instance vars
    private OrderedCards _hand;

    //methods
    public Hand(){
	_hand = new OrderedCards();

    }

    public Hand(Card[] cards){
	this();
	for (Card c: cards){
	    _hand.addBinary(c);
	}
    }

    public void addBinary(Card c){
	_hand.addBinary(c);
    }

    /*
    public boolean add( Card c, int numCards, int index){
	for (int i = 0; i < numCards; i++){
	    _hand.addAtIndex(index, c);
	}
	return true;
    }

 
    public int remove( Card num ){
	int count = 0;
	for( int x = 0; x < _hand.size(); x++ ){
	    if( _hand.get( x ).compareTo( c ) == 0 ){ count++; _hand.remove( x ); }
	}
	return count;
    }
 
    public boolean search( Card c ){
	for( int x = 0; x < _hand.size(); x++ ){
	    if( _hand.get( x ).compareTo( c ) == 0 ){ return true; }
	}
	return false;
    }

    public void swap( Player n, Card c ){ //called by player recieving card
	add( c, n.remove( rank ) );
    }
    */

    public String toString(){
	return _hand.toString();
	
    }
    
    public static void main( String[] args ){
	Card[] cards1 = new Card[1];
	Card card1 = new Card(Card.ACE, Card.CLUBS);
	cards1[0] = card1;
	Hand hand1 = new Hand(cards1);
	System.out.println(hand1);
    }
}
