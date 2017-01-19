import java.util.ArrayList;
public abstract class Player {
    
    // instance vars
    protected Hand _hand;
    protected int _numBooks;
    protected ArrayList<Integer> _typesOfBooks;
    protected String _name;   
    
    // default constructor
    public Player(){ 
	_hand = new Hand();
	_numBooks = 0;
	_typesOfBooks = new ArrayList<Integer>();
    }

    public Player(Hand hand){
	this();
	_hand = hand;
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
	    addToHand(d.getDeck().get(0));
	    d.removeFromDeck();
	}	
    }

    public int ask(Player p, int rankk){
	if (_hand.frequency(rankk) == 0){ //aren't allowed to ask for a rank of cards you don't have
	    return -1; 
	}
	else {
	    ArrayList<Integer> indexess = p.search(rankk); 
	    if (indexess.size() > 0){
		for (int x : indexess){
		    addToHand(p.removeFromHand(x));
		}
	    }
	    return indexess.size();
	}
    }
    
    public ArrayList<Integer> search(int rank){
	ArrayList<Integer> indexes = new ArrayList<Integer>(); 
	for (int x = 0; x < _hand.size(); x++){
	    if ((_hand.get(x)).getRank() == rank) {
		indexes.add(x);
	    }
	}
	return indexes;
    }

    //returns number of new books found 
    public int checkForBooks(){
	int newBooks =0;
	for (int x = 0; x < _hand.size()-1; x++){
	    int counter = 1;
	    Card current = _hand.get(x);
	    for (int y = x+1; y < _hand.size(); y++){
		if((_hand.get(y)).getRank() != current.getRank()){
		    break;
		}
		else {
		    counter += 1;
		}
	    }   
	    if (counter  == 4){
		_typesOfBooks.add((_hand.get(x)).getRank());
		for (int z = 0; z < 4; z++){
		    removeFromHand(x);
		}
		newBooks += 1;
		_numBooks += 1;
	    }
	}
	return newBooks; 
    }

	
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
    
    public static void main(String[] args){


	Player player1 = new Human("jake");
        
	Card card1 = new Card(2, Card.HEARTS);
	Card card2 = new Card(2, Card.DIAMONDS);
	Card card3 = new Card(2, Card.CLUBS);
	Card card4 = new Card(2, Card.SPADES);
	Card[] cards = {card1, card2, card3, card4};
	for (Card ca : cards){
	    player1.addToHand(ca);
	}
	
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



	/*
	  	Player[] murphy = new Player[4];
	System.out.println("Creating players augie, silo, lucy, and sully...");
	
	Player august = new Player("augie");
	Player lucy = new Player("lucy");
	Player sullivan = new Player("sully");
	Player silo = new Player("silo");
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

	Card card1 = new Card(8, Card.SPADES);
	Card card2 = new Card(8, Card.HEARTS); 
	silo.add(card1);
	silo.add(card2);
	System.out.println("sully's hand: ");
	System.out.println( sullivan.showHand() );

	System.out.println("augie's hand: ");
	System.out.println( august.showHand() );
	
	System.out.println("sully has an eight is --> " + sullivan.search(8));
	
	System.out.println("augie gets an eight is --> " + august.ask( sullivan, 8 ));
	
	System.out.println("sully's hand now: ");
	System.out.println( sullivan.showHand() );

	System.out.println("augie's hand now: ");
	System.out.println( august.showHand() );
	
	System.out.println("silo's hand now: ");
	System.out.println( silo.showHand() );
	
	System.out.println("silo is drawing a card...");
	System.out.println( silo.draw(d) );

	System.out.println("silo's hand now: ");
	System.out.println( silo.showHand() );
	*/
 
	
    }

}


