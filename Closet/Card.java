public class card implements Comparable{

    //Instance Vars
    private int rank;
    private String suit;

    // overloaded constructor
    public Card( Object newRank, String newSuit ){
	suit = newSuit;
        rank = newRank;
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
	    rank = 12;
	}
	if( face.equals( "queen" )){
	    rank = 11;
	}
	if( face.equals( "ace" ) ){
	    rank = 13;
	}
	if( face.equals( "jack" )){
	    rank = 10;
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
