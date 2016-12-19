package p01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    private void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void tryDrive(Double distance) {
        if (validateDrive(distance)) {
            this.fuelQuantity -= this.fuelConsumption * distance;
            String formatedDistance = new DecimalFormat("#.##").format(distance);
            System.out.println(String.format("%s travelled %s km",
                    getClass().getSimpleName(),
                    formatedDistance));
        }
        else {
            System.out.println(String.format("%s needs refueling", getClass().getSimpleName()));
        }
    }

    protected void tryRefuel(Double litres) {
        this.fuelQuantity += litres;
    }

    private boolean validateDrive(Double distance) {
        if (this.fuelQuantity >= this.fuelConsumption * distance) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return (String.format("%s: %.2f",
                getClass().getSimpleName(), this.fuelQuantity));
    }
}
