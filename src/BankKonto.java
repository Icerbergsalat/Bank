import java.util.ArrayList;

public class BankKonto {
    private String kontonummer;
    private double saldo;
    private static ArrayList<BankKonto> accountNumber = new ArrayList<>();

    public BankKonto(String kontonummer, double saldo) {
        this.kontonummer = kontonummer;
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public double deposit(int amount) {
        if (amount < 0){
            Main.customExceptions("invalidAmountException");
        } else {
            this.saldo += amount;
        }
        return this.saldo;
    }

    public double withdraw(int amount) {
        if (this.saldo < amount && amount > 0) {
            Main.customExceptions("insufficientFundsException");
        } else {
            this.saldo -= amount;
        }
        return this.saldo;
    }

    public double getBalance() {
        return this.saldo;
    }

    public static BankKonto getAccountNumber(String accountNumber) {
        for (BankKonto k: BankKonto.accountNumber){
            if (k.kontonummer.equals(accountNumber)) {
                return k;
            }
        }
        Main.customExceptions("accountNotFoundException");
        return null;
    }
    public static void addAccountNumber(BankKonto accountNumber) {
        BankKonto.accountNumber.add(accountNumber);
    }
}