package p05_FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Fibonacci {
    private List<Long> numbers;

    public Fibonacci () {
        this.numbers = new ArrayList<>();
    }

    public List<Long> getNumbersList () {
        return numbers;
    }

    public void getNumbers(Long start, Long end) {
        List<Long> currNums = new ArrayList<>();
        currNums.add(0l);
        currNums.add(1l);
        Long first = 0l;
        Long second = 1l;
        if (start < 2) {
            numbers.add(0l);
            numbers.add(1l);
        }
        for (long i = 2; i < end; i++) {
            Long third = first + second;
            first = second;
            second = third;
            if (i >= start && i < end) {
                numbers.add(third);
            }
            currNums.add(third);
        }
    }
}

public class p05_FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long start = Long.valueOf(reader.readLine());
        Long end = Long.valueOf(reader.readLine());
        Fibonacci number = new Fibonacci();
        number.getNumbers(start, end);

        String output = number.getNumbersList().stream()
                .map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
    }
}