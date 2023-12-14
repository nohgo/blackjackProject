package nohBlackjack;
import java.util.*;
public class Card {
	Scanner input2 = new Scanner(System.in);
	private int cardFace;
	private int cardSuit;
	private int value;
	static private String[][] faces = {{"2","2"}, {"3","3"}, {"4","4"}, {"5","5"}, {"6","6"}, {"7","7"}, {"8","8"}, {"9","9"},
			{"10","10"}, {"Jack","10"}, {"Queen","10"}, {"King","10"}, {"Ace", "11"}};
	static private String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	
	public Card() { // only constructor
		cardFace = (int)(Math.random() * faces.length);
		cardSuit = (int)(Math.random() * suits.length);
		value = Integer.valueOf(faces[cardFace][1]);

	}
	public int getValue() {
		return value;
	}
	public String getFace() {
		return faces[cardFace][0];
	}
	public String getSuit() {
		return suits[cardSuit];
	}
	@Override
	public String toString() {
		return this.getFace() + " of " + this.getSuit();
	}
	@Override
	public boolean equals(Object x) {
		if (x == null) return false;
	    if (x == this) return true;
	    if (!(x instanceof Card)) return false;
		Card card = (Card) x;
		return (this.getFace() == card.getFace() && this.getSuit() == card.getSuit());
	}
	
	
	
}
