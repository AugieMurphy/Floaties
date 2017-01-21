import java.util.ArrayList;
public abstract class Player {
    
    // instance vars
    protected Hand _hand;
    protected int _numBooks;
    protected ArrayList<Integer> _typesOfBooks;
    protected String _name;   
    

    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    
    /********** Player() **********
	   default constructor
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public Player(){ 
	_hand = new Hand();
	_numBooks = 0;
	_typesOfBooks = new ArrayList<Integer>();
    }
    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    
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

    abstract public String getName();
    //=================================================
    
    /* since player is never instantiated knowing their hand, this isn't necessary. Not a criticism, it's just that they have to be added to turn and then be dealt cards. Now we have draw and stuff to deal with other issues */
    
    // public Player(Hand hand){ // should take name param
    //	this();
    //	_hand = hand;
    // }


    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~
      These methods allow the Player to interact with their cards and other players once they have implemented getName()...(more info here)
      -------------------------------------------------*/
    
    /********** showHand() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public String showHand(){
	return _hand.toString();
    }

    /********** addToHand() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public boolean addToHand(Card c){
	_hand.add(c);
	return true;
    }

    /********** removeFromHand() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public Card removeFromHand(int i){
	return _hand.remove(i);
    }

    /********** draw() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public void draw(Deck d, int numCards) {
	for (int x =0; x < numCards; x++){
	    //addToHand(d.getDeck().get(0));
	    ///d.removeFromDeck();
	    addToHand(d.removeFromDeck());
	}	
    }

    /********** draw() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public void draw(Deck d){ //so that drawing one card doesn't require more variables in driver
	Card printCard = d.removeFromDeck();
	addToHand(printCard);
	System.out.println(printCard);
    }	

    /********** ask() **********
     // PRECOND::
     // POSTCOND:: 
     // EX:
     ******************************/
     public int ask(int rank, Player p){
	int frequency = 0;
	for( int startPt = p.search(rank); (p.getHand()).get(startPt) == (p.getHand()).get(startPt+frequency); frequency++ ){
	    addToHand(p.removeFromHand(startPt));
	}
	return frequency;
    }

    /********** search() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
     public int  search(int rank){
	int start = -1;
	for (int x = 0; x < _hand.getHandSize(); x++){
	    if ((_hand.get(x)).getRank() == rank) {
		start = x;
		break;
	    }
	}
	return start;
    }

    /******* checkForBooks() *******
     // PRECOND::
     // POSTCOND:: 
     // EX:
     ******************************/
     public int checkForBooks(){
	int newBooks = 0;
	for (int x = 0; x < _hand.getHandSize()-3; x++){
	    if (_hand.get(x).getRank() == _hand.get(x+3).getRank()){
		_typesOfBooks.add((_hand.get(x)).getRank());
		for (int z = 0; z < 4; z++){
		    removeFromHand(x);
		}
		newBooks += 1;
	    }
	}
	_numBooks += newBooks;
	return newBooks; 
    }

    /********** printNewBooks() **********
     // PRECOND::
     // POSTCOND:: returns a String representation of hand
     // EX:
     ******************************/
    public String printNewBooks(){
	int newBooks = checkForBooks();
	String retStr = "new books: ";
	for (int c = _typesOfBooks.size()-newBooks; c < _typesOfBooks.size(); c++){
	    if (c == Card.ACE){
		retStr += "Aces, ";
	    }
	    else if (c == Card.KING){
		retStr += "Kings, ";
	    }
	    else if (c == Card.QUEEN){
		retStr += "Queens, ";
	    }
	    else if (c == Card.JACK){
		retStr += "Jacks, "; 
	    }
	    else {
		retStr += c + ", ";
	    }
	}
	retStr = retStr.substring(0,retStr.length() -2);
	return retStr;
    }

    
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

	System.out.println("\n*******************************************");
		


	Player[] murphy = new Player[4];
	System.out.println("Creating players augie, silo, lucy, and sully...");
	
	Player august = new Human("augie");
	Player lucy = new Human("lucy");
	Player sullivan = new Human("sully");
	Player silo = new Human("silo");
	System.out.println("Putting players into array of players --> murphy");

	murphy[0] = august;
	murphy[1] = silo;
	murphy[2] = lucy;
	murphy[3] = sullivan;
	
	Deck d = new Deck();
	d.deal( murphy );

	System.out.println("\naugie's hand: ");
	System.out.println( august.showHand() );
	
	System.out.println("\nsilo's hand: ");
	System.out.println( silo.showHand() );
	
	System.out.println("\nlucy's hand: ");
	System.out.println( lucy.showHand() );

	System.out.println("\nsully's hand: ");
	System.out.println( sullivan.showHand() );
	
	System.out.println("\nlucy is searching for a 6...");
	System.out.println("\tlucy has a 6? --> " + lucy.search(6) );
	System.out.println( "\tSee for yourself...\n\t" + lucy.showHand() );
	
	System.out.println("\naugie is asking sully for an eight... ");
	
	Card cardO = new Card (8, Card.SPADES);
	Card cardI = new Card(8, Card.HEARTS);
	sullivan.addToHand(cardO);
	sullivan.addToHand(cardI);
	System.out.println("sully's hand: ");
	System.out.println( sullivan.showHand() );

	System.out.println("augie's hand: ");
	System.out.println( august.showHand() );
	

	System.out.println("sully has an eight is --> " + sullivan.search(8));
	
	System.out.println("augie gets an eight is --> " + august.ask( 8,sullivan ));
	
	System.out.println("sully's hand now: ");
	System.out.println( sullivan.showHand() );

	System.out.println("augie's hand now: ");
	System.out.println( august.showHand() );
	
	System.out.println("silo's hand now: ");
	System.out.println( silo.showHand() );
	
	System.out.println("silo is drawing a card...");
        silo.draw(d);

	System.out.println("silo's hand now: ");
	System.out.println( silo.showHand() );
	
    }

}


