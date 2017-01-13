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
	// insert implenetation here
    }

    public boolean search( Card c ){
	// insert implentation here
    }

    public void swap( Player n, Card c ){ //called by player recieving card
	add( c, n.remove( rank ) );
    }

    public String showHand(){
	// insert implentation here 
	
    }
    
    public static void main( String[] args ){
    }
}
