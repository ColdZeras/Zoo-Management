package animals;

public class Lion extends Vertebrate {
    private String maneColor;
    private boolean isAlpha;

    public Lion(String name, int age, double weight, String maneColor, boolean isAlpha) {
        super(name, age, weight);
        this.maneColor = maneColor;
        this.isAlpha = isAlpha;
    }

    public String getManeColor() {
        return maneColor;
    }

    public void setManeColor(String maneColor) {
        this.maneColor = maneColor;
    }

    public boolean isAlpha() {
        return isAlpha;
    }

    public void setAlpha(boolean alpha) {
        isAlpha = alpha;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " громко рычит: РРРРР!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест свежее мясо");
        setHealthStatus("Сытый и довольный");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Цвет гривы: " + maneColor + ", Вожак стаи: " + (isAlpha ? "Да" : "Нет"));
    }

    public void hunt() {
        System.out.println(getName() + " отправляется на охоту");
    }
}