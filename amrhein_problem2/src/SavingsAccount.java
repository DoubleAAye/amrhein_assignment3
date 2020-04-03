public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double totalBalance){
        savingsBalance = totalBalance;
    }

    //Calculates the monthly interest and adds that interest to savings balance.
    public double calculateMonthlyInterest(){
        double monthlyInterest = savingsBalance * (annualInterestRate / 12);
        savingsBalance += monthlyInterest;
        return savingsBalance;
    }
    
    //Changes the interest rate after calculating the first 12 months.
    public static void modifyInterestRate(double i){
        annualInterestRate = i;
    }
}