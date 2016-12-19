package p04_NumberReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Stack;

class DecimalNumber {
    private String number;

    public DecimalNumber (String number) {
        this.number = number;
    }

    public void printReversed (String number) {
        Stack<Character> stack = new Stack<>();
        for (Character c : number.toCharArray()) {
            stack.push(c);
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}

public class p04_NumberReversedOrder {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        DecimalNumber number = new DecimalNumber(n);

        number.printReversed(n);
    }
}
