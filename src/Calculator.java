import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    int principal = 0;
    double monthlyInterest = 0;
    double annualInterest = 0;
    int paymentMonth = 0;
    int paymentYear = 0;
//    String mortgageFormatted = "";
    Scanner scanner = new Scanner(System.in);

    public String Mortgage() {
        double mortgage;
        while (true) {
            System.out.print("Principal($1K - $1M):");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1000 and 1000000!");
        }

        while (true) {
            System.out.print("Annual Interest Rate:");
            this.annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal 30!");
        }
        while (true) {
            System.out.print("Periods(Years):");
            this.paymentYear = scanner.nextInt();
            if (paymentYear >= 1 && paymentYear <= 30) {
                paymentMonth = paymentYear * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value 1 or 30!");
        }

        mortgage =  principal * (monthlyInterest * Math.pow(1 + monthlyInterest, paymentMonth)) /
                (Math.pow(1 + monthlyInterest, paymentMonth) - 1);

//        //this.mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        return NumberFormat.getCurrencyInstance().format(mortgage);


    }

}
