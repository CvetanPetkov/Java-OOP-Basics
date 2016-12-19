package p03_Mankind;

public class Worker extends Human{
    private Double weekSalary;
    private Double hoursPerDay;
    private Double moneyPerHour;
    private boolean isValidWeekSalary;
    private boolean isValidHoursPerDay;

    public Worker(String firstName, String lastName, Double weekSalary, Double hoursPerDay){
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
        this.setMoneyPerHour(weekSalary, hoursPerDay);
        this.isValidLastName = false;
        this.isValidWeekSalary = false;
        this.isValidHoursPerDay = false;
    }

    // GETTERS AND SETTERS
    private Double getWeekSalary(){
        return this.weekSalary;
    }
    private void setWeekSalary(Double weekSalary){
        validateWeekSalary(weekSalary);
        if (isValidWeekSalary){
            this.weekSalary = weekSalary;
        }
    }

    private Double getHoursPerDay(){
        return this.hoursPerDay;
    }
    private void setHoursPerDay(Double hoursPerDay){
        validateHoursPerDay(hoursPerDay);
        if (isValidHoursPerDay){
            this.hoursPerDay = hoursPerDay;
        }
    }

    private void setMoneyPerHour(Double weekSalary, Double hoursPerDay){
        this.moneyPerHour = (weekSalary / 7) / hoursPerDay;
    }
    private Double getMoneyPerHour(){
        return this.moneyPerHour;
    }

    // VALIDATORS
    @Override
    protected boolean validateLastName(String name) {
        if (name.trim().length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        else {
            super.setIsValidLastName(true);
        }
        return super.isValidLastName;
    }

    private void validateWeekSalary(Double weekSalary) {
        if (weekSalary < 11) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        else {
            this.isValidWeekSalary = true;
        }
    }

    private void validateHoursPerDay(Double hoursPerDay){
        if (hoursPerDay < 1 || hoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        else {
            this.isValidHoursPerDay = true;
        }
    }

    //  METHODS
    @Override
    public String toString(){
        return super.toString() + String.format("Week Salary: %.2f\nHours per day: %.2f\nSalary per hour: %.2f",
                this.getWeekSalary(), this.getHoursPerDay(), this.getMoneyPerHour());
    }
}
