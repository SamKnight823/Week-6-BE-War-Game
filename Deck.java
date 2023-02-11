//This class creates a standard playing deck

package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
 List<Card> cards = new ArrayList<Card>();
 
 String[] numbers = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen",
		 "King","Ace"};
 String[] suits = {"Clubs","Hearts","Spades","Diamonds"};
 
 Deck() {
	 
	 for (String suit : suits) {
		 int value = 2;
		 for (String number : numbers) {
			 String name = number + " of " + suit;
			 Card card = new Card(value,name);
			 cards.add(card);
			 value ++;
		 }
	 }
 }
public void describe() {
	for (Card card : cards) {
		card.describe();
	}
}
 public void shuffle() {
	 Collections.shuffle(this.cards);
 }
 
 public Card draw() {
		Card card = this.cards.remove(0);
		return card;
		
 }

}

