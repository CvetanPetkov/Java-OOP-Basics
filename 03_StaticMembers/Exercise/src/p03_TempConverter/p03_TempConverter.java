package p03_TempConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Converter {
    private Integer temp;
    private String unit;

    public Converter (Integer temp, String unit) {
        this.temp = temp;
        this.unit = unit;
    }

    public static Double convertToFahrenheit (Integer temp) {
        return (temp * 1.8d) + 32d;
    }

    public static Double convertToCelsius (Integer temp) {
        return (temp - 32d) / 1.8d;
    }
}

public class p03_TempConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = reader.readLine().split("[\\s]+");
            if (input[0].equals("End")) {
                break;
            } else {
                Integer temp = Integer.valueOf(input[0]);
                String unit = input[1];
                Converter converter = new Converter(temp, unit);

                switch (unit) {
                    case "Celsius":
                        System.out.printf("%.2f Fahrenheit\n",
                                Converter.convertToFahrenheit(temp));
                        break;
                    case "Fahrenheit":
                        System.out.printf("%.2f Celsius\n",
                                Converter.convertToCelsius(temp));
                        break;
                }
            }
        }
    }
}
