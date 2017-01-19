import java.util.ArrayList;
public class Player{
    
    private Hand _hand;
    private int _numBooks;
    private String _name;

    public Player(String name){
	_hand = new Hand();
	_numBooks = 0;
	_name = name;
    }

    public boolean add(Card c){
	_hand.add(c);
	return true;
    }
    
    public String getName(){
	return _name;
    }
    
    public String showHand(){
        return _hand.toString();
    }

    public Card draw(Deck pool){
	return _hand.draw(pool);
    }
    
    
    public int numBooks(){
	return _numBooks;
    }
    
    
    public boolean search(int r){
	return _hand.search(r);
    }

    public Card remove(int r){
	return _hand.remove(r);
    }

    public boolean ask(Player p, int r){
	if( p.search(r) ){
	    while( p.frequency(r) > 0 ){
		_hand.add( p.remove(r) );
	    }
	    return true;
	}
	return false;
    }
   

    public int frequency(int r){
	return _hand.frequency(r);
    }
    
    
    public static void main(String[] args){
	


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
	
    }
}
