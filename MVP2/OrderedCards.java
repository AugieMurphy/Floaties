import java.util.ArrayList;

public class OrderedCards{ // wrapper class of ArrayList

    private ArrayList<Card> _data;
  /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    
    /********** OrderedCards() **********
  default constructor
     ******************************/
    public OrderedCards(){
	_data = new ArrayList<Card>();
    }
    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    /********** size() **********
		returns the size of _data
     // PRECOND:: _data has been instantiated 
     ******************************/
    public int size() {
	return _data.size(); 
    }

    /********** get() **********
		returns the card at the given index in _data
     // PRECOND:: argument is a valid index of _data

     ******************************/
    public Card get( int index ) {
	return _data.get(index); 
    }
    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/

    /********** toString() **********
		returns a string representation of _data
     // PRECOND:: _data has been instantiated

     ******************************/
    public String toString() {
	return _data.toString();  
    }

    /********** remove() **********
		removes the card at the given index from _data
     // PRECOND:: argument is a valid index of _data
     // POSTCOND:: the card at the given index is removed, and all cards after it have been shifting to maintain left justification 

     ******************************/
    public Card remove( int index ) {
	return _data.remove(index); 
    }


    /********** addLinear() **********
		uses linear search to add the given card
     // PRECOND:: _data is sorted
     // POSTCOND:: card newVal has been added to the array; the sort has been maintained 

     ******************************/
    public void addLinear( Card newVal ) {
	int index = 0; 
	for (int x = 0; x < _data.size() ; x++){ // go through all indices in _data
	    if (newVal.compareTo(_data.get(x)) >= 0 ){ // keep incrementing index until it reaches desired value -- index where card newVal belong
		index += 1;
	    }
	}
	_data.add(index, newVal); // add newVal at proper index

    }
    
    /********** addBinary() **********
	       uses a binary search to add card newVal to _data (recursive implementation)
     // PRECOND:: _data is sorted
     // POSTCOND:: card newVal has been added to _data; _data remains sorted
     ******************************/
   public void addBinary(Card newCard){
	_data.add(binarySearch(newCard, _data.size(), 0), newCard);
    }

    /********** binarySearch() **********
		helper function for addBinary()
     // PRECOND:: _data is sorted
     // POSTCOND:: returns the correct index at which card newCard should be added to maintain sort
     ******************************/
    public int binarySearch(Card newCard, int high, int low){
	if (high == low){ // if upper and lower bounds are equal, they are at the correct index
	    return high; }
	else {
	    int checkPos = (high + low) / 2; // take index in the middle of the upper and lower bounds
	    if ((_data.get(checkPos)).compareTo(newCard) > 0){ // if the middle card is bigger than newCard, try again with the middle position as the new upper bound
		return 	binarySearch(newCard, checkPos, low);
	
	    }
	    else if (_data.get(checkPos).compareTo(newCard) < 0){ // if the middle card is smaller than newCard, try again with the index after the middle position as the new lower bound
	       	return binarySearch(newCard, high, checkPos + 1);
	    }
	    else { return checkPos; } // if the middle card and newCard are equal, add newCard here!
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
