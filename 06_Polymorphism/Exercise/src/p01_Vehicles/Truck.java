package p01_Vehicles;

public class Truck extends Vehicle{
    private Double totalKm;

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.totalKm = 0d;
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        fuelConsumption += 1.6;
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    protected void tryRefuel(Double litres) {
        litres *= 0.95;
        super.tryRefuel(litres);
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
