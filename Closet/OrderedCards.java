public class OrderedCards{ // wrapper class for class Hand

    private Hand _hand;

    public OrderedCards{ // constructor
	// insert implentation here
    }
    
    public int search(Card c){
	_hand.search(c);
    }
    
    public int remove(Card num){
	_hand.remove();
    }

    public boolean addBinary(Card c,int numCards){
	// insert implentation here
    }
    
    public void swap(Player n, Card c){
	_hand.swap(Player n, Card c);
    }
    public static void main( String[] args ){
    }
}
