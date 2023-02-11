package war;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Map<Integer,Integer> scoreBoard = new HashMap<Integer,Integer>();
		Deck deck = new Deck();
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		namePlayers(player1);
		namePlayers(player2);
		
		deck.shuffle();
		dealCards(player1, player2, deck);				
		playGame(player1, player2,scoreBoard);
		printScoreboard(player1, player2, scoreBoard);
	}

	public static void namePlayers(Player player) {		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter first name of player: ");
			String name = scanner.next();
			name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
			player.setName(name);	
			//scanner.close(); This causes errors
	}
	
	public static void dealCards(Player p1, Player p2, Deck deck) {
		for (int i = 1; i < 53; i++) {
			if (i % 2 == 0) {
				p1.draw(deck);
			}else {
				p2.draw(deck);
			}
		}
	}
	
	public static void playGame(Player p1, Player p2, Map<Integer,Integer> scoreBoard) {
		for (int i = 0; i < 26; i++ ) {
			Card p1Card = p1.flip();
			System.out.println(p1.getName() + " played:" );
			p1Card.describe();
			Card p2Card = p2.flip();
			System.out.println(p2.getName() + " played:" );
			p2Card.describe();
			scoreBoard.put(p1Card.getValue(), p2Card.getValue());
			if (p1Card.getValue() > p2Card.getValue()) {
				p1.incrementScore();				
				System.out.println(p1.getName() + " won the round.");
			}else {
				p2.incrementScore();				
				System.out.println(p2.getName() + " won the round.");
			}
			System.out.println("New Score: " + p1.getName() + ": " + p1.getScore() 
			+ " vs " + p2.getName() + ": " + p2.getScore());
		}
	}
	
	public static void printScoreboard(Player p1, Player p2, Map<Integer,Integer> scoreBoard) {
		System.out.println("Final Score: " + p1.getName() + " vs " + p2.getName());
		Set<Integer> keys = scoreBoard.keySet();
		int i = 1;
		for(int key : keys) {			
				System.out.println("Round " + i + " : " + key + " to " + scoreBoard.get(key));
				i ++;
		}
		if (p1.getScore() > p2.getScore() ) {
			System.out.println(p1.getName() + " is the winner!");
		}else if (p1.getScore() < p2.getScore()){
			System.out.println(p2.getName() + " is the winner!");
		}else {
			System.out.println("The game is a draw");
		}
	}
}

