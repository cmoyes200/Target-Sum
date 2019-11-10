import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        while (!finished) {
            Numbers numbers = new Numbers();
            System.out.println("Target Sum Program");
            numbers.acceptInput();
            numbers.acceptTarget();
            long start = System.currentTimeMillis();
            System.out.println(numbers.toString());
            numbers.calculate();
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            System.out.println("Checked " + numbers.getCounter() + " " + "possibilities in " + sec + " seconds.");
            System.out.println("Would you like to play again? (Y/N)");
            String inputstring = scanner.nextLine();
            inputstring = inputstring.toLowerCase();
            if (inputstring.equals("n")) {
                finished = true;
                System.out.println("Goodbye!");
                System.exit(0);
            }

        }

    }
}
