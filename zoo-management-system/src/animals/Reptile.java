package animals;

public abstract class Reptile extends Vertebrate {
    private double bodyTemperature;

    public Reptile(String name, int age, double weight, double bodyTemperature) {
        super(name, age, weight);
        this.setBodyTemperature(bodyTemperature);
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        if (bodyTemperature < -10 || bodyTemperature > 50) {
            throw new IllegalArgumentException("Температура тела должна быть в разумных пределах");
        }
        this.bodyTemperature = bodyTemperature;
    }

    public void baskInSun() {
        System.out.println(getName() + " греется на солнце");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Температура тела: " + bodyTemperature + "°C");
    }
}