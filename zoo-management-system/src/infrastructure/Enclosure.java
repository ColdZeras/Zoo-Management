package infrastructure;

import animals.Animal;
import animals.Vertebrate;
import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private List<Animal> animals;
    private String name;
    private double area;
    private String environmentType;
    private int maxCapacity;

    public Enclosure(String name, double area, String environmentType, int maxCapacity) {
        this.name = name;
        this.setArea(area);
        this.environmentType = environmentType;
        this.setMaxCapacity(maxCapacity);
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Животное не может быть null");
        }
        if (animals.size() >= maxCapacity) {
            throw new IllegalStateException("Вольер " + name + " переполнен! Максимальная вместимость: " + maxCapacity);
        }
        animals.add(animal);
        System.out.println(animal.getClass().getSimpleName() + " " +
                ((Vertebrate) animal).getName() + " добавлен в вольер " + name);
    }

    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getClass().getSimpleName() + " " +
                    ((Vertebrate) animal).getName() + " удален из вольера " + name);
        } else {
            System.out.println("Животное не найдено в вольере " + name);
        }
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void displayAnimals() {
        System.out.println("\n=== Вольер '" + name + "' ===");
        System.out.println("Тип среды: " + environmentType + ", Площадь: " + area +
                "м², Вместимость: " + animals.size() + "/" + maxCapacity);

        if (animals.isEmpty()) {
            System.out.println("Вольер пуст");
        } else {
            for (Animal animal : animals) {
                Vertebrate v = (Vertebrate) animal;
                System.out.println("- " + animal.getClass().getSimpleName() +
                        ": " + v.getName() + ", возраст: " + v.getAge() +
                        ", вес: " + v.getWeight() + "кг");
            }
        }
    }

    public void makeAllSounds() {
        System.out.println("\n=== Звуки из вольера '" + name + "' ===");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void performMorningRoutine() {
        System.out.println("\n=== Утренний обход вольера '" + name + "' ===");
        for (Animal animal : animals) {
            Vertebrate v = (Vertebrate) animal;
            v.sleep();
            animal.makeSound();
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getArea() { return area; }
    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть положительной");
        }
        this.area = area;
    }

    public String getEnvironmentType() { return environmentType; }
    public void setEnvironmentType(String environmentType) { this.environmentType = environmentType; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительной");
        }
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentAnimalCount() { return animals.size(); }
}