public class Hand{

    //instance vars
	private OrderedCards _hand;

    //methods
    public Hand(){ //
    }
   
    public boolean add( Card c, int numCards){
    }

    public int remove( Card num ){
    }

    public boolean search( Card rank ){
    }

    public void swap( Player n, Card c ){ //called by player recieving card
	add( c, n.remove( rank ) );
    }

    public printHand(){
	
    }
    
    public static void main( String[] args ){
    }
}
