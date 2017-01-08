public class card implements Comparable{

    //Instance Vars
    private int rank; //We can change back to int
    private String suit;
    private Boolean faceCard; //True if it's a face card

    // overloaded constructor
    public Card( Object newRank, String newSuit ){
	suit = newSuit;
	if( rank is-a-String ){
	    rank = faceValue( );
	}
    }

    // accesses suit
    public String getSuit(){
	return suit;
    }

    // accesses rank
    public Object getRank(){
	return rank;
    }

    // assignes int value to face card
    public int faceValue( String face ){
	if( face.equals( "king" ) ){
	    rank = 13;
	}
	if( face.equals( "queen" )){
	    rank = 14;
	}
	if( face.equals( "ace" ) ){
	    rank = 13;
	}
	if( face.equals( "jack" )){
	    rank = 11;
	}
    }

    // compares cards
    public int compareTo( Card other ){
	if( faceCard ){ }
	else{ }
    }
    
    public static void main( String[] args ){
    }
}
