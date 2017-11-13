import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Deck {
	
	private ArrayList<Card> cards; //Record Suits and Numbers
	public ArrayList<Card> usedCard; //Record all used cards
	public int nUsed; //Record the quantities of used card
	
	// The constructor of Deck
	public Deck(int nDeck)
	{
		cards = new ArrayList<Card>(); // Create a new ArrayList (Record Suits and Numbers)
		usedCard = new ArrayList<Card>(); // Create a new ArrayList (Record all used cards)
		
		//Use for loop to generate a deck of cards into the ArrayList<Card>
		for (int a = 0 ; a < nDeck ; a++) 
		{
			for (Card.Suit s : Card.Suit.values()) 
			{
				for (int j = 1; j < 14 ; j++) //Input the rank data
				{
					Card card = new Card (s,j); 
					cards.add(card); //Generate each card
				}
			}
		}
		shuffle(); //Random the positions of cards
	}	
	
	public void printDeck()
	{
		for ( int i = 0 ; i < cards.size() ; i++ ) 
		{
			cards.get(i).printCard(); //Print out every single card from the ArrayList<Card>
		}
	}
	
	public ArrayList<Card> getAllCards()
	{
		return cards;
	}
	
	public Card getOneCard() 
	{
		if(usedCard.size() == cards.size()) //If already gave out 52 cards, then shuffle
		{
			shuffle();
		}
		usedCard.add(cards.get(nUsed)); //Otherwise, give out an unused card
		
		nUsed += 1; //Record how many cards used
		
		return usedCard.get(usedCard.size()-1); 		
	}
	public void shuffle() {
		// TODO Auto-generated method stub
		
		Random rnd = new Random(); 
        for(int i = 0; i < cards.size(); i++) 
        {
            	//Random the positions of every elements in the cards list
            Collections.swap(cards, i, (int) (Math.random() * cards.size() - 1)); 
        }
		usedCard.clear(); //Reset the usedCard list
		nUsed = 0 ; //Reset the used times of cards
	}
}
