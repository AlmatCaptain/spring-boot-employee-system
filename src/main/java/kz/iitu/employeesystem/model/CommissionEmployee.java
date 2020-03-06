package kz.iitu.employeesystem.model;

public class CommissionEmployee extends Employee {

    private Integer sales;
    private Double percentage;

    public CommissionEmployee(
            Long id,
            String name,
            Integer sales,
            Double percentage
    ) {
        super(id, name);
        this.sales = sales;
        this.percentage = percentage;
    }

    public Integer getSales() {
        return sales;
    }

    public Double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "id=" + getId() +
                ", name='" + getName() +
                ", sales=" + sales +
                ", percentage=" + percentage +
                '}';
    }
}
