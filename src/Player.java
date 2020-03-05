import java.util.ArrayList;


public class Player {

	//private int cash = 0;
	
	private String name = "";
	
	//Player's hand
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String name) {
		// Set player's name
		this.name = name;
		
		// clear player's hand
		if(!hand.isEmpty()) {
			resetHand();
		}
	}
	
	
	/**
	 * deals a card to the player
	 * @param newCard	card being dealt to player
	 */
	public void dealPlayer(Card newCard) {
		this.hand.add(newCard);
	}
	
	/**
	 * shows the current hand of the player
	 * @param showCard	boolean value whether to show first card
	 */
	public void printHand(boolean showCard) {
		
		int cardCnt = this.hand.size();
		System.out.printf("%s's cards: \n", this.name);
		
		for(int i = 0; i < cardCnt; i++) {
			if(showCard == false && i == 0) {
				System.out.println("[Hidden]");
			} else {
				System.out.printf("%s\n", this.hand.get(i).toString());
			}
		}
	}
	
	/**
	 * getting for player's name
	 * @return	name
	 */
	public String getName() {
		return this.name;
	}
	
	public void resetHand() {
		this.hand.clear();
	}
	
	public int getHandSum() {
		
		int handSum = 0;
		int aceCnt = 0;
		int handSize = this.hand.size();
		int cardVal;
		
		for(int i = 0; i < handSize; i++) {
			
			cardVal = hand.get(i).getVal();
			
			if (cardVal == 1) {
				aceCnt++;
				handSum += 11;
			} else if (cardVal > 10) {
				handSum += 10;
			} else {
				handSum += cardVal;
			}
		}
		
		// if hand is greater than 21 and has an ace, convert the ace to 1 instead
		while (handSum > 21 && aceCnt > 0) {
			aceCnt--;
			handSum -= 10;
		}
		return handSum;
	}
	
	
	
}
