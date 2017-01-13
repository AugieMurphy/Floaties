public class Card implements Comparable{

    //Instance Vars
    private int _rank;
    private int _suit;
    
    //suits
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;
    
    //face cards
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    //default constructor
    public Card (){
	_suit = -1;
	_rank = 0;
    }

    // overloaded constructor
    public Card( int newRank, int newSuit ){
	_suit = newSuit;
        _rank = newRank;
    }

    //Accessors ===============================
    public int getSuit(){
	return _suit;
    }

    // accesses rank
    public int getRank(){
	return _rank;
    }
    //=========================================


    // compares cards
    public int compareTo(Object other ){
	if(_rank == ((Card) other)._rank && _suit == ((Card) other)._suit  )
	    {return 0; }
	else if(_rank < ((Card)other)._rank)
	    {return -1;}
	else {
	    return 1;
	}
    }
    
    public static void main( String[] args ){
	Card card1 = new Card(ACE,DIAMONDS);
	Card card2 = new Card(2, CLUBS);
	System.out.println(card1.compareTo(card2));
    }
}
