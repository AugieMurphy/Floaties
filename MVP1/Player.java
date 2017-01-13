public class Player {
    
    // instance vars
    private Hand _hand;
    private int _numBooks;

    public Player(){ // constructor
	_hand = new Hand();
	_numBooks = 0;
    }

    public int getNumBooks(){
	return _numBooks;
    }

    public boolean ask(Player n, card c){
        return n.search( c );
    }

    public int search(Card c){
	for( int x = 0; x < _hand.size(); x++ ){
	    if( _hand.get( x ).compareTo( c ) == 0 ){ count++ }
	}
	return count;
    }

    public boolean makeBooks(){
	for( int x = 0; x < _hand.size(); x++ ){
	    if( search( _hand.get(x) ) > 4 ){
		numBooks++;
      
	}
    }

    
    public static void main(String[] args){
    }

}


