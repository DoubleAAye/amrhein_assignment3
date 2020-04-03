import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI3{
  	static int randomValue1;
  	static int randomValue2;
	static int responseOption;
  	static int totalValue;
	static int userAnswer;
	static int count = 0;
	static double correctAnswers = 0.0;
	static double percentage;
	
	static Scanner in = new Scanner(System.in);

	public static void main(String args[]){
		SecureRandom randomValue = new SecureRandom();
		Random responseOptionNumber = new Random();
		randomValue1 = randomValue.nextInt(10);
		randomValue2 = randomValue.nextInt(10);
		totalValue = randomValue1 * randomValue2;
		responseOption = responseOptionNumber.nextInt(3);
		responseOption += 1;
		quiz();

	}

	//Class to run the quiz based on difficulty and type of problem
	static public void quiz(){
		do{
			count++;
			newValues();
			newOptionNumber();
			askQuestion();
			readResponse();
			isAsnwerCorrect();
		}
		
		//Concludes the quiz with the final score and an option to continue
		while (count != 10);
		displayCompletionMessage();
		continuePrompt();
	}

	//Prints out the question
	private static void askQuestion(){
		System.out.println(count + ": What is " + randomValue1 + " x " + randomValue2 + "?");
	}

	//Reads the users answer to be checked
	private static void readResponse(){
		userAnswer = in.nextInt();	
	}

	//Method to check for correct answer.
	private static void isAsnwerCorrect(){
		if (userAnswer == totalValue){
			displayCorrectResponse();
		}
		else{
			displayInorrectResponse();
		}
	}
	
	//Calculates Percentage of answers correct.
	private static void percentageCalculation(){
  		percentage = (correctAnswers / 10.0) * 100.00;	  
  	}
	
	private static void displayCompletionMessage(){
		percentageCalculation();
  		if(percentage >= 75){
  			System.out.println("Total score: " + percentage + "% Congratulations, you are ready to go to the next level!");
  			continuePrompt(); 
  		}
  		else{
  			System.out.println("Total score: " + percentage +"% Please ask your teacher for extra help.");
  			continuePrompt();
  		}  
  	  }
	
	private static void newValues(){
		SecureRandom randomValue = new SecureRandom();
		randomValue1 = randomValue.nextInt(10);
		randomValue2 = randomValue.nextInt(10);
		totalValue = randomValue1 * randomValue2;
	}
	
	private static void newOptionNumber(){
		Random responseOptionNumber = new Random();
		responseOption = responseOptionNumber.nextInt(3);
		responseOption += 1;
	}
  	  
	//Switch used to randomly display a message when the answer given is correct.
	private static void displayCorrectResponse(){
		switch(responseOption){
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Awesome, great job!");
			break;
		case 3:
			System.out.println("Nice, you got it!");
			break;
		case 4:
			System.out.println("You got it! Keep it up!");
			break;
		}
		correctAnswers++;
	}

	//Switch used to randomly display a message when the answer given is incorrect.
	private static void displayInorrectResponse(){
		switch(responseOption){
		case 1:
			System.out.println("No. Please try again.\n");
			break;
		case 2:
			System.out.println("Come on, you can do better!");
			break;
		case 3:
			System.out.println("Keep trying. You got this!");
			break;
		case 4:
			System.out.println("Wrong. You can do better!");
			break;
		}
  	}
  	  
	  //Method to prompt the user to either continue or close the program.
	  private static void continuePrompt(){
		  int userChoice;
		  System.out.println("Would you like some new problems to complete?");
		  System.out.println("1. Continue");
		  System.out.println("2. Exit");
		  userChoice = in.nextInt();
  		
		  //Choice one continues and resets everything back to 0 for a new set of problems.
		  if(userChoice == 1){
			  count = 0;
			  percentage = 0;
			  correctAnswers = 0;
			  quiz();
		  }
		  //Choice two exits the program.
		  else if(userChoice == 2){
			  System.out.println("Goodbye!");
			  System.exit(0);
		  }
		  //Anything besides 1 or 2 will be invalid and result in prompt being displayed again.
		  else{
			  System.out.println("Invalid, pick another option.");
			  continuePrompt();
		  }
	  }
}