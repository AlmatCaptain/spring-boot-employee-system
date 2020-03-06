package kz.iitu.employeesystem.model;

public class SalaryPlusEmployee extends Employee {

    private Double salary;
    private Integer sales;
    private Double percentage;

    public SalaryPlusEmployee(
            Long id,
            String name,
            Double salary,
            Integer sales,
            Double percentage
    ){
        super(id, name);
        this.salary = salary;
        this.sales = sales;
        this.percentage = percentage;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getSales() {
        return sales;
    }

    public Double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "SalaryPlusEmployee{" +
                "id=" + getId() +
                ", name='" + getName() +
                ", salary=" + salary +
                ", sales=" + sales +
                ", percentage=" + percentage +
                '}';
    }
}
