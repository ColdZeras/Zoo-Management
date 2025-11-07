package staff;

import animals.Animal;
import infrastructure.Enclosure;

public class Zookeeper extends ZooStaff implements Staff {
    private String assignedZone;
    private int yearsOfExperience;
    
    public Zookeeper(String name, int employeeId, double salary, 
                    String assignedZone, int yearsOfExperience) {
        super(name, employeeId, salary, "Обслуживание животных");
        this.assignedZone = assignedZone;
        this.setYearsOfExperience(yearsOfExperience);
    }
    

    public String getAssignedZone() {
        return assignedZone;
    }
    
    public void setAssignedZone(String assignedZone) {
        this.assignedZone = assignedZone;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Опыт работы не может быть отрицательным");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    
  
    @Override
    public void work() {
        System.out.println(getName() + " начинает рабочий день смотрителя в зоне: " + assignedZone);
    }
    
    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(getName() + " тщательно чистит вольер " + enclosure.getName());
        System.out.println("Площадь уборки: " + enclosure.getArea() + "м²");
        System.out.println("Количество животных в вольере: " + enclosure.getCurrentAnimalCount());
        System.out.println("Уборка завершена!");
    }
    
    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + ", Зона ответственности: " + assignedZone + 
               ", Опыт работы: " + yearsOfExperience + " лет";
    }
    
 
    @Override
    public void performDuties() {
        System.out.println(getName() + " кормит животных и убирает в зоне " + assignedZone);
    }
    
   
    public void feedAnimalsInEnclosure(Enclosure enclosure) {
        System.out.println("\n=== Кормление животных в вольере " + enclosure.getName() + " ===");
        System.out.println("Смотритель " + getName() + " начинает кормление:");
        
        int animalCount = enclosure.getCurrentAnimalCount();
        if (animalCount == 0) {
            System.out.println("Вольер пуст, кормить некого");
            return;
        }
        
        System.out.println("Всего животных для кормления: " + animalCount);
        
        // Демонстрация полиморфизма: используем метод feed() для всех животных
        for (Animal animal : enclosure.getAnimals()) {
            System.out.print("Кормление: ");
            animal.feed(); // Полиморфный вызов - каждый тип животного кормится по-своему
        }
        
        System.out.println("Кормление всех животных завершено!");
    }
    
  
    public void performMorningRoutine(Enclosure enclosure) {
        System.out.println("\n=== Утренний обход смотрителя ===");
        work();
        cleanEnclosure(enclosure);
        feedAnimalsInEnclosure(enclosure);
        System.out.println("Утренний обход завершен!");
    }
    
    public void checkEnclosureSecurity(Enclosure enclosure) {
        System.out.println(getName() + " проверяет безопасность вольера " + enclosure.getName());
        System.out.println("Проверка ограждений, замков и систем безопасности...");
        System.out.println("Проверка безопасности завершена успешно!");
    }
}
