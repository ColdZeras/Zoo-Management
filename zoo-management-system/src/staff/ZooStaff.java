package staff;

public abstract class ZooStaff implements ZooEmployee {
    private String name;
    private int employeeId;
    private double salary;
    private String department;

    public ZooStaff(String name, int employeeId, double salary, String department) {
        this.setName(name);
        this.setEmployeeId(employeeId);
        this.setSalary(salary);
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пустым");
        }
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("ID сотрудника должен быть положительным");
        }
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getEmployeeInfo() {
        return "Сотрудник: " + name + ", ID: " + employeeId +
                ", Отдел: " + department + ", Зарплата: " + salary;
    }

    public abstract void performDuties();
}