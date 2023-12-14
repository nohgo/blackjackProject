package nohBlackjack;

import java.util.*;
public class BlackjackMain {

 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		System.out.println("Welcome to BlackJack.\nDealers hit until 17.\nAces are worth 11. ");
		System.out.println();

		while(true) {
			int bet;
			
			//bet loop
			while (true) {
				System.out.print("You currently have " + player.getChipCount() + " chips. \nHow much would you like to bet? ");
				bet = input.nextInt();
				if(bet <= player.getChipCount()) break;
			}
			input.nextLine();
			System.out.println();
			//resetting both people
			player.clear();
			player.hit();
			player.hit();
			dealer.clear();
			dealer.hit();
			
			System.out.println("You have a " + player.listHand());
			System.out.println("Dealer has a " + dealer.listHand());
			System.out.println();
			
			//main loop
			while(true) {
				System.out.print("Hit or stand? ");
				String currentInput = input.nextLine().toLowerCase();
				if (currentInput.equals("hit")) {
					System.out.println("You got a " + player.hit());
					if (player.isBust()) {
						break;
					}
				}
				else if (currentInput.equals("stand")) {
					dealer.stand();
					break;
				}
				else {
					System.out.println("Input not recognized.");
				}			
			}
			
			System.out.println();
			System.out.println("Player total: " + player.getTotal() + ". Dealer total: " + dealer.getTotal() + ".");
			
			//win checking
			System.out.println(player.evaluateWinner(dealer, bet));
			System.out.println();
			System.out.println("New chip count: " + player.getChipCount());
			
			
			//broke check
			if(player.getChipCount() == 0) {
				System.out.println("You are out of chips.");
				break;
			}
			//replay?
			System.out.print("Do you want to play again? (y or n) ");
			String replay = input.nextLine().toLowerCase();
			if (replay.equals("n")) {System.out.println("\nQuitting... "); break;}
			else System.out.println("\n" + ("- ").repeat(50) + "\n");
			
		}
		input.close();
		System.exit(0);
	}
}
