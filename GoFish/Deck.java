import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> _deck;

    public Deck(){
	_deck = new ArrayList<Card>();
	for( int suit = 0; suit < 4; suit++ ){
	    for( int rank = 1; rank < 14; rank++){
		Card c = new Card(rank,suit);
		_deck.add(c);
	    }
        }
       	shuffle();
    }
    
    public void shuffle(){
	for( int x = 0; x < 52; x++ ){
	    int randInt = (int)(Math.random() * 51);
	    _deck.set( randInt, _deck.set( x, _deck.get(randInt) ) );
	}
    }

    public void deal( Player[] players){
	for( Player p: players ){
	    if( players.length <= 3 && _deck.size() >= 21){
		for( int x = 0; x < 7; x++ ){
		    p.add( _deck.remove(0) );
		}
	    }
	    else if( _deck.size() >= players.length * 5 ){
		for( int x = 0; x < 5; x++ ){
		    p.add( _deck.remove(0) );
		}
	    }
	}
    }

    public Card draw(){
	return _deck.remove(0);
    }

      public int cardsLeft(){
    	return _deck.size();
    }

    public String toString(){
	return _deck.toString();
    }
    

    public static void main( String[] args ){
	
	System.out.println("Creating new deck happy... \n");
	Deck happy = new Deck();
	System.out.println(happy);

	System.out.println("\nShuffling happy... \n");
	happy.shuffle();
	System.out.println(happy);

	System.out.println("\nDealing happy to 5 people...");
	Player[] turner = new Player[5];
	
	Player a = new Player("tired");
	Player b  = new Player("bob");
        Player c = new Player("lizzy");
	Player d  = new Player("jackson");
	Player e  = new Player("sleeepppp");
	
	turner[0] = a;
	turner[1] = b;
	turner[2] = c;
	turner[3] = d;
	turner[4] = e;

	happy.deal( turner );

	System.out.println("\nHere's what's left of happy...\n");
	System.out.println(happy);

    }
}
