package p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] studentLine = reader.readLine().split("[\\s]+");
            String studentFirstName = studentLine[0];
            String studentLastName = studentLine[1];
            String facultyNumber = studentLine[2];
            Student student = new Student(studentFirstName, studentLastName, facultyNumber);

            String[] workerLine = reader.readLine().split("[\\s]+");
            String workerFirstName = workerLine[0];
            String workerLastName = workerLine[1];
            Double salary = Double.parseDouble(workerLine[2]);
            Double hoursPerDay = Double.parseDouble(workerLine[3]);
            Worker worker = new Worker(workerFirstName, workerLastName, salary, hoursPerDay);

            System.out.println(student.toString());
            System.out.println();
            System.out.println(worker.toString());
        }
        catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }



    }
}
