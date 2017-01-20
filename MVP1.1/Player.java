public abstract class Player {
    
    // instance vars
    protected Hand _hand;
    protected int _numBooks;

    
    // default constructor
    public Player(){ 
	_hand = new Hand();
	_numBooks = 0;
    }

    public Player(Hand hand){
	this();
	_hand = hand;
    }

    public boolean addToHand(Card c){
	_hand.add(c);
	return true;
    }

    public String showHand() {
	return _hand.toString();
    }

    

   

    abstract public String getName();



    //ACCESSORS=========================================
    public int getNumBooks(){
	return _numBooks;
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
	/*	Hand hand1 = new Hand();
	Player player1 = new Player(hand1);
	//	System.out.println(player1.showHand());
	Card card1 = new Card(Card.JACK, Card.HEARTS);
	player1.addToHand(card1);
	System.out.println(player1.showHand()); */
	
    }

}


