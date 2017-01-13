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

    public void addBinary(Card newVal) {
	if (_data.size() == 0) {
	    _data.add(newVal);
	    return;
	}
	int low = 0;
	int high = _data.size()-1;
	int midPt =0;
	while (high >= low) {
	    midPt = (high+low)/2;
	    if (newVal.compareTo(_data.get(midPt)) == 0) {
		_data.add(midPt,newVal);
		return;
	    }
	    else if(newVal.compareTo(_data.get(midPt)) < 0) {
		high = midPt-1;
	    }
	    else {
		low = midPt+1;
	    }   
	}
	_data.add(midPt, newVal);
	
    }

   
    
    // main method solely for testing purposes
    public static void main( String[] args ) {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	OrderedCards Franz = new OrderedCards();

	System.out.println("\nValues to add via addBinary() calls:");

	// testing binary  search
	for( int i = 0; i < 4; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addBinary( valToAdd );
	}

	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println();

	
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}
