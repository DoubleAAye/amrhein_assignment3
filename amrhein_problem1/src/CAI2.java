import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI2{	 
  	static int randomValue1;
  	static int randomValue2;
  	static int responseOption;
  	static int totalValue;
	static int userAnswer;

	public static void main(String args[]){
		quiz(); 
	}
	
	//Method to run the quiz
	static public void quiz(){
		askQuestion();
		readResponse();
		isAsnwerCorrect();
	}

	//Prints out the question.
	private static void askQuestion(){
		SecureRandom randomValue = new SecureRandom();
		Random responseOptionNumber = new Random();
		randomValue1 = randomValue.nextInt(10);
		randomValue2 = randomValue.nextInt(10);
		totalValue = randomValue1 * randomValue2;
		responseOption = responseOptionNumber.nextInt(3);
		responseOption += 1;
		System.out.println("What is " + randomValue1 + " x " + randomValue2 + "?");
	}
	
	//Reads the users answer to be checked
	private static void readResponse(){
		Scanner in = new Scanner(System.in);
			userAnswer = in.nextInt();
	}

	//Method to check for correct answer.
	private static void isAsnwerCorrect(){
		if (userAnswer == totalValue){
			displayCorrectResponse();
		}
		else{
			displayInorrectResponse();
			quiz();
		}
	}
  	  
	//Switch used to randomly display a message when the answer given is correct.
	private static void displayCorrectResponse(){
  		switch(responseOption){
  		case 1:
  			System.out.println("Very good!\n");
  			break;
  		case 2:
  			System.out.println("Awesome, great job!\n");
  			break;
  		case 3:
  			System.out.println("Nice, you got it!\n");
  			break;
  		case 4:
  			System.out.println("You got it! Keep it up!\n");
  			break;
  		}
  	}
  	  
  	//Switch used to randomly display a message when the answer given is incorrect.
  	private static void displayInorrectResponse(){	    
  	switch(responseOption){
		case 1:
			  System.out.println("No. Please try again.\n");
			break;
		case 2:
			System.out.println("Come on, you can do better!\n");
			break;
		case 3:
			System.out.println("Keep trying. You got this!\n");
			break;
		case 4:
			System.out.println("Wrong. You can do better!\n");
			break;
		}
  	}
}