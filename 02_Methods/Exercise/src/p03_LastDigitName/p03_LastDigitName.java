package p03_LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Number {
    private Integer number;

    public Number (Integer number) {
        this.number = number;
    }

    public Integer getLastNumber (Number number) {
        return number.number % 10;
    }

    public void readDigit (Integer digit) {
        switch (digit) {
            case 0:
                System.out.println("zero");break;
            case 1:
                System.out.println("one");break;
            case 2:
                System.out.println("two");break;
            case 3:
                System.out.println("three");break;
            case 4:
                System.out.println("four");break;
            case 5:
                System.out.println("five");break;
            case 6:
                System.out.println("six");break;
            case 7:
                System.out.println("seven");break;
            case 8:
                System.out.println("eight");break;
            case 9:
                System.out.println("nine");break;
        }
    }
}

public class p03_LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(reader.readLine());
        Number number = new Number(n);

        Integer lastDigit = number.getLastNumber(number);
        number.readDigit(lastDigit);
    }
}
