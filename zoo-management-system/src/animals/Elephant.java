package animals;

public class Elephant extends Vertebrate {
    private double tuskLength;
    private double trunkLength;

    public Elephant(String name, int age, double weight, double tuskLength, double trunkLength) {
        super(name, age, weight);
        this.tuskLength = tuskLength;
        this.trunkLength = trunkLength;
    }

    public double getTuskLength() {
        return tuskLength;
    }

    public void setTuskLength(double tuskLength) {
        this.tuskLength = tuskLength;
    }

    public double getTrunkLength() {
        return trunkLength;
    }

    public void setTrunkLength(double trunkLength) {
        this.trunkLength = trunkLength;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " громко трубит: ТУУУУУ!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест фрукты, овощи и сено");
        setHealthStatus("Накормлен");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Длина бивней: " + tuskLength + "м, Длина хобота: " + trunkLength + "м");
    }

    public void sprayWater() {
        System.out.println(getName() + " обливается водой с помощью хобота");
    }
}