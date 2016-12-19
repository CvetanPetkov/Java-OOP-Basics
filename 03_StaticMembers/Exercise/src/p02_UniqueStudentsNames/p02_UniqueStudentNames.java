package p02_UniqueStudentsNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Student {
    private String name;

    public Student (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }
}

class StudentGroup {
    private HashSet<String> studentSet;
    static Integer count = 0;

    public StudentGroup () {
        this.studentSet = new HashSet<>();
    }

    public void addStudent (Student student) {
        this.studentSet.add(student.getName());
    }

    public void getUniqueStudents () {
        count = this.studentSet.size();
    }
}

public class p02_UniqueStudentNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StudentGroup group = new StudentGroup();

        while (!input.equals("End")) {
            Student student = new Student(input);
            group.addStudent(student);
            input = reader.readLine();
        }
        group.getUniqueStudents();

        System.out.println(StudentGroup.count);
    }
}
