package p02_VehicleExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(Double fuelQuantity){
        if (fuelQuantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setTankCapacity(Double tankCapacity){
        this.tankCapacity = tankCapacity;
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

    public void tryDriveFull(Double distance){
        this.setFuelConsumption(this.getFuelConsumption() + 1.4);
        this.tryDrive(distance);
        this.setFuelConsumption(this.getFuelConsumption() - 1.4);
    }

    protected void tryRefuel(Double litres) {
        if (this.fuelQuantity + litres <= this.tankCapacity) {
            this.fuelQuantity += litres;
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    protected boolean validateDrive(Double distance) {
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