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

    public int ask(Player p, int rank){
	int startPt  = p.search(rank);
	int frequency = 0;
	Hand pHand = p.getHand();
	if (startPt == -1){
	    frequency = -1;
	}
	else {
	    while ((pHand.get(startPt)).getRank() == rank){
		addToHand(p.removeFromHand(startPt));
		frequency += 1;
	    }
	}
	return frequency; 
    }

    //returns start point that represents the index of the _hand in which the given rank was found
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

    //returns number of new books found 
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
	retStr = retStr.subString(0,retStr.length() -2);
	return retStr;
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


