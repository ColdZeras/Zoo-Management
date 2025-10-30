import animals.*;
import staff.*;
import infrastructure.Enclosure;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ЗООПАРКОМ ===\n");

        demonstrateAbstraction();

        System.out.println("\n2. СОЗДАНИЕ ЖИВОТНЫХ:");
        Animal[] animals = createAnimals();

        System.out.println("\n3. СОЗДАНИЕ ВОЛЬЕРОВ:");
        Enclosure[] enclosures = createEnclosures();

        distributeAnimalsToEnclosures(animals, enclosures);

        displayAllEnclosures(enclosures);

        System.out.println("\n4. СОЗДАНИЕ ПЕРСОНАЛА:");
        ZooStaff[] staff = createStaff();
        displayStaffInfo(staff);

        demonstratePolymorphism(animals, staff);

        System.out.println("\n6. РАБОТА СОТРУДНИКОВ:");
        staffWorkRoutine(staff, enclosures, animals);

        System.out.println("\n7. ДЕМОНСТРАЦИЯ ИНКАПСУЛЯЦИИ:");
        demonstrateEncapsulation();

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }

    private static void demonstrateAbstraction() {
        System.out.println("1. ДЕМОНСТРАЦИЯ АБСТРАКЦИИ:");
        System.out.println("// Animal animal = new Animal(); - КОМПИЛЯЦИОННАЯ ОШИБКА!");
        System.out.println("// Vertebrate vertebrate = new Vertebrate(); - КОМПИЛЯЦИОННАЯ ОШИБКА!");
        System.out.println("// ZooStaff staff = new ZooStaff(); - КОМПИЛЯЦИОННАЯ ОШИБКА!");
    }

    private static Animal[] createAnimals() {
        Lion lion = new Lion("Симба", 5, 190.5, "золотистый", true);
        Elephant elephant = new Elephant("Дамбо", 10, 4500.0, 1.2, 2.1);
        Snake snake = new Snake("Каа", 3, 8.5, 25.0, 3.2, true, "полосатый");
        Lion lioness = new Lion("Нала", 4, 130.0, "светлый", false);

        Animal[] animals = {lion, elephant, snake, lioness};

        for (Animal animal : animals) {
            Vertebrate v = (Vertebrate) animal;
            System.out.println("Создано: " + animal.getClass().getSimpleName() + " - " + v.getName());
        }

        return animals;
    }

    private static Enclosure[] createEnclosures() {
        Enclosure savanna = new Enclosure("Саванна", 500.0, "Травянистая равнина", 3);
        Enclosure reptileHouse = new Enclosure("Террариум", 50.0, "Тропический лес", 2);
        Enclosure elephantSanctuary = new Enclosure("Слоновий заповедник", 1000.0, "Лесная местность", 2);

        return new Enclosure[]{savanna, reptileHouse, elephantSanctuary};
    }

    private static void distributeAnimalsToEnclosures(Animal[] animals, Enclosure[] enclosures) {
        try {
            enclosures[0].addAnimal(animals[0]);
            enclosures[0].addAnimal(animals[3]);
            enclosures[1].addAnimal(animals[2]);
            enclosures[2].addAnimal(animals[1]);

            enclosures[0].addAnimal(animals[1]);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка при добавлении животного: " + e.getMessage());
        }
    }

    private static void displayAllEnclosures(Enclosure[] enclosures) {
        for (Enclosure enclosure : enclosures) {
            enclosure.displayAnimals();
        }
    }

    private static ZooStaff[] createStaff() {
        ZooKeeper keeper1 = new ZooKeeper("Иван Петров", 1001, 45000, "Саванна");
        ZooKeeper keeper2 = new ZooKeeper("Мария Сидорова", 1002, 42000, "Террариум");
        Veterinarian vet = new Veterinarian("Доктор Айболит", 2001, 60000, "Хищные млекопитающие");

        return new ZooStaff[]{keeper1, keeper2, vet};
    }

    private static void displayStaffInfo(ZooStaff[] staff) {
        for (ZooStaff employee : staff) {
            System.out.println(employee.getEmployeeInfo());
        }
    }

    private static void demonstratePolymorphism(Animal[] animals, ZooStaff[] staff) {
        System.out.println("\n5. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");

        System.out.println("\nа) Полиморфизм животных:");
        System.out.println("Один и тот же код (animal.makeSound()) для разных животных:");
        for (Animal animal : animals) {
            animal.makeSound();
        }

        System.out.println("\nб) Полиморфизм сотрудников:");
        System.out.println("Один и тот же код (employee.performDuties()) для разных сотрудников:");
        for (ZooEmployee employee : staff) {
            employee.performDuties();
        }

        System.out.println("\nв) Полиморфизм через общий интерфейс Animal:");
        List<Animal> animalList = List.of(animals);
        for (Animal animal : animalList) {
            System.out.print(animal.getClass().getSimpleName() + " говорит: ");
            animal.makeSound();
        }
    }

    private static void staffWorkRoutine(ZooStaff[] staff, Enclosure[] enclosures, Animal[] animals) {
        for (ZooStaff employee : staff) {
            if (employee instanceof ZooKeeper) {
                ZooKeeper keeper = (ZooKeeper) employee;
                System.out.println("\n--- " + keeper.getName() + " начинает работу ---");
                keeper.performDuties();

                for (Enclosure enclosure : enclosures) {
                    if (enclosure.getName().equals(keeper.getAssignedEnclosure())) {
                        keeper.feedAnimals(enclosure);
                        break;
                    }
                }
            } else if (employee instanceof Veterinarian) {
                Veterinarian vet = (Veterinarian) employee;
                System.out.println("\n--- " + vet.getName() + " начинает осмотр ---");
                vet.performDuties();

                for (Animal animal : animals) {
                    if (animal instanceof Vertebrate) {
                        vet.checkAnimalHealth((Vertebrate) animal);
                    }
                }
            }
        }

        System.out.println("\n--- Утренний обход зоопарка ---");
        for (Enclosure enclosure : enclosures) {
            enclosure.performMorningRoutine();
        }
    }

    private static void demonstrateEncapsulation() {
        System.out.println("а) Защита данных животных:");
        try {
            Lion testLion = new Lion("Тест", 5, 100, "коричневый", false);
            testLion.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Защита данных: " + e.getMessage());
        }

        System.out.println("\nб) Защита данных сотрудников:");
        try {
            ZooKeeper testKeeper = new ZooKeeper("Тест", 999, 30000, "Тестовый вольер");
            testKeeper.setSalary(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }

        System.out.println("\nв) Контролируемый доступ к вольерам:");
        Enclosure testEnclosure = new Enclosure("Тестовый", 100, "Лес", 1);
        testEnclosure.addAnimal(new Lion("Лео", 3, 150, "рыжий", false));

        try {
            testEnclosure.addAnimal(new Lion("Лео2", 4, 160, "черный", true));
        } catch (IllegalStateException e) {
            System.out.println("Контроль вместимости: " + e.getMessage());
        }

        System.out.println("\nг) Демонстрация корректной работы геттеров/сеттеров:");
        Elephant elephant = new Elephant("Слоня", 15, 3000, 0.8, 1.5);
        System.out.println("Исходные данные: " + elephant.getName() + ", вес: " + elephant.getWeight());
        elephant.setWeight(3100);
        elephant.setName("Большой Слоня");
        System.out.println("Обновленные данные: " + elephant.getName() + ", вес: " + elephant.getWeight());
    }
}