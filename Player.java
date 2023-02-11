//Creates a player for the game

package war;

import java.util.ArrayList;
import java.util.List;

public class Player {

	List<Card> hand = new ArrayList<Card>();
	int score = 0;
	String name;
	
	public void describe() {
		System.out.println(name + " has a score of " + score + " and deck of ");
		for (Card card : hand) {
			card.describe();
		}
	}

	public Card flip() {
		Card top = this.hand.remove(0);
		return top;
		
		}
	
	public void draw(Deck deck) {		
		Card newCard = deck.draw();
		this.hand.add(newCard);
		}
	
	public void incrementScore() {
		this.score += 1;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

