import java.util.ArrayList;

public class OrderedCards{ // wrapper class of ArrayList

    private ArrayList<Card> _data;
  /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    
    /********** OrderedCards() **********
  default constructor
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public OrderedCards(){
	_data = new ArrayList<Card>();
    }
    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/
    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public int size() {
	return _data.size(); 
    }

    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public Card get( int index ) {
	return _data.get(index); 
    }
    
    /*--------------------------------------------------
      ~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~
      -------------------------------------------------*/

    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public String toString() {
	return _data.toString();  
    }

    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public Card remove( int index ) {
	return _data.remove(index); 
    }


    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
    public void addLinear( Card newVal ) {
	int index = 0; 
	for (int x = 0; x < _data.size() ; x++){
	    if (newVal.compareTo(_data.get(x)) >= 0 ){
		index += 1;
	    }
	}
	_data.add(index, newVal);

    }
    
    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
   public void addBinary(Card newCard){
	_data.add(binarySearch(newCard, _data.size(), 0), newCard);
    }

    /********** methodName() **********
		description
     // PRECOND::
     // POSTCOND::
     // EX:
     ******************************/
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
