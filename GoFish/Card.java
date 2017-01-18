public class Card implements Comparable{

    //Instance Vars
    private final int _rank;
    private final int _suit;
    
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

    public String faceValue(){
	if( _rank == JACK ){ return " JACK"; }
	if( _rank == QUEEN ){ return " QUEEN"; }
	if( _rank == KING ){ return " KING";  }
	if( _rank == ACE ){ return " ACE"; }
	return " " + _rank;
	
    }
    //=========================================

    public String toString(){
	String retSuit = " ";
	if( _suit == HEARTS){ retSuit = "♡ "; }
	if( _suit == SPADES ){ retSuit = "♤ "; }
	if( _suit == DIAMONDS ){ retSuit = "♢ "; }
	if( _suit == CLUBS ){ retSuit = "♧ "; }
        return "[" + faceValue() + retSuit + "]";
    }

    // compares cards
    public int compareTo(Object other ){
	int r2 = ((Card)other).getRank();
	if( _rank == r2 ){
	    int s2 = ((Card)other).getSuit();
	    if( _suit < s2 ){ return -1; }
	    if( _suit > s2 ){ return 1; }
	    else{ return 0; }
	}
	else{
	    if( _rank < r2 ){ return -1; }
	    if( _rank > r2 ){ return 1; }
	    else{ return 0; }
	}
    }
    
    public static void main( String[] args ){

	System.out.println("Creating new cards... \n");
	
	System.out.print("\nHere's Card One: ");	
	Card card1 = new Card(ACE,DIAMONDS);
	System.out.print( card1 );
	
	System.out.print("\nHere's Card Two: ");
	Card card2 = new Card(2, CLUBS);
	System.out.print( card2 );

	System.out.print("\nThe Higher Ranked Card IIIISSSS: ");
        if( card1.compareTo(card2) < 0 ){
	    System.out.print( card2 + "\n");
	}
	else{
	    System.out.print( card1 + "\n");
	}
    }
}
