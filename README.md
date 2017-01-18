Floaties
Augie Murphy, Sasha Fomina, Gabi Newman
APCS pd3
01/04/16

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~  GO FISH!!! ~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I. INTRODUCTION

This is a simulation of the card game Go Fish! that can be played via terminal prompt. It allows the user to choose single or multiplayer, the number of players, and the number of computer opponents.

     *******How To Play******

     The object of the game is to acquire the most books (four of a kind). 

     SETUP:
     Each player is dealt five cards.
     If they have four cards of the same rank, they are removed from their hand, and counted as one book.
     
     RULES:
     1) On their turn, a player can ask any other player if they have a card of a specific rank.
     	--> NOTE: You can only ask for a rank you have in your hand (if you have a three of spades, you can ask for threes. If you have no threes, you can't ask for them).
     2) If they do, the other player gives them all cards that they have of that rank.
     3) Otherwise, they draw one card from the remaining cards in the deck.
     4) If there are no cards left to draw and a player has no cards, they are skipped.
     
     TO WIN:
     The game ends when there are no cards left in play.
     The player with the most books wins. (OBJECT OF GAME, again)

     *******************


II. OUR IMPLEMENTATION

    Each Player has a Hand of Cards.
    Each player is dealt five cards from the Deck and the remaining cards become the “pool”.
    This is where the players will fish from. 


    The first user will be prompted for their _name and assigned the first _turn.
    Their _hand will be displayed in the terminal.
    Then, they will be prompted what card they’d like to ask for and who they want to ask.
    The askee will check their cards and if they have it, remove all cards of that rank from their _hand and the asker adds those cards to their _hand .
    Otherwise, the asker must fish.


III. OUTLINING THE CODE-ING-ISH STUFF

     A OrderedCards class, which is a wrapper class of ArrayList with an addBinary() that takes a Card as a parameter
     
     A Hand class with an OrderedCards<Cards> known as the _hand that can check (using binary search), add, and remove.
     
     A Card class  with a _rank and _suit , both being represented by integers
     
     A Player a _name, _hand, _turn number, and keeps track of their _numBooks. Each player can declare their name, and implement the interface deck. They should sort their hands as they receive cards. We’ll need an accessor for the name.
     
     Human extends Player
     
     AI extends Player
     
     A Deck class that holds an ArrayList of 52 Cards and can shuffle and deal.


