package animals;

public abstract class Vertebrate implements Animal {
    private String name;
    private int age;
    private double weight;
    private String healthStatus;

    public Vertebrate(String name, int age, double weight) {
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.healthStatus = "Здоров";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным");
        }
        this.weight = weight;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит");
    }

    public void move() {
        System.out.println(name + " двигается");
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age +
                ", Вес: " + weight + "кг, Состояние здоровья: " + healthStatus);
    }

    public abstract void makeSound();
    public abstract void feed();
}