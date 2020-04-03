public class SavingsAccountTest {

    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        SavingsAccount.modifyInterestRate(.04);

        //Loop to print interest rate for saver1 and saver2 at 4% each month for 12 months
        for (int i = 1; i <= 12; i++){
        	System.out.printf("Month %d: 4%% Interest Rate \n",i);
        	System.out.printf("Account Holder 1 balance: $%.2f\n", saver1.calculateMonthlyInterest());
            System.out.printf("Account Holder 2 balance: $%.2f\n\n", saver2.calculateMonthlyInterest());
        }

        //Prints interest rate for additional month at 5%
        SavingsAccount.modifyInterestRate(.05);
        System.out.printf("Month 13: 5%% Interest Rate \n");
        System.out.printf("Account Holder 1 balance: $%.2f\n", saver1.calculateMonthlyInterest());
        System.out.printf("Account Holder 2 balance: $%.2f\n", saver2.calculateMonthlyInterest());
    }
}