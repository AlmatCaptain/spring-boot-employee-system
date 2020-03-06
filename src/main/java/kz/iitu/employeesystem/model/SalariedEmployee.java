package kz.iitu.employeesystem.model;

public class SalariedEmployee extends Employee {

    private Double salary;

    public SalariedEmployee(
            Long id,
            String name,
            Double salary
    ) {
        super(id, name);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "id=" + getId() +
                ", name='" + getName() +
                ", salary=" + salary +
                '}';
    }
}
