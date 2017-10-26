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
    


    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~
      These methods allow the Player to interact with their cards and other players once they have implemented getName()
      -------------------------------------------------*/
    
    /********** showHand() **********
     // POSTCOND:: returns a String representation of hand

     ******************************/
    public String showHand(){
	return _hand.toString();
    }

    /********** addToHand() **********
     // POSTCOND:: card c is added to hand such that hand remains sorted; if executed correctly, returns true

     ******************************/
    public boolean addToHand(Card c){
	_hand.add(c);
	return true;
    }

    /********** removeFromHand() **********
     // PRECOND:: int i is a valid index in _hand
     // POSTCOND:: the card at index i in _hand has been removed; _hand is left justified; the Card that has just been removed is returned
     ******************************/
    public Card removeFromHand(int i){
	return _hand.remove(i);
    }

    
    /********** draw() **********
     // PRECOND:: numCards is less than the size of Deck d
     // POSTCOND:: adds numCards cards to the player's hand, and removes those cards from the deck
     ******************************/
    public void draw(Deck d, int numCards) {
	int x = 0;
	while (x<numCards && d.getDeck().size() > 0){
	    addToHand(d.removeFromDeck());
	    x+=1;
	}
    }

   

    /********** ask() **********
     // PRECOND:: the  player invoking the method is not the same as the Player given as the parameter; this and player p both have hands which have been instantiated; rank is between 1 and 13, inclusive
     // POSTCOND:: if the current player doesn't have a card of rank, returns -1; otherwise, all cards of rank are removed from player p's hand, and added to the current player's hand; the number of cards given is returned
     ******************************/
     public int ask(int rank, Player p){
	 int myStartPt = this.search(rank); // index of first instance of rank in hand
	 int startPt = p.search(rank); // index of first instance of rank in hand
	 if (myStartPt == -1){ // if current player doesn't have a card of rank
	     return -1;
	 }
	 int frequency = 0;	 
	 if (startPt == -1){ // if player being asked doesn't have a card of rank 
	     return frequency;  // return num of cards given (0)
	 }
	 else {
	     while (((p.getHand()).get(startPt)).getRank() == rank){ // while the card at index startPt is of the desired rank
		 addToHand(p.removeFromHand(startPt)); // remove that card and add it to the current player's hand
		 frequency ++; // increment the count of cards given
		 if (startPt >= (p.getHand()).size()){ // if the start point is now no longer a valid index in the player being asked's hand
		     break;
		 }
	     }
	     return frequency; // return the number of cards given
	 }
    }

    /********** search() **********
     // PRECOND:: rank is between 1 and 13, inclusive
     // POSTCOND:: returns the index of the first instance of a card with the given rank; if none exists, returns -1
     ******************************/
     public int search(int rank){
	int start = -1;
	for (int x = 0; x < _hand.size(); x++){
	    if ((_hand.get(x)).getRank() == rank) {
		start = x;
		break; // exits early if target is found
	    }
	}
	return start;
    }

    /******* checkForBooks() *******
      // PRECOND:: _hand is sorted
     // POSTCOND:: removes any complete books (four cards of the same rank) from the player's hand, adds the rank of that book to _typesOfBooks, increments _numBooks by number of newBooks, and returns number of newBooks
     ******************************/
     public int checkForBooks(){
	int newBooks = 0;
	for (int x = 0; x < _hand.size()-3; x++){ 
	    if (_hand.get(x).getRank() == _hand.get(x+3).getRank()){ // if the current card and the card three indices after it are the same
		_typesOfBooks.add((_hand.get(x)).getRank()); // add the current card's rank to player's typesOfBooks
		for (int z = 0; z < 4; z++){ // removes all 4 cards of that rank
		    removeFromHand(x);
		}
		newBooks += 1;
	    }
	}
	_numBooks += newBooks;
	return newBooks; 
    }

    /********** printNewBooks() **********
     // POSTCOND:: returns a String of "new books: " + the rank of each new book

     ******************************/
    public String printNewBooks(int newBooks){
	String retStr = "new books: ";
	for (int c = _typesOfBooks.size()-newBooks; c < _typesOfBooks.size(); c++){
	    if (_typesOfBooks.get(c) == Card.ACE){
		retStr += "Aces, ";
	    }
	    else if (_typesOfBooks.get(c) == Card.KING){
		retStr += "Kings, ";
	    }
	    else if (_typesOfBooks.get(c) == Card.QUEEN){
		retStr += "Queens, ";
	    }
	    else if (_typesOfBooks.get(c) == Card.JACK){
		retStr += "Jacks, "; 
	    }
	    else {
		retStr += _typesOfBooks.get(c) + "'s, ";
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
	System.out.println("JAKE: " + player1.showHand());	
	//System.out.println(player1.printNewBooks());
	System.out.println("JAKE: " + player1.showHand());		
	
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

	/*
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
	*/
	
    }//end main

}//end Player


