package kz.iitu.employeesystem.dao;

import kz.iitu.employeesystem.mapper.SalaryMapper;
import kz.iitu.employeesystem.model.Employee;
import kz.iitu.employeesystem.model.SalariedEmployee;
import kz.iitu.employeesystem.model.SalaryPlusEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalariedDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<Employee> getSalaryEmp() {
        return jdbcTemplate.query("select * from salariedemployee", new SalaryMapper());
    }

    public List<Employee> getHourlyEmp() {
        return jdbcTemplate.query("select * from hourlyemployee", new SalaryMapper());
    }

    public List<Employee> getCommissionEmp() {
        return jdbcTemplate.query("select * from commissionemployee", new SalaryMapper());
    }

    public List<Employee> getSalaryPlusEmp() {
        return jdbcTemplate.query("select * from salaryplusemployee", new SalaryMapper());
    }

    public void increaseSalaryEmp(int percent, SalariedEmployee employee) {

        Double salary = employee.getSalary() * percent / 100 + employee.getSalary();

        jdbcTemplate.update("update salariedemployee set salary =" + salary +
                " where id = " + employee.getId());
    }

    public void increaseSalaryPlusEmp(int percent, SalaryPlusEmployee employee) {

        Double salary = employee.getSalary() * percent / 100 + employee.getSalary();

        jdbcTemplate.update("update salaryplusemployee set salary = " + salary +
                " where id = " + employee.getId());
    }

}
