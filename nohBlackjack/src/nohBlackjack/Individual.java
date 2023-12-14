package nohBlackjack;

import java.util.*;

public abstract class Individual {
	private int total;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public String hit() {
		hand.add(new Card());
		total += (hand.get(hand.size() - 1)).getValue();
		return (hand.get(hand.size() - 1)).toString();
	}
	public int getTotal() {
		return total;
	}
	public void clear() {
		hand.clear();
		total = 0;
	}
	public String listHand() {
		ArrayList<String> handString = new ArrayList<String>();
		hand.forEach(n -> handString.add(n.toString()));
		return (String.join(", ", handString));
	}
	public boolean isBust() {
		return total > 21;
	}
	
}
