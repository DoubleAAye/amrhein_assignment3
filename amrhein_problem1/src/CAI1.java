import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1{

	static int randomValue1;
	static int randomValue2;
	static int totalValue;
	static int userAnswer;

	public static void main(String args[]){
		quiz();
	}

	static public void quiz(){
		askQuestion();
		readResponse();
		isAsnwerCorrect();
	}

	private static void askQuestion(){
		SecureRandom randomValue = new SecureRandom();
		randomValue1 = randomValue.nextInt(10);
		randomValue2 = randomValue.nextInt(10);
		totalValue = randomValue1 * randomValue2;
		System.out.println("What is " + randomValue1 + " x " + randomValue2 + "?");
	}

	private static void readResponse(){
		Scanner in = new Scanner(System.in);
		userAnswer = in.nextInt();
	}

	private static void isAsnwerCorrect(){
		if (userAnswer == totalValue){
			displayCorrectResponse();
		}
		else{
			displayInorrectResponse();
			quiz();
		}
	}

	private static void displayCorrectResponse(){
		System.out.println("Very good!");
	}

	private static void displayInorrectResponse(){
		System.out.println("No. Please try again.\n");
	}
}