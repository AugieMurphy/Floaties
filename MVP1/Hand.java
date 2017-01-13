public class Hand{

    //instance vars
    private ArrayList<Card> _hand;

    //methods
    public Hand(){ // constructor
    } 

    // precon: there are exactly 4 instances of Card c existing throughout the game
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

    public String showHand(){
	_hand.toString();
	
    }
    
    public static void main( String[] args ){
    }
}
