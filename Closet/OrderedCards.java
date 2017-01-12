public class OrderedCards{ // wrapper class for class Hand

    private Hand _hand;

    public OrderedCards{ // constructor
	// insert implentation here
    }
    
    
    public boolean search(Card c){
	_hand.search(c);
    }
    
    public int remove(Card num){
	_hand.remove(num);
    }
    
    // precon: _hand is a instance of class hand with instance var ArrayList<Card>, which is sorted
    // postcon: Card c is added to the Array in the proper position to maintain the sort
    public boolean addBinary(Card c,int numCards){
	// insert implentation here
    }
    
    public void swap(Player n, Card c){
	_hand.swap(Player n, Card c);
    }

    public String showHand(){
	_hand.showHand();
    }
    public static void main( String[] args ){
    }
}
