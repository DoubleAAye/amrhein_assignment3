import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI5{
	static int difficultyLevel;
	static int problemCatagory;
  	static int randomValue1;
  	static int randomValue2;
	static int responseOption;
  	static int totalValue;
	static int userAnswer;
	static int count = 0;
	static double correctAnswers = 0.0;
	static double percentage;
	static boolean caseOption = false;
	
	static double userAnswerdivProblem;
	static double totalValuedivProblem;
	static boolean divProblem = false;
	
	static Scanner in = new Scanner(System.in);     
	
	public static void main(String args[]){
		quiz();
	}

	//Method to run the quiz based on difficulty and type of problem
	static public void quiz(){
		readDifficulty();
		readProblemType();
		do{
			count++;
			generateQuestionArgument();
			newOptionNumber();
			askQuestion();
			readResponse();
			problemCatagory();
			isAsnwerCorrect();
		}
		
		//Concludes the quiz with the final score and an option to continue
		while (count != 10);
		displayCompletionMessage();
		continuePrompt();
	}	
	
	//Prints out the options for choosing a difficulty level
	private static void readDifficulty(){         
		System.out.println("Please enter a level of difficulty");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");
		System.out.println("4. Extra hard");
		difficultyLevel = in.nextInt();	
	}
	
	//Prints out the options for what type of problem to solve.
	private static void readProblemType(){
		System.out.println("\nChoose the type of problems you want to answer.");
		System.out.println("1. Addition");
		System.out.println("2. Multiplication");
		System.out.println("3. Subtraction");
		System.out.println("4. Division");
		System.out.println("5. Mixture");
		problemCatagory = in.nextInt();		
	}

	//Switch for selecting the level if difficulty
	private static void generateQuestionArgument(){
		SecureRandom randomNum = new SecureRandom();	
		switch(difficultyLevel){
 		case 1:
 			randomValue1 = randomNum.nextInt(10);
 			randomValue2 = randomNum.nextInt(10);
 			break;
 		case 2:
 		 	randomValue1 = randomNum.nextInt(100);
 		 	randomValue2 = randomNum.nextInt(100);
 		 	break;
 		case 3:
 		 	randomValue1 = randomNum.nextInt(1000);
 		 	randomValue2 = randomNum.nextInt(1000);
 		 	break;
 		case 4:
 			randomValue1 = randomNum.nextInt(10000);
 			randomValue2 = randomNum.nextInt(10000);
 			break;
 		}
	}
	
	//Switch for selecting problem type to be solved
	private static void problemCatagory(){
		switch (problemCatagory) {
		case 1:
			totalValue = randomValue1 + randomValue2;
			break;
		case 2:
			totalValue = randomValue1 * randomValue2;
			break;
		case 3:
			totalValue = randomValue1 - randomValue2;
			break;
		case 4:
			divProblem = true;
			totalValuedivProblem = ((double)randomValue1 / (double)randomValue2);
			break;
			}			
	}
	
	//Prints out the question based on the options chosen
	private static void askQuestion(){
		Random randomQuestionNum = new Random();		
		if(problemCatagory == 5 || caseOption == true){
		    caseOption = true;
 			problemCatagory = randomQuestionNum.nextInt(4);
			problemCatagory += 1;
		}
		switch (problemCatagory){
		case 1:
			System.out.println(count + ": What is " + randomValue1 + " + " + randomValue2 + "?");
			break;
		case 2:
			System.out.println(count + ": What is " + randomValue1 + " x " + randomValue2 + "?");
			break;
		case 3:
			System.out.println(count + ": What is " + randomValue1 + " - " + randomValue2 + "?");
			break;
		case 4:
			System.out.println(count + ": What is " + randomValue1 + " / " + randomValue2 + "?");
			break;
		}
	}

	//Reads the users answer to be checked
	private static void readResponse(){	 	
		if(problemCatagory == 4) {
			userAnswerdivProblem = in.nextDouble();
		}
		else{
			userAnswer = in.nextInt();
		}	
	}

	//Method to check for correct answer.
	private static void isAsnwerCorrect(){
		//Checks for problem type. If division it reads how accurate the value was to determine correctness.
		if (divProblem == true){
			if (Math.abs(totalValuedivProblem - userAnswerdivProblem) < 0.051){
				displayCorrectResponse();
			}
			else{
				displayInorrectResponse();
			}
		}
		//Non division problems are checked for an exact match.
		if (divProblem == false){
			if (userAnswer == totalValue){
				displayCorrectResponse();
			}
			else{
				displayInorrectResponse();
			}
		} 
		divProblem = false;
	}
			
	//Calculates Percentage of answers correct.
	private static void percentageCalculation(){		  
		percentage = (correctAnswers / 10.0) * 100.00;		  
	  }
	
	//Displays the percentage and a message for the user to know if the need extra help or not.
	private static void displayCompletionMessage(){
		percentageCalculation();
  		if(percentage >= 75){
  			System.out.println("Total score: " + percentage + "% Congratulations, you are ready to go to the next level!");
  			continuePrompt(); 
  		}
  		else{
  			System.out.println("Total score: " + percentage + "% Please ask your teacher for extra help.");
  			continuePrompt();
  		}	  
  	  }
	
	private static void newOptionNumber(){
		Random randomResponsesNum = new Random();
		responseOption = randomResponsesNum.nextInt(3);
		responseOption += 1;
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
		    correctAnswers++;
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