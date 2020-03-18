package kz.iitu.employeesystem;

import kz.iitu.employeesystem.Service.EmployeeService;
import kz.iitu.employeesystem.model.Employee;
import kz.iitu.employeesystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeSystemApplication {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeRepository repository) {
        return (args) -> {
            Scanner scanner = new Scanner(System.in);
            List<String> salaryList = new ArrayList<>();

            employeeService.createEmployee(new Employee("Madi", 150000.0, 0.0, 0, 0, 0, Employee.EmployeeType.SALARIED));
            employeeService.createEmployee(new Employee("Bakdaulet", 10000.0, 0.0, 0, 0, 0, Employee.EmployeeType.SALARIED));
            employeeService.createEmployee(new Employee("Zhaskanat", 11000.0, 0.0, 0, 0, 0, Employee.EmployeeType.SALARIED));

            employeeService.createEmployee(new Employee("Zhandos", 50000.0, 2000.0, 50, 0, 0, Employee.EmployeeType.HOURLY));
            employeeService.createEmployee(new Employee("Zhasulan", 10000.0, 3000.0, 30, 0, 0, Employee.EmployeeType.HOURLY));

            employeeService.createEmployee(new Employee("Aruzhan", 0.0, 0.0, 0, 0.3f, 25, Employee.EmployeeType.COMMISION));

            employeeService.createEmployee(new Employee("Alina", 120000.0, 0.0, 0, 0.1f, 10, Employee.EmployeeType.SALARIED_COMMISION));


            while (true) {

                System.out.println(
                        "1. Calculate salary for Salaried Employee \n" +
                                "2. Calculate salary for Hourly Employee \n" +
                                "3. Calculate salary for Commission Employee\n" +
                                "4. Calculate salary for Salary plus Commission Employee\n" +
                                "5. Increase base salary for Salaried Employees\n" +
                                "6. Increase base salary for Salary plus Commission Employees"
                );

                int key = scanner.nextInt();


                switch (key) {
                    case 1:
                        salaryList = employeeService.getTotalSalaryByType(Employee.EmployeeType.SALARIED);
                        showResult(salaryList);
                        break;
                    case 2:
                        salaryList = employeeService.getTotalSalaryByType(Employee.EmployeeType.HOURLY);
                        showResult(salaryList);
                        break;
                    case 3:
                        salaryList = employeeService.getTotalSalaryByType(Employee.EmployeeType.COMMISION);
                        showResult(salaryList);
                        break;
                    case 4:
                        salaryList = employeeService.getTotalSalaryByType(Employee.EmployeeType.SALARIED_COMMISION);
                        showResult(salaryList);
                        break;
                    case 5:
                        System.out.println("How much percentage do you want to increase ?");
                        int percent = scanner.nextInt();
                        employeeService.increaseFixedSalaryByType(Employee.EmployeeType.SALARIED, percent);
                        break;
                    case 6:
                        System.out.println("How much percentage do you want to increase ?");
                        percent = scanner.nextInt();
                        employeeService.increaseFixedSalaryByType(Employee.EmployeeType.SALARIED_COMMISION, percent);
                        break;
                }
            }
        };


    }
    private void showResult(List<String> salaryList) {
        for(String s: salaryList)
            System.out.println(s);
    }

}
