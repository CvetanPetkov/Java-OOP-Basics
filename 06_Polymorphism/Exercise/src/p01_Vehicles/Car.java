package p01_Vehicles;

public class Car extends Vehicle{

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        fuelConsumption += 0.9;
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    public void tryDrive(Double distance) {
        super.tryDrive(distance);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
