import java.util.Scanner;
import java.util.Arrays;
public class TalhaPoker {
	static Scanner input = new Scanner (System.in);

	static int coins = 100;
	static int bet = 0;
	static int[] usercards = new int[5];
	static int[] usersuit = new int[5];
	static int[] compcards = new int[5];
	static int[] compsuit = new int[5];
	static boolean again = true;
	static boolean con = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		greetings();
		do {
			cardValue();
			String[] card = cardNum();
			cardSuit(card);
			int userpopular = userPopularElement();
			int comppopular = compPopularElement();
			int usrPoints = userPoints();
			int cmpPoints = compPoints();
			bestHand(usrPoints, cmpPoints, userpopular, comppopular);
		}while(again == true);

	}
	public static void greetings() { //this is just your average greeting for the code also getting their bet
		System.out.println("Hello there and welcome to The Poker Table");
		System.out.println("We would like to give you a warm welcome and remember, go big or go home");
		System.out.println("Today's game is 5 Card Poker");
		System.out.println("Press 'c' to continue and 'e' to exit");
		String b = input.next();
		do {
			if (!b.equals("c") && !b.equals("e")) {
				System.out.println("Error please try pressing 'c' to continue or 'e' to exit"); // error checking making sure they have to enter either 'p' or 'q'
				b = input.next();
			}
		}
		while(!b.equals("c") && !b.equals("e"));
		if (b.equals("c")) {
			System.out.println("Good decision on continuing");
			System.out.println("You can bet a maximum of 25 coins and a minimum of 1. Keep in mind you only have 100 coins!");
			System.out.println("How much would you like to bet. Please enter a value below."); 
			//getting their bet and error checking
			bet = input.nextInt();
			do {
				if (bet <= 25 && bet > 0) {
					coins = coins - bet;
					con = true;
				}
				else {
					System.out.println("You can bet a maximum of 25 coins and a minimum of 1.");
					bet = input.nextInt();
					con = false;
				}
			}
			while(con == false);

		}
		else if (b.equals("e")) {
			System.out.println("Good bye hope to see you soon!");
			System.exit(0);
		}
	}
	public static void cardValue() { //assigning cards random numbers and suits for the user and comp
		for (int i = 0 ; i < usercards.length ; i++) {
			usercards[i] = (int) (Math.random() * 13 + 2);
		}
		for (int x = 0 ; x < usersuit.length ; x++) {
			usersuit[x] = (int) (Math.random() * 4 + 1);
		}
		//sorting the arrays for the least to greatest
		Arrays.sort(usercards);
		Arrays.sort(usersuit);

		for (int x = 0 ; x < compsuit.length ; x++) {
			compsuit[x] = (int) (Math.random() * 4 + 1);
		}
		for (int i = 0 ; i < compcards.length ; i++) {
			compcards[i] = (int) (Math.random() * 13 + 2);
		}
		//sorting the arrays from the least to greatest
		Arrays.sort(compcards);
		Arrays.sort(compsuit);

	}
	public static String[] cardNum() {
		String[] card = new String [5];
		//assigning the number 11 12 13 and 14 strings so it looks nicer for the user to read
		for(int g = 0; g < 5; g++) {
			if (usercards[g] == 11) {
				card[g] = "Jack";
			}
			else if (usercards[g] == 12) {
				card[g] = "Queen";
			}
			else if (usercards[g] == 13) {
				card[g] = "King";
			}
			else if (usercards[g] == 14) {
				card[g] = "Ace";
			}
			else {
				card[g] = usercards[g]+"";
			}
		}
		return card;
	} 
	public static void cardSuit(String[] card){
		String [] suit =  new String[5];
		//assigning the suits that were ints a string value for the reader to see 
		for (int g = 0; g < 5 ; g++) {
			if (usersuit[g] == 1) {
				suit[g] = "Hearts";
			}
			else if (usersuit[g] == 2) {
				suit[g] = "Diamonds";
			}
			else if (usersuit[g] == 3) {
				suit[g] = "Clubs";
			}
			else if (usersuit[g] == 4) {
				suit[g] = "Spades";
			}
		}
		// suits - 1 = hearts, 2 = diamonds, 3 = clubs, 4 = spades
		//printing out the user cards
		System.out.println("Your cards are:");
		System.out.println("0. " + card[0] + " of " + suit[0]);
		System.out.println("1. " + card[1] + " of " + suit[1]);
		System.out.println("2. " + card[2] + " of " + suit[2]);
		System.out.println("3. " + card[3] + " of " + suit[3]);
		System.out.println("4. " + card[4] + " of " + suit[4]);
		int a = 10;
		int b = 10; 
		int c = 10;
		int d = 10;
		int e = 10;
		boolean repeat = true;
		//this checks if they want to switch their hand
		System.out.println("Would you like to change any card in your hand?");
		System.out.println("Please select the number of the card you want to change or 5 if want to keep your hand.");
		a = input.nextInt();
		do {
			if (a <= 5 && a >= 0) {
				con = true;
			}
			else {
				System.out.println("Please choose a card from 0-4 or 5 to keep your hand.");
				a = input.nextInt();
				con = false;
			}
		}
		while(con == false);
		if (a <5 && a>=0) {
			for(int j =0; j < 6; j++) {
				if (a == j) {
					usercards[j] = (int) (Math.random() * 13 + 2);		
					usersuit[j] = (int) (Math.random() * 4 + 1);
				}
			}
			for(int g = 0; g < 5; g++) {
				if (usercards[g] == 11) {
					card[g] = "Jack";
				}
				else if (usercards[g] == 12) {
					card[g] = "Queen";
				}
				else if (usercards[g] == 13) {
					card[g] = "King";
				}
				else if (usercards[g] == 14) {
					card[g] = "Ace";
				}
				else {
					card[g] = usercards[g]+"";
				}
			}
			for (int g = 0; g < 5 ; g++) {
				if (usersuit[g] == 1) {
					suit[g] = "Hearts";
				}
				else if (usersuit[g] == 2) {
					suit[g] = "Diamonds";
				}
				else if (usersuit[g] == 3) {
					suit[g] = "Clubs";
				}
				else if (usersuit[g] == 4) {
					suit[g] = "Spades";
				}
			}
		}
		if (a == 5) {
			System.out.println("Keeping your hand, must be good!");
			repeat = false;
		}
		if (repeat == true) {
			System.out.println("Please select the number of the card you want to change or 0 if want to keep your hand.");
			b = input.nextInt();
			do {
				if (b <= 5 && b >= 0) {
					con = true;
				}
				else {
					System.out.println("Please choose a card from 0-4 or 5 to keep your hand.");
					a = input.nextInt();
					con = false;
				}
			}while(con == false);

			if (b <5 && b>=0) {
				for(int j =0; j < 6; j++) {
					if (b == j) {
						usercards[j] = (int) (Math.random() * 13 + 2);		
						usersuit[j] = (int) (Math.random() * 4 + 1);
					}
				}
				for(int g = 0; g < 5; g++) {
					if (usercards[g] == 11) {
						card[g] = "Jack";
					}
					else if (usercards[g] == 12) {
						card[g] = "Queen";
					}
					else if (usercards[g] == 13) {
						card[g] = "King";
					}
					else if (usercards[g] == 14) {
						card[g] = "Ace";
					}
					else {
						card[g] = usercards[g]+"";
					}
				}
				for (int g = 0; g < 5 ; g++) {
					if (usersuit[g] == 1) {
						suit[g] = "Hearts";
					}
					else if (usersuit[g] == 2) {
						suit[g] = "Diamonds";
					}
					else if (usersuit[g] == 3) {
						suit[g] = "Clubs";
					}
					else if (usersuit[g] == 4) {
						suit[g] = "Spades";
					}
				}
			}
			if (b == 5) {
				System.out.println("Switching one card, not bad. Your new cards are:");
				System.out.println("0. " + card[0] + " of " + suit[0]);
				System.out.println("1. " + card[1] + " of " + suit[1]);
				System.out.println("2. " + card[2] + " of " + suit[2]);
				System.out.println("3. " + card[3] + " of " + suit[3]);
				System.out.println("4. " + card[4] + " of " + suit[4]);
				repeat = false;
			}
			if (repeat == true) {
				System.out.println("Please select the number of the card you want to change or 5 if want to keep your hand.");
				c = input.nextInt();
				do {
					if (c <= 5 && c >= 0) {
						con = true;
					}
					else {
						System.out.println("Please choose a card from 0-4 or 5 to keep your hand.");
						c = input.nextInt();
						con = false;
					}
				}while(con == false);
				if (c <5 && c>=0) {
					for(int j =0; j < 6; j++) {
						if (c == j) {
							usercards[j] = (int) (Math.random() * 13 + 2);		
							usersuit[j] = (int) (Math.random() * 4 + 1);
						}
					}
					for(int g = 0; g < 5; g++) {
						if (usercards[g] == 11) {
							card[g] = "Jack";
						}
						else if (usercards[g] == 12) {
							card[g] = "Queen";
						}
						else if (usercards[g] == 13) {
							card[g] = "King";
						}
						else if (usercards[g] == 14) {
							card[g] = "Ace";
						}
						else {
							card[g] = usercards[g]+"";
						}
					}
					for (int g = 0; g < 5 ; g++) {
						if (usersuit[g] == 1) {
							suit[g] = "Hearts";
						}
						else if (usersuit[g] == 2) {
							suit[g] = "Diamonds";
						}
						else if (usersuit[g] == 3) {
							suit[g] = "Clubs";
						}
						else if (usersuit[g] == 4) {
							suit[g] = "Spades";
						}
					}
				}
				if (c == 5) {
					System.out.println("Switching two cards, not bad. Your new cards are:");
					System.out.println("0. " + card[0] + " of " + suit[0]);
					System.out.println("1. " + card[1] + " of " + suit[1]);
					System.out.println("2. " + card[2] + " of " + suit[2]);
					System.out.println("3. " + card[3] + " of " + suit[3]);
					System.out.println("4. " + card[4] + " of " + suit[4]);
					repeat = false;
				}
				if (repeat == true) {
					System.out.println("Please select the number of the card you want to change or 5 if want to keep your hand.");
					d = input.nextInt();
					do {
						if (d <= 5 && d >= 0) {
							con = true;
						}
						else {
							System.out.println("Please choose a card from 0-4 or 5 to keep your hand.");
							d = input.nextInt();
							con = false;
						}
					}while(con == false);
					if (d <5 && d>=0) {
						for(int j =0; j < 6; j++) {
							if (d == j) {
								usercards[j] = (int) (Math.random() * 13 + 2);		
								usersuit[j] = (int) (Math.random() * 4 + 1);
							}
						}
						for(int g = 0; g < 5; g++) {
							if (usercards[g] == 11) {
								card[g] = "Jack";
							}
							else if (usercards[g] == 12) {
								card[g] = "Queen";
							}
							else if (usercards[g] == 13) {
								card[g] = "King";
							}
							else if (usercards[g] == 14) {
								card[g] = "Ace";
							}
							else {
								card[g] = usercards[g]+"";
							}
						}
						for (int g = 0; g < 5 ; g++) {
							if (usersuit[g] == 1) {
								suit[g] = "Hearts";
							}
							else if (usersuit[g] == 2) {
								suit[g] = "Diamonds";
							}
							else if (usersuit[g] == 3) {
								suit[g] = "Clubs";
							}
							else if (usersuit[g] == 4) {
								suit[g] = "Spades";
							}
						}
					}
					if (d == 5) {
						System.out.println("Switching three cards, not bad. Your new cards are:");
						System.out.println("0. " + card[0] + " of " + suit[0]);
						System.out.println("1. " + card[1] + " of " + suit[1]);
						System.out.println("2. " + card[2] + " of " + suit[2]);
						System.out.println("3. " + card[3] + " of " + suit[3]);
						System.out.println("4. " + card[4] + " of " + suit[4]);
						repeat = false;
					}
					if (repeat == true) {
						System.out.println("Please select the number of the card you want to change or 5 if want to keep your hand.");
						e = input.nextInt();
						do {
							if (e <= 5 && e >= 0) {
								con = true;
							}
							else {
								System.out.println("Please choose a card from 0-4 or 5 to keep your hand.");
								e = input.nextInt();
								con = false;
							}
						}while(con == false);
						if (e<5 && e>=0) {
							for(int j =0; j < 6; j++) {
								if (e == j) {
									usercards[j] = (int) (Math.random() * 13 + 2);		
									usersuit[j] = (int) (Math.random() * 4 + 1);
								}
							}
							for(int g = 0; g < 5; g++) {
								if (usercards[g] == 11) {
									card[g] = "Jack";
								}
								else if (usercards[g] == 12) {
									card[g] = "Queen";
								}
								else if (usercards[g] == 13) {
									card[g] = "King";
								}
								else if (usercards[g] == 14) {
									card[g] = "Ace";
								}
								else {
									card[g] = usercards[g]+"";
								}
							}
							for (int g = 0; g < 5 ; g++) {
								if (usersuit[g] == 1) {
									suit[g] = "Hearts";
								}
								else if (usersuit[g] == 2) {
									suit[g] = "Diamonds";
								}
								else if (usersuit[g] == 3) {
									suit[g] = "Clubs";
								}
								else if (usersuit[g] == 4) {
									suit[g] = "Spades";
								}
							}
						}
						if (e!=5) {
							System.out.println("Switching five cards... that bad? Your new cards are:");
							System.out.println("0. " + card[0] + " of " + suit[0]);
							System.out.println("1. " + card[1] + " of " + suit[1]);
							System.out.println("2. " + card[2] + " of " + suit[2]);
							System.out.println("3. " + card[3] + " of " + suit[3]);
							System.out.println("4. " + card[4] + " of " + suit[4]);
						}
						if (e == 5) {
							System.out.println("Switching four cards, not bad. Your new cards are:");
							System.out.println("0. " + card[0] + " of " + suit[0]);
							System.out.println("1. " + card[1] + " of " + suit[1]);
							System.out.println("2. " + card[2] + " of " + suit[2]);
							System.out.println("3. " + card[3] + " of " + suit[3]);
							System.out.println("4. " + card[4] + " of " + suit[4]);
							repeat = false;
						}
					}
				}
			}
		}
	}
	public static int userPoints() { //this is getting the points of the user that willed later used to calculate winner loser and ties 
		System.out.println("");
		System.out.println("You got:");
		int counter1 = 0;
		boolean high = false;
		int points = 0;

		for(int x = 0 ; x <= 9; x++)
			if ((usercards[0] == 2 + x) && (usercards[1] == 3 + x) && (usercards[2] == 4 + x) && (usercards[3] == 5 + x) && (usercards[4] == 6 + x)) {
				if ((usersuit[0] == usersuit[1]) && (usersuit[0] == usersuit[2]) && (usersuit[0] == usersuit[3])) {
					if((usercards[0] == 10)) {
						System.out.println("Royal Flush");
						high = true;
						points = 10;
					}
					else if((usercards[0] != 10)) {
						System.out.println("Straight Flush");
						high = true;
						points = 9;
					}
				}
				else {
					System.out.println("Straight");
					high = true;
					points = 5;
				}
			}
		if(high == false) {
			if ((usersuit[0] == usersuit[1]) && (usersuit[0] == usersuit[2]) && (usersuit[0] == usersuit[3]) && (usersuit[0] == usersuit[4])) {
				System.out.println("Flush");
				high = true;
				points = 6;
			}
		}

		if(high == false) {
			for (int x = 0; x < usercards.length; x++) {
				for (int f = 0; f <usercards.length; f++) {
					if(usercards[x] == usercards[f]){
						counter1++;
					}
				}
			}
		}
		if(counter1 == 5) {
			System.out.println("High Single");
			points++;
		}
		else if (counter1 == 7 ) {
			System.out.println("Single Pair");
			points = 2;
		}
		else if (counter1 == 9) {
			System.out.println("Double pairs");
			points = 3;
		}
		else if (counter1 == 11) {
			System.out.println("Three of a Kind");
			points = 4;
		}
		else if (counter1 == 13) {
			System.out.println("Full House");
			points = 7;
		}
		else if (counter1 == 17) {
			System.out.println("Four of a Kind");
			points = 8;
		}
		return points;
	}
	public static int compPoints() { //this is getting the points of the comp that willed later used to calculate winner loser and ties 
		System.out.println("");
		System.out.println("Comp got:");
		boolean high = false;
		int points = 0;
		int counter2 = 0;

		for(int x = 0 ; x <= 9; x++)
			if ((compcards[0] == 2 + x) && (compcards[1] == 3 + x) && (compcards[2] == 4 + x) && (compcards[3] == 5 + x) && (compcards[4] == 6 + x)) {
				if ((compsuit[0] == compsuit[1]) && (compsuit[0] == compsuit[2]) && (compsuit[0] == compsuit[3])) {
					if((compcards[0] == 10)) {
						System.out.println("Royal Flush");
						high = true;
						points = 10;
					}
					else if((compcards[0] != 10)) {
						System.out.println("Straight Flush");
						high = true;
						points = 9;
					}
				}
				else {
					System.out.println("Straight");
					high = true;
					points = 5;
				}
			}
		if(high == false) {
			if ((compsuit[0] == compsuit[1]) && (compsuit[0] == compsuit[2]) && (compsuit[0] == compsuit[3]) && (compsuit[0] == compsuit[4])) {
				System.out.println("Flush");
				high = true;
				points = 6;
			}
		}

		if(high == false) {
			for (int x = 0; x < compcards.length; x++) {
				for (int f = 0; f <compcards.length; f++) {
					if(compcards[x] == compcards[f]){
						counter2++;
					}
				}
			}
		}
		if(counter2 == 5) {
			System.out.println("High Single");
			points++;
		}
		else if (counter2 == 7 ) {
			System.out.println("Single Pair");
			points = 2;
		}
		else if (counter2 == 9) {
			System.out.println("Double pairs");
			points = 3;
		}
		else if (counter2 == 11) {
			System.out.println("Three of a Kind");
			points = 4;
		}
		else if (counter2 == 13) {
			System.out.println("Full House");
			points = 7;
		}
		else if (counter2 == 17) {
			System.out.println("Four of a Kind");
			points = 8;
		}
		return points;
	}
	public static void bestHand(int userPoints, int compPoints, int userpopular, int comppopular) { //this calculates the winner and the ties and tie breakers
		System.out.println("");
		System.out.println("Results:");
		// all of the following calculates different all the different possible ties and winners for all combinations of hands
		if(userPoints > compPoints) {
			System.out.println("You Won");
			coins = coins + (bet*2);
		}
		else if(userPoints < compPoints) {
			System.out.println("Comp Won");
		}
		else if(userPoints == compPoints) {
			if(userPoints == 1 && usercards[4] > compcards[4]) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 1 && usercards[4] < compcards[4]) {
				System.out.println("Tie breaker.. Comp won");
			}
			else if (userPoints == 1 && usercards[4] == compcards[4] ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 2 && userpopular > comppopular ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 2 && userpopular < comppopular ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 2 && userpopular == comppopular ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 3 && userpopular > comppopular ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 3 && userpopular < comppopular ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 3 && userpopular == comppopular ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 4 && userpopular > comppopular ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 4 && userpopular < comppopular ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 4 && userpopular == comppopular ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 5 && usercards[4] > compcards[4] ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 5 && usercards[4] < compcards[4] ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 5 && usercards[4] == compcards[4] ) {
				System.out.println("Tie... No breaker!!!");
				coins = coins + bet;
			}

			if (userPoints == 6 && usercards[4] > compcards[4] ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 6 && usercards[4] < compcards[4] ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 6 && usercards[4] == compcards[4] ) {
				if (userPoints == 6 && usercards[3] > compcards[3] ) {
					System.out.println("Tie breaker... You won");
					coins = coins + (bet*2);
				}
				else if (userPoints == 6 && usercards[3] < compcards[3] ) {
					System.out.println("Tie breaker... Comp won");
				}	
				else if (userPoints == 6 && usercards[3] == compcards[3] ) {
					if (userPoints == 6 && usercards[2] > compcards[2] ) {
						System.out.println("Tie breaker... You won");
						coins = coins + (bet*2);
					}
					else if (userPoints == 6 && usercards[2] < compcards[2] ) {
						System.out.println("Tie breaker... Comp won");
					}	
					else if (userPoints == 6 && usercards[2] == compcards[2] ) {
						if (userPoints == 6 && usercards[1] > compcards[1] ) {
							System.out.println("Tie breaker... You won");
							coins = coins + (bet*2);
						}
						else if (userPoints == 6 && usercards[1] < compcards[1] ) {
							System.out.println("Tie breaker... Comp won");
						}	
						else if (userPoints == 6 && usercards[1] == compcards[1] ) {
							if (userPoints == 6 && usercards[0] > compcards[0] ) {
								System.out.println("Tie breaker... You won");
								coins = coins + (bet*2);
							}
							else if (userPoints == 6 && usercards[0] < compcards[0] ) {
								System.out.println("Tie breaker... Comp won");
							}	
							else if (userPoints == 6 && usercards[0] == compcards[0] ) {
								System.out.println("Tie... No breaker");
								coins = coins + bet;
							}
						}
					}
				}
			}
			if (userPoints == 7 && userpopular > comppopular ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 7 && userpopular < comppopular ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 7 && userpopular == comppopular ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 8 && userpopular > comppopular ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 8 && userpopular < comppopular ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 8 && userpopular == comppopular ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 9 && usercards[4] > compcards[4] ) {
				System.out.println("Tie breaker... You won");
				coins = coins + (bet*2);
			}
			else if (userPoints == 9 && usercards[4] < compcards[4] ) {
				System.out.println("Tie breaker... Comp won");
			}
			else if (userPoints == 9 && usercards[4] == compcards[4] ) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
			if (userPoints == 10) {
				System.out.println("Tie... No breaker");
				coins = coins + bet;
			}
		}
		//this assign the comp cards string values
		String[] card1 = new String[5];
		String[] suit1 = new String[5];
		for(int g = 0; g < 5; g++) {
			if (compcards[g] == 11) {
				card1[g] = "Jack";
			}
			else if (compcards[g] == 12) {
				card1[g] = "Queen";
			}
			else if (compcards[g] == 13) {
				card1[g] = "King";
			}
			else if (compcards[g] == 14) {
				card1[g] = "Ace";
			}
			else {
				card1[g] = compcards[g]+"";
			}
		}
		for (int g = 0; g < 5 ; g++) {
			if (compsuit[g] == 1) {
				suit1[g] = "Hearts";
			}
			else if (compsuit[g] == 2) {
				suit1[g] = "Diamonds";
			}
			else if (compsuit[g] == 3) {
				suit1[g] = "Clubs";
			}
			else if (compsuit[g] == 4) {
				suit1[g] = "Spades";
			}
		}
		//prints the comp cards
		System.out.println("");
		System.out.println("Comps cards were:");
		System.out.println("0. " + card1[0] + " of " + suit1[0]);
		System.out.println("1. " + card1[1] + " of " + suit1[1]);
		System.out.println("2. " + card1[2] + " of " + suit1[2]);
		System.out.println("3. " + card1[3] + " of " + suit1[3]);
		System.out.println("4. " + card1[4] + " of " + suit1[4]);
		System.out.println("");
		bet = 0;
		//this is a loop that lets you play again
		System.out.println("Your current new balance of coins is:");
		System.out.println(coins);
		int go = 0;
		System.out.println("Would you like to play again? please press 1 for yes and 2 for no.");
		go = input.nextInt();
		do {
			if (go == 1 || go ==2) {
				con = true;
			}
			else {
				System.out.println("Please choose the numbers 1 or 2");
				go = input.nextInt();
				con = false;
			}
		}while(con == false);
		if(go == 1) {
			again = true;
			System.out.println("How much would you like to bet this time? Remember you can only bet 1 to 25 coins.");
			bet = input.nextInt();
			do {
				if (bet <= 25 && bet > 0) {
					coins = coins - bet;
					con = true;
				}
				else {
					System.out.println("You can bet a maximum of 25 coins and a minimum of 1.");
					bet = input.nextInt();
					con = false;
				}
			}
			while(con == false);
		}
		else if (go == 2) {
			System.out.println("Thank you for choosing the Poker Table. Please come again.");
			again = false;
		}
		else if (coins <= 0) {
			System.out.println("Sorry, you're out of coins. Game over");
			System.exit(0);
		}
	}
	public static int userPopularElement() { //this is finding the most popular element in the array for the user

		int count = 1, tempCount;
		int popular = usercards[0];
		int temp = 0;
		for (int i = 0; i < (usercards.length - 1); i++)
		{
			temp = usercards[i];
			tempCount = 0;
			for (int j = 1; j < usercards.length; j++)
			{
				if (temp == usercards[j])
					tempCount++;
			}
			if (tempCount > count)
			{
				popular = temp;
				count = tempCount;
			}
		}
		return popular;
	}
	public static int compPopularElement() { //this is finding the most popular element in the array for the comp

		int count = 1, tempCount;
		int popular = compcards[0];
		int temp = 0;
		for (int i = 0; i < (compcards.length - 1); i++)
		{
			temp = compcards[i];
			tempCount = 0;
			for (int j = 1; j < compcards.length; j++)
			{
				if (temp == compcards[j])
					tempCount++;
			}
			if (tempCount > count)
			{
				popular = temp;
				count = tempCount;
			}
		}
		return popular;
	}
}
