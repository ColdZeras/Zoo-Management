package staff;

import animals.Animal;
import animals.Vertebrate;
import infrastructure.Enclosure;

public class Veterinarian extends ZooStaff implements Staff {
    private String licenseNumber;
    private double salary;
    private String specialization;
    
    public Veterinarian(String name, int employeeId, double salary, 
                       String specialization, String licenseNumber) {
        super(name, employeeId, salary, "Ветеринария");
        this.setLicenseNumber(licenseNumber);
        this.specialization = specialization;
    }
    
    // Инкапсуляция: приватные поля с геттерами/сеттерами
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер лицензии не может быть пустым");
        }
        this.licenseNumber = licenseNumber;
    }
    
    @Override
    public double getSalary() {
        return salary;
    }
    
    @Override
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    // Реализация методов интерфейса Staff
    @Override
    public void work() {
        System.out.println(getName() + " начинает рабочий день ветеринара");
    }
    
    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(getName() + " проводит санитарную обработку вольера " + enclosure.getName());
    }
    
    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + ", Специализация: " + specialization + 
               ", Лицензия: " + licenseNumber;
    }
    
    // Методы из ZooEmployee (оставляем для совместимости)
    @Override
    public void performDuties() {
        System.out.println(getName() + " проводит медицинский осмотр животных");
    }
    
    // Демонстрация полиморфизма при взаимодействии с любым Animal
    public void examineAnimal(Animal animal) {
        System.out.println("\n=== Ветеринарный осмотр ===");
        System.out.println("Ветеринар " + getName() + " осматривает животное:");
        
        // Полиморфизм: работаем с интерфейсом Animal, не зная конкретного типа
        if (animal instanceof Vertebrate) {
            Vertebrate vertebrate = (Vertebrate) animal;
            System.out.println("Животное: " + vertebrate.getName());
            System.out.println("Текущее состояние здоровья: " + vertebrate.getHealthStatus());
            
            // Проводим различные проверки в зависимости от типа животного
            performHealthCheck(animal);
            
            // Обновляем статус здоровья
            vertebrate.setHealthStatus("Осмотрено и здорово");
            System.out.println("Обновленное состояние: " + vertebrate.getHealthStatus());
        }
    }
    
    // Полиморфный метод для различных типов животных
    private void performHealthCheck(Animal animal) {
        System.out.println("Проводится медицинский осмотр...");
        
        if (animal instanceof Lion) {
            Lion lion = (Lion) animal;
            System.out.println("Осмотр льва: проверка зубов, гривы, проверка на наличие травм");
            System.out.println("Цвет гривы: " + lion.getManeColor() + ", Вожак стаи: " + lion.isAlpha());
        } else if (animal instanceof Elephant) {
            Elephant elephant = (Elephant) animal;
            System.out.println("Осмотр слона: проверка бивней, хобота, ушей");
System.out.println("Длина бивней: " + elephant.getTuskLength() + "м");
        } else if (animal instanceof Snake) {
            Snake snake = (Snake) animal;
            System.out.println("Осмотр змеи: проверка кожи, зубов, проверка ядовитости");
            System.out.println("Ядовитая: " + snake.isVenomous() + ", Длина: " + snake.getLength() + "м");
        } else {
            System.out.println("Общий медицинский осмотр животного");
        }
        
        System.out.println("Медицинский осмотр завершен успешно!");
    }
    
    // Метод для массового осмотра всех животных в вольере
    public void examineAllAnimalsInEnclosure(Enclosure enclosure) {
        System.out.println("\n=== Массовый ветеринарный осмотр вольера " + enclosure.getName() + " ===");
        for (Animal animal : enclosure.getAnimals()) {
            examineAnimal(animal);
        }
    }
}
