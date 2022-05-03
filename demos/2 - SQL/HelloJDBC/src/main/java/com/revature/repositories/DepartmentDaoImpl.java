package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import com.revature.models.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	private static Logger logger = Logger.getLogger(DepartmentDaoImpl.class);
	@Override
	public Department getDepartmentById(int id) {
		logger.info("In DAO layer: getting product by id...");
		Department dept = new Department();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM departments WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				dept.setDepartmentId(id);
				dept.setDepartmentName(rs.getString("name"));
				logger.debug(rs.getDouble("monthly_budget"));
				dept.setDepartmentMonthlyBudget(rs.getDouble("monthly_budget"));
			}

			logger.info("Department search by id was successful. " + dept);
		} catch (SQLException e) {
			logger.warn("Unable to execute SQL statement", e);
		}
		
		return dept;
	}

}
