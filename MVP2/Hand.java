public class Hand{ // wrapper class for the OrderedCards class

    
    //instance vars
    private OrderedCards _hand;

    //default constructor
    public Hand(){
	_hand = new OrderedCards();

    }

    //overloaded constructor
    public Hand(Card[] cards){
	this();
	for (Card c: cards){
	    _hand.addBinary(c);
	}
    }

    public boolean add(Card c){
	_hand.addBinary(c);
	return true;
    }

    public Card remove(int index){
	return _hand.remove(index);
    }
    

    //ACCESSORS =======================
    public int size(){
	return _hand.size();
    }

    public Card get(int index) {
	return _hand.get(index);
    }
    
    //==================================
    
    //overwritten toString()
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
