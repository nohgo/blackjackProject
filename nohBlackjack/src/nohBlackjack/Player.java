package nohBlackjack;

public class Player extends Individual {
	private int chipCount;
	private static final int DEFAULT_CHIP = 2500;
	
	public Player() {
		chipCount = DEFAULT_CHIP;
	}
	
	public void loseChips(int lost) {
		chipCount = Math.subtractExact(this.getChipCount(), lost);
	}
	public void gainChips(int gain) {
		chipCount = Math.addExact(this.getChipCount(), gain);
	}
	public int getChipCount() {
		return chipCount;
	}
	public String evaluateWinner(Individual dealer, int bet) {
		
		if (this.isBust()) {this.loseChips(bet); return("You bust. Dealer win."); }
		else if (dealer.isBust()) {this.gainChips(bet); return("Dealer bust. You win."); }
		else if (dealer.getTotal() > this.getTotal()) {this.loseChips(bet); return("Dealer wins."); }
		else if (dealer.getTotal() < this.getTotal()) {this.gainChips(bet); return("You win.");}
		else if (dealer.getTotal() == this.getTotal()) return("Tie.");
		
		return "WRONG";
	}
}
