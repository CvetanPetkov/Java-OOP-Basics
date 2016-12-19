package p03_Mankind;

public class Human {

    private String firstName;
    private String lastName;
    private boolean isValidFirstName;
    protected boolean isValidLastName;

    protected Human(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.isValidFirstName = false;
        this.isValidLastName = false;
    }

    //  GETTERS AND SETTERS
    public String getFirstName(){
        return this.firstName;
    }
    private void setFirstName(String name){
            validateFirstName(name);
        if (this.isValidFirstName) {
            this.firstName = name;
        }
    }

    public  String getLastName(){
        return this.lastName;
    }
    private void setLastName(String name){
            validateLastName(name);
        if (this.isValidLastName) {
            this.lastName = name;
        }
    }

    protected void setIsValidLastName(boolean isTrue){
        this.isValidLastName = isTrue;
    }

    //  VALIDATORS
    private boolean validateFirstName (String name) {
            if (Character.isLowerCase(name.charAt(0))){
                throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");
            }
            else if (name.trim().length() < 4) {
                throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
            }
            else {
                this.isValidFirstName = true;
            }
        return this.isValidFirstName;
    }
    protected boolean validateLastName(String name) {
        if (Character.isLowerCase(name.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        else if (name.trim().length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        else {
            this.isValidLastName = true;
        }
        return this.isValidLastName;
    }

    //  METHODS
    @Override
    public String toString(){
        return String.format("First Name: %s\nLast Name: %s\n",
                this.getFirstName(), this.getLastName());
    }

}
