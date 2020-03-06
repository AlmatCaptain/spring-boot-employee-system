package kz.iitu.employeesystem.model;

public class HourlyEmployee extends Employee {

    private Integer hours;
    private Double payment;

    public HourlyEmployee(
            Long id,
            String name,
            Integer hours,
            Double payment
    ) {
        super(id, name);
        this.hours = hours;
        this.payment = payment;
    }

    public Integer getHours() {
        return hours;
    }

    public Double getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "id=" + getId() +
                ", name='" + getName() +
                ", hours=" + hours +
                ", payment=" + payment +
                '}';
    }
}
