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

	/* =====================================
	OrderedCards Franz = new OrderedCards();

	System.out.println("\nValues to add via addBinary() calls:");

	// testing binary  search
	for( int i = 0; i < 10; i++ ) {
	    Card valToAdd = new Card((int) (13 * Math.random() + 1), (int)( 4 * Math.random()) );
	    System.out.println( valToAdd );
	    Franz.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println();

	====================================*/

    }

}
