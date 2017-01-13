public class Human extends Player {

    private String _name;    // instance var

    public Human() { // constructor
	super();
	_name = "";
	
    }

    public Human(String name){
	this();
	_hand = new Hand();
	_name = name;
    }
    
    public Human (String name, Hand hand){
	super(hand);
	_name = name;
	
    }

    public String getName(){ // accessor
	return _name; }

	
    public static void main(String[] args){
	//Hand hand1 = new Hand();
	Human human1 = new Human("josh");
	System.out.println(human1.showHand());
    }


}
