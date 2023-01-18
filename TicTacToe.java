import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Robot;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

class TicTacToe
{

	// Global score variables
	public static int Player1score = 0;
	public static int Player2score = 0;

	public static int round = 1;

	public static String[][] ground;
	public static ArrayList<Integer> chosenIndex = new ArrayList<>(9);
	
	public static void resetGame() {
		ground = new String[][]{
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "9"}
		};
		chosenIndex.clear();
		round = 1;
	}

	public static void display() {
		System.out.println("\n********************************************************************************");
		System.out.println("\t\t\t\t\t\t   TicTacToe Game \n ");

		System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
		System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);

		System.out.println("\t\t\t\t\t\t\t | \t\t |");
		System.out.println("\t\t\t\t\t\t"+ ground[0][0]+"\t | \t"+ ground[0][1]+"\t | \t"+ ground[0][2]);
		System.out.println("\t\t\t\t\t\t\t | \t\t |");
		System.out.println("\t\t\t\t\t ------------------------");
		System.out.println("\t\t\t\t\t\t\t | \t\t |");
		System.out.println("\t\t\t\t\t\t"+ ground[1][0]+"\t | \t"+ ground[1][1]+"\t | \t"+ ground[1][2]);
		System.out.println("\t\t\t\t\t\t\t | \t\t |");
		System.out.println("\t\t\t\t\t ------------------------");
		System.out.println("\t\t\t\t\t\t\t | \t\t |");
		System.out.println("\t\t\t\t\t\t"+ ground[2][0]+"\t | \t"+ ground[2][1]+"\t | \t"+ ground[2][2]);
		System.out.println("\t\t\t\t\t\t\t | \t\t |");
	}

	public static void game() {
		Scanner scanner = new Scanner(System.in);
		resetGame();

		while (true) {
			display();	//print Ground

			String player;
			String sign;

			if (round % 2 == 1) {	// Player1
				player = "Player1: ";
				sign = "X";
			}else {					// Player2
				player = "Player2: ";
				sign = "O";
			}

			System.out.print(player);
			int choice = scanner.nextInt();

			if (chosenIndex.contains(choice)) {
				System.out.println("This index is chosen before!");
				continue;
			}
			if (choice < 0 || choice > 9) {
				System.out.println("This index is invalid!");
				continue;
			}
			switch (choice) {
				case 1 -> ground[0][0] = sign;
				case 2 -> ground[0][1] = sign;
				case 3 -> ground[0][2] = sign;
				case 4 -> ground[1][0] = sign;
				case 5 -> ground[1][1] = sign;
				case 6 -> ground[1][2] = sign;
				case 7 -> ground[2][0] = sign;
				case 8 -> ground[2][1] = sign;
				case 9 -> ground[2][2] = sign;
			}
			chosenIndex.add(choice);


			if (check()) break;

			round ++;
			if (round >= 10) {
				System.out.println("Game is Draw!");
				break;
			}
		}
	}

	private static boolean check() {
		if(ground[0][0].equals("X") && ground[0][1].equals("X") && ground[0][2].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][0].equals("O") && ground[0][1].equals("O") && ground[0][2].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[1][0].equals("X") && ground[1][1].equals("X") && ground[1][2].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[1][0].equals("O") && ground[1][1].equals("O") && ground[1][2].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[2][0].equals("X") && ground[2][1].equals("X") && ground[2][2].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[2][0].equals("O") && ground[2][1].equals("O") && ground[2][2].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][0].equals("X") && ground[1][0].equals("X") && ground[2][0].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][0].equals("O") && ground[1][0].equals("O") && ground[2][0].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][1].equals("X") && ground[1][1].equals("X") && ground[2][1].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][1].equals("O") && ground[1][1].equals("O") && ground[2][1].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][2].equals("X") && ground[1][2].equals("X") && ground[2][2].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][2].equals("O") && ground[1][2].equals("O") && ground[2][2].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][0].equals("X") && ground[1][1].equals("X") && ground[2][2].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][0].equals("O") && ground[1][1].equals("O") && ground[2][2].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][2].equals("X") && ground[1][1].equals("X") && ground[2][0].equals("X")) {
			Player1score += 1;
			System.out.println("Player one is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;

		} else if(ground[0][2].equals("O") && ground[1][1].equals("O") && ground[2][0].equals("O")) {
			Player2score += 1;
			System.out.println("Player Two is won");
			System.out.println("\t Player 1 = X \t\t\t\t\t\t\t\t\t\t Player 1 Score = "+Player1score);
			System.out.println("\t Player 2 = O \t\t\t\t\t\t\t\t\t\t Player 2 Score = "+Player2score);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException, IllegalMonitorStateException {
	Scanner scanner = new Scanner(System.in);

	while (true) {
		game();

		System.out.println("Do You Want To Continue Then Press Y If No Then Press Any Key");
		String yes = scanner.next();
		if (yes.equals("Y") || yes.equals("y")) {
			game();
		} else {
			System.out.println("Have nice Time ;)");
			break;
		}
	}
   }
}
