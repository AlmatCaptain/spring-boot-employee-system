package kz.iitu.employeesystem.event;

import kz.iitu.employeesystem.model.Employee;
import org.springframework.context.ApplicationEvent;

public class SalaryIncreseEvent extends ApplicationEvent {

    private Employee employee;

    public SalaryIncreseEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
