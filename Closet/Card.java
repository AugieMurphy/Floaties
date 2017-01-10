public class card implements Comparable{

    //Instance Vars
    private int rank;
    private String suit;

    // overloaded constructor
    public Card( int newRank, String newSuit ){
	suit = newSuit;
        rank = newRank;
    }

    // accesses suit
    public String getSuit(){
	return suit;
    }

    // accesses rank
    public int getRank(){
	return rank;
    }

    // assignes int value to face card, seems useful but can be deleted
    public int faceValue( String face ){ //i'm attatched to the name :)
	if( face.equals( "king" ) ){
	    rank = 13;
	}
	if( face.equals( "queen" )){
	    rank = 12;
	}
	if( face.equals( "ace" ) ){
	    rank = 1;
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
