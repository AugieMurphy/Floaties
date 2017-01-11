public class Player {
    
    // instance vars
    private Hand _hand;
    private int turnNum;
    private int _numBooks;

    public Player(){ // constructor
	// implementation here
    }

    public int getNumBooks(){
	return _numBooks;
    }

    public int getTurnNum(){
	return turnNum;
    }

    public boolean ask(int rank, Player n){
	// insert implementation here -- calls Hand methods search, swap, etc.
    }

    
    public static void main(String[] args){
    }

}


