package p02_VehicleExtension;

public class Bus extends Vehicle {

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void tryDrive(Double distance) {
            super.tryDrive(distance);
    }

    @Override
    public void tryDriveFull(Double distance){
        super.tryDriveFull(distance);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
