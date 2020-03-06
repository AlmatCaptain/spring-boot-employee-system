package kz.iitu.employeesystem.mapper;

import kz.iitu.employeesystem.model.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryMapper implements RowMapper<Employee> {

    @Nullable
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        switch (rs.getMetaData().getTableName(1)) {
            case "salariedemployee":
                SalariedEmployee employee = new SalariedEmployee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                );
                System.out.println(employee);
                return employee;
            case "hourlyemployee":
                HourlyEmployee hourlyEmployee = new HourlyEmployee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("hours"),
                        rs.getDouble("payment")
                );

                return hourlyEmployee;
            case "commissionemployee":
                CommissionEmployee commissionEmployee = new CommissionEmployee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("sales"),
                        rs.getDouble("percentage")
                );
                return commissionEmployee;
            case "salaryplusemployee":
                SalaryPlusEmployee salaryPlusEmployee = new SalaryPlusEmployee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getInt("sales"),
                        rs.getDouble("percentage")
                );
                return salaryPlusEmployee;
        }

        return null;
    }
}
