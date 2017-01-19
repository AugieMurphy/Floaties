import java.util.ArrayList;

public class OrderedCards{ // wrapper class for class Hand

    private ArrayList<Card> _data;

    public OrderedCards(){
	_data = new ArrayList<Card>();
    }
    
    public String toString() {
	return _data.toString();  
    }


    public Card remove( int index ) {
	return _data.remove(index); 
    }


    public int size() {
	return _data.size(); 
    }

    
    public Card get( int index ) {
	return _data.get(index); 
    }

    
    public void set( int index , Card c){
	_data.set(index, c);
    }


    public void addLinear( Card newVal ) {
	int index = 0; 
	for (int x = 0; x < _data.size() ; x++){
	    if (newVal.compareTo(_data.get(x)) >= 0 ){
		index += 1;
	    }
	}
	_data.add(index, newVal);

    }


    public void addBinary(Card newCard){
	_data.add(binarySearch(newCard, _data.size(), 0), newCard);
    }
    
    public int binarySearch(Card newCard, int high, int low){
	if (high == low){
	    return high; }
	else {
	    int checkPos = (high + low) / 2;
	    if ((_data.get(checkPos)).compareTo(newCard) > 0){
		return 	binarySearch(newCard, checkPos, low);
		
	    }
	    else if (_data.get(checkPos).compareTo(newCard) < 0){
	       	return binarySearch(newCard, high, checkPos + 1);
	    }
	    else { return checkPos; }
	}
    }
   
    
    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedCards Franz = new OrderedCards();

	System.out.println("\nValues to add via addBinary() calls:");

	// testing binary  search

	int x = 5;
	while( x > 0 ){
	    
	    int suit = (int)(Math.random() * 3); //random suit
	    int rank = (int)(Math.random() * 12); //random rank
	    
	    Card c = new Card(rank,suit);
	    System.out.println( "Card to add --> " + c );
	    Franz.addBinary(c);
	    System.out.println( "Current Franz: " + Franz );
	    
	    x--;
	}

	System.out.println("\npopulated Franz: :");
	System.out.println( Franz );

    }

}
