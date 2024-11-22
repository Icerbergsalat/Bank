import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menus();
    }
    public static void customExceptions(String message) {
        switch (message) {
            case "insufficientFundsException":
                System.out.println("Insufficient funds");
                break;
            case "invalidAmountException":
                System.out.println("Invalid amount");
                break;
            case "accountNotFoundException":
                System.out.println("Account not found");
                break;
            default:
                System.out.println("Unknown error");
        }
    }
    public static void menus() {
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("what would you like to do? (add account/find account/check balance/deposit/withdraw)\n: ");
            String menu = input.nextLine();
            switch (menu) {
                case "add account":
                    System.out.println("give account number");
                    String kontonummer = input.nextLine();
                    System.out.println("how much money?");
                    int money = input.nextInt();
                    input.nextLine();

                    BankKonto.addAccountNumber(new BankKonto(kontonummer, money));
                    break;

                case "find account":
                    System.out.println("what number would you like to find?");
                    String number = input.nextLine();

                    if (BankKonto.getAccountNumber(number) != null) {
                        System.out.println("Account found");
                    }
                    break;

                case "check balance":
                    System.out.println("what account number would you like to check?");
                    String number2 = input.nextLine();
                    System.out.println(Objects.requireNonNull(BankKonto.getAccountNumber(number2)).getBalance());
                    break;

                case "deposit":
                    try {
                        System.out.println("what account number would you like to deposit?");
                        String number3 = input.nextLine();
                        BankKonto.getAccountNumber(number3);
                        System.out.println("how much money would you like to deposit?");
                        int deposit = input.nextInt();
                        System.out.println("your new amount is: " + Objects.requireNonNull(BankKonto.getAccountNumber(number3)).deposit(deposit));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "withdraw":
                    try {
                        System.out.println("what account number would you like to withdraw?");
                        String number4 = input.nextLine();
                        BankKonto.getAccountNumber(number4);
                        System.out.println("how much money would you like to withdraw?");
                        int withdraw = input.nextInt();
                        System.out.println("your new amount is: " + Objects.requireNonNull(BankKonto.getAccountNumber(number4)).withdraw(withdraw));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("wrong!!!!");
            }
        } while (true);
    }
}