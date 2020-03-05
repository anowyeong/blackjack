import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	/**
	 *  List of cards in a deck, where the top card is the first index	
	 */
	private ArrayList<Card> listCards;
	
	/**
	 * The list of cards already dealt
	 */
	private ArrayList<Card> dealtCards;
	
	/**
	 *  Number of cards in the deck
	 */
	private int numCards;
	
	/**
	 * Default constructor with 52 cards without shuffling
	 */
	public Deck() {
		
		/*
		 *  Call other constructor with one deck and no shuffling
		 */
		this(1, false);
		
	}
	
	/**
	 * 
	 * @param numOfDecks	number of decks
	 * @param shuffle	boolean if decks need to be shuffled
	 */
	public Deck(int numOfDecks, boolean shuffle) {
		
		// there are 52 cards in a regular deck of cards (excluding jokers)
		this.numCards = numOfDecks * 52;
		
		// init the decks
		this.listCards = new ArrayList<Card>();
		this.dealtCards = new ArrayList<Card>();
		
		
		// for each deck
		for(int i = 0; i < numOfDecks; i++) {
			// for each suit
			for(int j = 0; j < 4; j++) {
				// for each card value
				for(int k = 1; k <= 13; k++) {
					
					Card card = new Card(Suit.values()[j], k);
					listCards.add(card);
				}
			}
		}
		
		if (shuffle) {
			shuffle(listCards);
		}
	}
	
	/**
	 * shuffles the deck
	 */
	public void shuffle(ArrayList<Card> deck) {
		Collections.shuffle(deck);
	}
	
	/**
	 * Deals the card ontop of the listCards deck 
	 * and adds the card to the dealCards deck
	 * @return the dealt card
	 */
	public Card dealNextCard() {
		Card card = listCards.remove(0);
		dealtCards.add(card);
		return card;
	}
	
	/**
	 * Retrieves the current size of the deck 
	 * @param deck	The specified deck
	 * @return	int value of the number of cards in the deck
	 */
	public int deckSize() {
		return listCards.size();
	}
	
	/**
	 * resets the decks
	 */
	public void reset() {
		listCards.addAll(dealtCards);
		dealtCards.clear();
	}
	
	/**
	 * 
	 * @param numToPrint	the number of cards from the top of the deck to print
	 */
	public void printDeck(int numToPrint) {
		for(int i = 0; i < numToPrint; i++) {
			System.out.printf("% 3d/%d %s\n", i+1, this.numCards, this.listCards.get(i).toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards - numToPrint);
	}

	public int getNumCards() {
		return numCards;
	}
}
