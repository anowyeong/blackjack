import java.util.Collections;
import java.util.Scanner;

public class GameLauncher {

	public static void main(String[] args) {
		
		int dealerHandSum = 0;
		int playerHandSum = 0;
		
		boolean wantsToPlay = true;
		
		// init deck
		Deck deck = new Deck(1, true);
		
		// init scanner
		Scanner scanner = new Scanner(System.in);
		
		// init player and dealer
		System.out.print("Enter player's name: ");
	
		String playerName = scanner.next();
		Player player1 = new Player(playerName);
		
		Player dealer = new Player("Dealer");
		
		System.out.println("Removing top card to prevent card counting");
		
		// remove top card
		deck.dealNextCard();
		
		
		while(wantsToPlay) {
			
			// deal cards
			player1.dealPlayer(deck.dealNextCard());
			dealer.dealPlayer(deck.dealNextCard());
			player1.dealPlayer(deck.dealNextCard());
			dealer.dealPlayer(deck.dealNextCard());
			
			player1.printHand(true);
			playerHandSum = player1.getHandSum();
			
			System.out.printf("%s\n-------------------------\n",playerHandSum);
			
			// Do not show dealer's first card
			dealer.printHand(false);
			
			boolean playerTurn = true;
			boolean dealerTurn = true;
			
			// player's turn
			while(playerTurn) {
				
				System.out.printf("Hit(h) or stay(s), %s \n", player1.getName());
				String option = scanner.next();
				
				if (option.compareToIgnoreCase("h") == 0) {
					
					player1.dealPlayer(deck.dealNextCard());
					player1.printHand(true);
					playerHandSum = player1.getHandSum();
					System.out.printf("%s\n-------------------------\n", playerHandSum);
					
					if (playerHandSum > 21) {
						System.out.println("You bust! \n");
						playerTurn = false;
						
						// If the player bust, the dealer does not need to keep playing
						dealerTurn = false;
					}
				
				} else if (option.compareToIgnoreCase("s") == 0) {
					playerTurn = false;
				} else {
					System.out.println("Invalid move! Try again");
				}
				
			}
			
			// Dealer's turn
			while(dealerTurn) {
				
				dealer.printHand(true);
				System.out.printf("%d\n\n", dealer.getHandSum());
				
				if(dealerTurn) {
					// if dealer's hand < 17, hit
					if (dealer.getHandSum() < 17) {
						System.out.println("Dealer hits.");
						dealer.dealPlayer(deck.dealNextCard());
						dealer.printHand(true);
						dealerHandSum = dealer.getHandSum();
						System.out.printf("%s\n-------------------------\n", dealerHandSum);
					} else {
						System.out.println("Dealer stays.");
						dealer.printHand(true);
						dealerHandSum = dealer.getHandSum();
						System.out.printf("%s\n-------------------------\n", dealerHandSum);
						dealerTurn = false;
	
					}
				}		
			}
			
			if (playerHandSum > dealerHandSum && playerHandSum <= 21 || dealerHandSum > 21) {
				System.out.println("You win!!!");
			} else {
				System.out.println("Dealer wins.");
			}
			
			// loop to catch invalid player option.
			wantsToPlay = true;
			while (wantsToPlay) {
				
				System.out.print("\nDo you wish to continue?\n Yes(y) or No(n):");
				
				String option = scanner.next();
				
				if (option.compareToIgnoreCase("y") == 0) {
					
					dealer.resetHand();
					player1.resetHand();
					
					if (deck.deckSize() <= 20) {
						System.out.println("Not enough cards. reshuffling the deck.");
						deck.reset();
						
						System.out.println("Removing the top card to prevent card counting.");
						deck.dealNextCard();
					}
					// exit loop
					break;
					
				} else if (option.compareToIgnoreCase("n") == 0) {
					wantsToPlay = false;
				} else {
					System.out.println("invalid option.");
				}
			}	
		}	
		// close scanner
		scanner.close();
		System.out.printf("Thanks for playing %s!", player1.getName());
		System.exit(0);
	}
}
