package staff;

import animals.Animal;
import infrastructure.Enclosure;

public class ZooKeeper extends ZooStaff {
    private String assignedEnclosure;

    public ZooKeeper(String name, int employeeId, double salary, String assignedEnclosure) {
        super(name, employeeId, salary, "Обслуживание животных");
        this.assignedEnclosure = assignedEnclosure;
    }

    public String getAssignedEnclosure() {
        return assignedEnclosure;
    }

    public void setAssignedEnclosure(String assignedEnclosure) {
        this.assignedEnclosure = assignedEnclosure;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " кормит животных и убирает в вольере " + assignedEnclosure);
    }

    public void feedAnimals(Enclosure enclosure) {
        System.out.println("\n" + getName() + " начинает кормить животных в вольере:");
        for (Animal animal : enclosure.getAnimals()) {
            animal.feed();
        }
    }
}