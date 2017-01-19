public class Human extends Player{

    public Human(String name){
	super(name);
    }
    
    public Human (String name, Hand hand){
	super(name);
	
    }

    public String getName(){ // accessor
	return _name;
    }

	
    public static void main(String[] args){
	//Hand hand1 = new Hand();
	Player human1 = new Human("josh");
	System.out.println(human1.showHand());

	Deck d = new Deck();
	Player[] p = new Player[1];
	p[0] = human1;

	d.deal( p );

	System.out.println(human1.showHand());
    }


}
