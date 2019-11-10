import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Numbers {

    private ArrayList<BigDecimal> input;
    private Scanner scanner = new Scanner(System.in);
    private BigDecimal target;
    private boolean finished = false;
    private int counter;

    public Numbers() {
        input = new ArrayList<>();
    }

    public void add(BigDecimal numbers) {
        input.add(numbers);
    }

    public void acceptInput() {
        System.out.println("Enter a number followed by Enter. Repeat and type 'done' when done.");
        boolean done = false;

        while (!done) {
            String inputstring = scanner.nextLine();
            if (inputstring.equals("done") || inputstring.equals("Done") || inputstring.equals("DONE"))
                done = true;
            else {
                BigDecimal number = new BigDecimal(inputstring);
                input.add(number);
            }
        }
    }

    public void acceptTarget() {
        System.out.println("Enter target number.");
        String targetstring = scanner.nextLine();
        this.target = new BigDecimal(targetstring);
    }

    public ArrayList<BigDecimal> getNumbers() {
        return input;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void recursiveCalculate(int start, BigDecimal currentsum, ArrayList<BigDecimal> path) {
        this.counter++;
        if (currentsum.equals(target)) {
            String output = "Solution is: ";
            for (int i=0; i < path.size(); i++) {
                if (i==0) {
                    output = output + path.get(i) + " ";
                }
                else {
                    output = output + "+ " + path.get(i) + " ";
                }
            }
            System.out.println(output);
            finished = true;
            return;
        }
        if (start < input.size()) {
            for (int i = start+1; i < input.size(); i++) {
                if (currentsum.add(input.get(i)).compareTo(target) <= 0 && !finished) {
                    path.add(input.get(i));
                    recursiveCalculate(i, currentsum.add(input.get(i)), path);
                    path.remove(path.size()-1);
                }
                else
                    break;
            }
        }
    }

    public void calculate() {
        for (int i = 0; i < input.size(); i++)
        {
            if (finished == true) {
                return;
            }
            ArrayList path = new ArrayList<Float>();
            path.add(input.get(i));
            recursiveCalculate(i, input.get(i), path);
        }
        if (finished == false) {
            System.out.println("No solution found.");
        }
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        ArrayList<BigDecimal> sortedinput = input;
        Collections.sort(sortedinput);
        String output = "You entered: ";
        for (int i = 0; i < sortedinput.size(); i++) {
            output = output + sortedinput.get(i) + ", ";
        }
        output = output + "\nTarget number is: " + getTarget();
        return output;
    }
}
