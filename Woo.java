
public class Woo {

    public static void main(String[] args){
	try {
	    Deck deck1 = new Deck();
	    GoFish game1 = GoFish.setUp(deck1);
	    Player[] playerz = game1.getPlayers();
	    while (game1.getTotalBooks() < 13){
		game1.takeTurn(deck1);
		System.out.println(game1.scoreBoard());
	    }
	    // System.out.println(((Human) playerz[0]).getName() + ":");
	    //System.out.println(playerz[0].showHand());
	}
	catch(Exception exception){
	    System.out.println(exception);
	    // System.out.println
	}
    }

}
