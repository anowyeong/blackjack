
public class Card {

	/**
	 * The number value of the card
	 */
	private int cardVal;
	
	/**
	 * The suits value of the card
	 */
	private Suit cardSuit;
	
	
	/**
	 * 
	 * @param suit	the suit of the card
	 * @param num	the card value where Ace = 1 and King = 13
	 */
	public Card(Suit suit, int num) {
		
		this.cardSuit = suit;
		
		if (num >= 1 && num <= 13) {
			this.cardVal = num;
		} else {
			System.err.println(num + " is not a valid");
			System.exit(1);
		}
	}
	
	/**
	 * suit getter
	 * @return suit
	 */
	public Suit getSuit() {
		return this.cardSuit;
	}
	
	/**
	 * card value getter
	 * @return
	 */
	public int getVal() {
		return this.cardVal;
	}
	
	public String toString() {
		
		String numString = "error: invalid";
		
		switch(this.cardVal) {
		
		case 1:
			numString = "ace";
			break;
		
		case 2:
			numString = "two";
			break;
		
		case 3:
			numString = "three";
			break;
	
		case 4:
			numString = "four";
			break;
		
		case 5:
			numString = "five";
			break;
		
		case 6:
			numString = "six";
			break;
		
		case 7:
			numString = "seven";
			break;
			
		case 8:
			numString = "eight";
			break;
			
		case 9:
			numString = "nine";
			break;
		
		case 10:
			numString = "ten";
			break;
			
		case 11:
			numString = "jack";
			break;
			
		case 12:
			numString = "queen";
			break;
		case 13:
			numString = "king";
			break;		
		}
		
		return numString + " of " + this.cardSuit.toString();
	}
}
