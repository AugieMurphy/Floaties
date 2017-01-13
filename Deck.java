import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> _deck;
    private int _cardsDealt ;

    // Creates a deck of 52 cards
    public Deck(){
	_cardsDealt = 0;
	_deck = new ArrayList<Card>();
	for (int x =1; x<14; x++){
	    for (int y = 0; y < 4 ; y++){
		_deck.add( new Card(x,y));
		
	    }
	}
    }

    public String toString(){
	String retStr = "";
	for (int x =0; x < _deck.size() ; x++){
	    if (x != 0 && x%4 == 0){
		retStr+="\n";
	    }
	    retStr += _deck.get(x) + "     ";
	}
	return retStr;
    }
    
    public static void main( String[] args ){
	Deck deck1 = new Deck();	
	System.out.println(deck1);
    }
}
