package staff;

import animals.Vertebrate;

public class Veterinarian extends ZooStaff {
    private String specialization;

    public Veterinarian(String name, int employeeId, double salary, String specialization) {
        super(name, employeeId, salary, "Ветеринария");
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " проводит медицинский осмотр животных");
    }

    public void checkAnimalHealth(Vertebrate animal) {
        System.out.println("Ветеринар " + getName() + " осматривает " + animal.getName());
        System.out.println("Состояние здоровья: " + animal.getHealthStatus());
    }

    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + ", Специализация: " + specialization;
    }
}