package p03_Mankind;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Human{
    private String facultyNumber;
    private boolean isValidNumber;

    public Student(String firstName, String lastName, String number){
        super(firstName, lastName);
        this.setFacultyNumber(number);
        this.isValidNumber = false;
    }

    //  GETTERS AND SETTERS
    private String getFacultyNumber(){
        return this.facultyNumber;
    }
    private void setFacultyNumber(String number){
        validateNumber(number);
        if (isValidNumber) {
            this.facultyNumber = number;
        }
    }

    //  VALIDATORS
    private boolean validateNumber(String number) {
        Matcher matcher = Pattern.compile("([^a-zA-Z0-9\\s])").matcher(number);
        if (number.trim().length() < 5 || number.trim().length() > 10 || matcher.find()) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        else {
            isValidNumber = true;
        }
        return this.isValidNumber;
    }

    //  METHODS
    @Override
    public String toString(){
        return super.toString() + String.format("Faculty number: %s", this.getFacultyNumber());
    }
}
