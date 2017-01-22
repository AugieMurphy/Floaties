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

     /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    

    //default constructor
    //    public Card (){
    //	_suit = -1;
    //	_rank = 0;
    //}
    
    /********** methodName() **********
 			description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    // overloaded constructor
    public Card( int newRank, int newSuit ){
	_suit = newSuit;
        _rank = newRank; 
    }
    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    //Accessors ===============================
    public int getSuit(){
	return _suit;
    }

    // accesses rank
    public int getRank(){
	return _rank;
    }

    public String faceValue(){ // accessor called in toString()
	if( _rank == JACK ){ return " Jack"; }
	if( _rank == QUEEN ){ return " Queen"; }
	if( _rank == KING ){ return " King";  }
	if( _rank == ACE ){ return " Ace"; }
	return "" + _rank;
    }
    public String suitStyle(){ // accessor called in toString()
    	String retSuit = "";
	if( _suit == HEARTS){ return " of hearts"; } // " ♡ "; }
	if( _suit == SPADES ){ return " of spades"; } // " ♤ "; }
	if( _suit == DIAMONDS ){ return " of diamonds";} // " ♢ "; }
	if( _suit == CLUBS ){ return " of clubs"; } // " ♧ "; }
	return "" + _suit;
    }
    //=========================================

    /********** methodName() **********
		compares cards
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public int compareTo(Object other ){
	if(_rank == ((Card) other)._rank && _suit == ((Card) other)._suit  )
	    {return 0; }
	else if(_rank < ((Card)other)._rank)
	    {return -1;}
	else {
	    return 1;
	}
    }
    //same code, i just wanted to suggest stuff but it was confusing to comment next to it so i put it below. the format just allows comparison of cards of the same rank. Ultimately, it will get the cards in rank order either way. This way they also compare suits.
    /***
    public int compareTo(Object other ){
	int compare2 = ((Card)other).getRank();
	if( _rank == compare2 ){
	    int compare2 = ((Card)other).getSuit();
	}
	if( _rank < compare2 ){ return -1; }
	if( _rank > r2 ){ return 1; }
	else{ return 0; }
    }
     ***/

    /********** methodName() **********
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public String toString(){ //else if doesn't make sense here. rank is final. If it has one rank, it won't fall into multiple ifs.
	// String retRank = "";
	// if( _rank == JACK ){ retRank = "JACK"; }
	// if( _rank == QUEEN ){ retRank = "QUEEN"; }
	// if( _rank == KING ){ r "KING";  }
	// if( _rank == ACE ){ return "ACE"; }
	
	//else {retStr += _rank + " of ";} //i think printing th suits is clearer
	//String retSuit = "";
	//if( _suit == HEARTS){ retSuit = " of hearts"; } // " ♡ "; }
	//if( _suit == SPADES ){ retSuit = " of spades"; } // " ♤ "; }
	//if( _suit == DIAMONDS ){ retSuit = " of diamonds";} // " ♢ "; }
	//if( _suit == CLUBS ){ retSuit = " of clubs"; } // " ♧ "; }
        return "[" + faceValue() + suitStyle() + "]";
    }


    public static String numToRank(int numRank){
	if (numRank == Card.ACE){
	    return "Ace";
	}
	else if (numRank == Card.KING){
	    return "King";
	}
	else if (numRank == Card.QUEEN){
	    return "Queen";
	}
	else if (numRank == Card.JACK){
	    return "Jack";
	}
	else {
	    return String.valueOf(numRank);
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
