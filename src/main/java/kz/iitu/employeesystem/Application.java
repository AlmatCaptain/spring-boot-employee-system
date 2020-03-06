package kz.iitu.employeesystem;

import kz.iitu.employeesystem.dao.SalariedDao;
import kz.iitu.employeesystem.model.*;
import org.springframework.context.ApplicationContext;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Application {

    public SalariedDao salariedDao;
    private Scanner scanner = new Scanner(System.in);
    private List<Employee> salariedList;
    private List<Employee> salaryPlusList;


    public void runApp(ApplicationContext context) throws SQLException {
        salariedDao = context.getBean("salariedDao", SalariedDao.class);

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
                    salariedList = salariedDao.getSalaryEmp();
                    for (Employee e : salariedList) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    List<Employee> hourlyList = salariedDao.getHourlyEmp();
                    for (Employee e : hourlyList)
                        System.out.println(e + " Total payment: " + calcHourly(e));

                    break;
                case 3:
                    List<Employee> commissionList = salariedDao.getCommissionEmp();
                    for (Employee e : commissionList)
                        System.out.println(e + " Total payment: " + calcCommission(e));

                    break;
                case 4:
                    salaryPlusList = salariedDao.getSalaryPlusEmp();

                    for (Employee e : salaryPlusList) {
                        System.out.println(e + " Total salary: " + calcSalaryPlus(e));
                    }
                    break;
                case 5:
                    System.out.println("How much percentage do you want to increase ?");
                    int percent = scanner.nextInt();

                    for (Employee e : salariedList) {
                        salariedDao.increaseSalaryEmp(percent, (SalariedEmployee) e);
                    }
                    break;
                case 6:
                    System.out.println("How much percentage do you want to increase ?");
                    percent = scanner.nextInt();

                    for (Employee e : salaryPlusList) {
                        salariedDao.increaseSalaryPlusEmp(percent, (SalaryPlusEmployee) e);
                    }
                    break;
            }
        }
    }

    private Double calcHourly(Employee employee) {

        Double salary = 0.0;
        HourlyEmployee e = (HourlyEmployee) employee;


        if (e.getHours() > 40) {
            for (int i = 0; i < e.getHours() - 40; i++) {
                salary += 1.5 * e.getPayment();
            }
            salary += e.getPayment() * 40;
        } else {
            salary = e.getPayment() * e.getHours();
        }

        return salary;

    }

    private Double calcCommission(Employee employee) {

        Double salary = 0.0;
        CommissionEmployee e = (CommissionEmployee) employee;

        for (int i = 0; i < e.getSales(); i++) {
            salary += e.getPercentage() * 20000 / 100;
        }

        return salary;
    }

    private Double calcSalaryPlus(Employee employee) {

        SalaryPlusEmployee e = (SalaryPlusEmployee) employee;
        Double salary = e.getSalary();

        for (int i = 0; i < e.getSales(); i++) {
            salary += e.getPercentage() * 20000 / 100;
        }

        return salary;
    }
}
