import java.util.Scanner;

public class Kapitel8Opgave13 {


    public static void main(String[] args) {
        BankAccount bank = new BankAccount("Andreas Jepsen Nielsen", 100, 0.00);
        BankAccount bank2 = new BankAccount("Lukas Nielsen", 250, 0.00);

        //  bank.withdraw(50); // fjern kommentar for at teste withdraw

        //  System.out.println(bank); // fjernkommentar for at teste tostring

         bank.transfer(bank2,120); // fjernkommentar for at teste transfer
    }


    public static class BankAccount {
        Scanner sc = new Scanner(System.in);
        String name;
        double balance = 100;
        double transacionFee = 0.00;

        public void deposit(double amount) {
            balance = balance + amount;
        }

        public BankAccount(String name, double balance, double transacionFee) {
            this.name = name;
            this.balance = balance;
            this.transacionFee = transacionFee;
        }

        /*
        Add a transfer method to the BankAccount class from the previous exercises. Your method should move money
from the current bank account to another account. The method accepts two parameters: a second BankAccount to
accept the money, and a real number for the amount of money to transfer. There is a $5.00 fee for transferring
money, so this much must be deducted from the current account’s balance before any transfer. The method should
modify the two BankAccount objects such that “this” current object has its balance decreased by the given amount
plus the $5 fee, and the other account's balance is increased by the given amount. If this account object does not have
enough money to make the full transfer, transfer whatever money is left after the $5 fee is deducted. If this account
has under $5 or the amount is 0 or less, no transfer should occur and neither account's state should be modified. The
following are some example calls to the method:
BankAccount ben = new BankAccount();
ben.deposit(80.00);
BankAccount hal = new BankAccount();
hal.deposit(20.00);
ben.transfer(hal, 20.00); // ben $55, hal $40 (ben -$25, hal +$20)
ben.transfer(hal, 10.00); // ben $40, hal $50 (ben -$15, hal +$10)
hal.transfer(ben, 60.00); // ben $85, hal $ 0 (ben +$45, hal -$50)
         */


        // transfer = kapitel 8 opgave 13
        public void transfer(BankAccount account, double amount) {
            System.out.println("Please enter the amount you wish to transfer to " + account.name + ":");
            amount = sc.nextDouble();
            transacionFee = 5.00;

            balance = balance - transacionFee;

            if (balance <= 0) {
                System.out.println("You have no money left on your account");

            } else if (balance < amount) {
                balance = balance - amount;
                while (balance < 0) {
                    balance++;
                    amount--;


                }
                account.balance = account.balance + amount;

                System.out.println("You have transfered " + amount + " to " + account.name);

            } else {
                balance = balance - amount;

                account.balance = account.balance + amount;

                System.out.println("You have transfered " + amount + " to " + account.name);
            }


        }
    }
}
