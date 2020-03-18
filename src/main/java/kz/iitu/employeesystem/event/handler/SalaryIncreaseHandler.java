package kz.iitu.employeesystem.event.handler;

import kz.iitu.employeesystem.event.SalaryIncreseEvent;
import kz.iitu.employeesystem.model.Employee;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryIncreaseHandler implements ApplicationListener<SalaryIncreseEvent> {
    @Override
    public void onApplicationEvent(SalaryIncreseEvent salaryIncreseEvent) {
        Employee e = salaryIncreseEvent.getEmployee();
        System.out.println("Salary incresed for type: " + e.getEmplType() + ", name: " + e.getName());
    }
}
