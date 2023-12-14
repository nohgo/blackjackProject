package nohBlackjack;

public class Dealer extends Individual{
	private final int DEFAULT_HIT = 17;
	public void stand() {
		while(this.getTotal() < DEFAULT_HIT) {
			System.out.println("Dealer drew a " + this.hit() + ".");
		}
	}
}
