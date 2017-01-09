public class Deck{

    private <Card>Arraylist _deck;

    // Creates a deck of 52 cards
    public deck(){
	for( int x = 0; x < 52; x++ ){
	    _deck.add( x, x % 4 );
	}
    }

    //to swap
    public void swap(){
    }
    
    // Deals 5 cards to each player
    public void deal( int numPlayers ){
	shuffle();
	//deal
    }

    // swap at each index
    public void shuffle(){
    }
	

    
    public static void main( String[] args ){
    }
}
