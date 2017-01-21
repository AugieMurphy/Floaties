import java.util.ArrayList;
public abstract class Player {
    
    // instance vars
    protected Hand _hand;
    protected int _numBooks;
    protected ArrayList<Integer> _typesOfBooks;
    // protected ArrayList<Card> _books; //commented out alternate pathway
    protected String _name;
    
    // default constructor
    public Player(){ 
	_hand = new Hand();
	_numBooks = 0;
	_typesOfBooks = new ArrayList<Integer>();
    }

    public boolean addToHand(Card c){
	_hand.add(c);
	return true;
    }

    public Card removeFromHand(int index){
	return _hand.remove(index);
    }

    public String showHand() {
	return _hand.toString();
    }

    public void draw(Deck d, int numCards) {
	for (int x =0; x < numCards; x++){
	    //addToHand(d.getDeck().get(0));
	    //d.removeFromDeck();
	    addToHand( d.remove() );
	}	
    }

    public int ask(Player p, int rank){
	int startPt  = p.search(rank); //remove already takes away the first card of the rank
	int frequency = 0;
	Hand pHand = p.getHand(); // ? it only gets used once, idk if it's worth labeling
	if (startPt == -1){
	    frequency = -1;
	}
	else {
	    // while ( (pHand.get(startPt)).getRank() == rank ){
	    while( p.frequency > 0 ){
		// addToHand(p.removeFromHand(startPt));
		// remove doesn't remove a card at an index, it removes the first card of that rank
		frequency += 1;
	    } 
	}
	return frequency; 
    }
    
    /*** this is from GoFish, i think it's more efficient, this method was the main reason i was so proud of my work. It was concise and that's why remove() removes the first card of rank r. pls tell me if there was another reason it was switched or if im missing someithing :p

    public boolean ask(Player p, int r){
	if( p.search(r)  > -1 ){ //used to be boolean but switched for this
	    while( p.frequency(r) > 0 ){
		_hand.add( p.remove(r) );
	    }
	    return frequency( r ); //this will work because you've already added all the cards to p's cards to this hand, used to return true.
	}
	return -1; //used to return false
    }
    ***/
    
    //	returns start point that represents the index of the _hand in which the given rank was found
    public int  search(int rank){
	// int start = -1;
	for (int x = 0; x < _hand.getHandSize(); x++){
	    if ( ((_hand.get(x)).getRank()) == rank) {
	        // start = x;
	        // break;
		return x; 
	    }
	}
	// return start;
	return -1;
    }
  

    //returns number of new books found
    //THIS SHOULD BE IN HAND... so Player will call _hand.newBooks();
    public int checkForBooks(){
	int newBooks =0;
	for (int x = 0; x < _hand.getHandSize() - 3; x++){ // - 4 i woulda thought
	    if ( ((_hand.get(x)).getRank()) == ((_hand.get(x+3)).getRank()) ){
		//System.out.println( (x) );
		System.out.println( _hand.get(x) );
		_typesOfBooks.add( (_hand.get(x)).getRank() ); //why not add the whole card. then you can display the books a character has rly prettily too.
		for (int z = 0; z < 4; z++){
		    removeFromHand(x); //remove removes the first card of that rank already, removeFromHand( (_hand.get(x)).getRank ) should work. but that's complicated. why say that for each card in hand with a frequency of 4, remove 4x? same idea, remove only first card and do it 4x, but it's kinda like ask in GoFish, i'll copy and paste an edited v belo so that comments dont get too confusing
		}
		newBooks++;
	    }
	}
	_numBooks += newBooks;
	return newBooks; 
    }

    /***
	public int checkBooks(){
	     for( Card c : _hand ){
               if( frequency( c ) == 4 ){
	            newBooks++;
	            for( int b = 0; b < 4; b++ ){                    
	                 _books.add( removeFromHand( c.getRank() ) ); // adds to books made at the same time
                    }
	       } 
	    }
            _numBooks += newBooks;
            for( int x = size() - 1; x < size() - newBooks(); x++ ){
                 System.out.println( _book.get(x) );
            }
            return newBooks;
       }
     ***/


	
    abstract public String getName();



    //ACCESSORS=========================================
    public int getNumBooks(){
	return _numBooks;
    }

    public Hand getHand(){
	return _hand;
    }

    public ArrayList<Integer> getTypesOfBooks(){
	return _typesOfBooks;
    }
    //=================================================


    /*
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
    */
    
    public static void main(String[] args){
	Player player1 = new Human("jake");
	Card card1 = new Card(2, Card.HEARTS);
	Card card2 = new Card(2, Card.DIAMONDS);
	Card card3 = new Card(2, Card.CLUBS);
	Card card4 = new Card(2, Card.SPADES);
	Card card5 = new Card(8, Card.SPADES);
	Card card6 = new Card(10, Card.SPADES);
	Card card7 = new Card(13, Card.SPADES);
	Card card8 = new Card(1, Card.SPADES);
	Card[] cards = {card1, card2, card3, card4,card5,card6,card7,card8};
	for (Card ca : cards){
	    player1.addToHand(ca);
	}
	System.out.println("player1: " + player1.showHand());	
	System.out.println(player1.checkForBooks());
	System.out.println(player1.getTypesOfBooks().toString());
	/*
	Player player2 = new Human("paul");
	Deck deck1 = new Deck();
	Player[] players = {player1,player2};
	deck1.deal(players);
      	System.out.println("Paul's Hand: " + player2.showHand());
	int cardsFound;
	System.out.println("jake asks paul for any kings");
	cardsFound = player1.ask(player2,Card.KING);
	System.out.println("Paul says - I have " + cardsFound + " king(s)");
	System.out.println("Cards Transfered");
	System.out.println("\n\nPaul's Hand: " + player2.showHand());
	System.out.println("\n\nJake's Hand: " + player1.showHand());
	*/
 
	
    }

}


