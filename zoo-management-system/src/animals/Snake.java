package animals;

public class Snake extends Reptile {
    private double length;
    private boolean isVenomous;
    private String skinPattern;

    public Snake(String name, int age, double weight, double bodyTemperature,
                 double length, boolean isVenomous, String skinPattern) {
        super(name, age, weight, bodyTemperature);
        this.length = length;
        this.isVenomous = isVenomous;
        this.skinPattern = skinPattern;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    public String getSkinPattern() {
        return skinPattern;
    }

    public void setSkinPattern(String skinPattern) {
        this.skinPattern = skinPattern;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " угрожающе шипит: Шшшшш!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест мелких грызунов");
        setHealthStatus("Сытый");
    }

    @Override
    public void move() {
        System.out.println(getName() + " бесшумно ползет");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Длина: " + length + "м, Ядовитая: " + (isVenomous ? "Да" : "Нет") +
                ", Окрас: " + skinPattern);
    }

    public void shedSkin() {
        System.out.println(getName() + " сбрасывает старую кожу");
    }
}