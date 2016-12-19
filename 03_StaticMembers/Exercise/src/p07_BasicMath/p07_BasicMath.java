package p07_BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

class MAthUtil {

    public static Double sum(Double num1, Double num2){
        return num1+num2;
    }
    public static Double multiply(Double num1, Double num2){
        return num1*num2;
    }
    public static Double divide(Double num1, Double num2){
        return num1/num2;
    }
    public static Double subtract(Double num1, Double num2){
        return num1 - num2;
    }
    public static Double percentage(Double number, Double percent){
        return ((percent/100) * number);
    }
}

public class p07_BasicMath {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[\\s]+");
        MAthUtil math = new MAthUtil();

        while (!input[0].equals("End")) {
            Double num1 = Double.valueOf(input[1]);
            Double num2 = Double.valueOf(input[2]);
            switch (input[0]) {
                case "Sum":
                    System.out.printf("%.2f\n", MAthUtil.sum(num1, num2));
                    break;
                case "Subtract":
                    System.out.printf("%.2f\n", MAthUtil.subtract(num1, num2));
                    break;
                case "Multiply":
                    System.out.printf("%.2f\n", MAthUtil.multiply(num1, num2));
                    break;
                case "Divide":
                    System.out.printf("%.2f\n", MAthUtil.divide(num1, num2));
                    break;
                case "Percentage":
                    System.out.printf("%.2f\n", MAthUtil.percentage(num1, num2));
                    break;
            }

            input = reader.readLine().split("[\\s]+");
        }
    }
}
