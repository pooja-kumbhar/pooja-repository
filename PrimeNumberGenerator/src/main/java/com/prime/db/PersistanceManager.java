package com.prime.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prime.beans.PrimeBean;
import com.prime.main.Main;

/**
 * This class is for creating database connection,inserting rows in to database
 * and to print the result.
 * 
 * @author Pooja Kumbhar
 *
 */
public class PersistanceManager {
	Connection con = null;
	PrimeBean primeBean = null;

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public PersistanceManager(PrimeBean primeBean) {
		this.primeBean = primeBean;
	}

	/**
	 * This method create the connection to the HSQLDB. It is using in memory
	 * database
	 */
	public void createConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb;sql.syntax_mys=true", "sa", "");
			logger.info("Database connection establish sucessfully.");
		} catch (Exception e) {
			logger.error("ERROR: failed to load HSQLDB JDBC driver.", e.getMessage());
			return;
		}
	}

	/**
	 * This method is use to insert the data to the table name prime_tbl.
	 * 
	 * @throws SQLException
	 */
	public void insert() throws SQLException {
		PreparedStatement stmt = con.prepareStatement(
				"insert into prime_tbl(start_range,end_range,algorithm_used,result,count, time_elapsed) values (?,?,?,?,?,?)");
		stmt.setLong(1, primeBean.getStartRange());
		stmt.setLong(2, primeBean.getEndRange());
		stmt.setString(3, primeBean.getStratergy());
		stmt.setString(4, primeBean.getPrimeNumbers().toString());
		stmt.setLong(5, primeBean.getCount());
		stmt.setLong(6, primeBean.getExecutionTime());
		stmt.executeUpdate();
		logger.info("Row inserted sucessfully.");
	}

	/**
	 * This method is use to get data from table.
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public PrimeBean getResult(int id) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("select * from prime_tbl where id =?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			String primeNumbers = rs.getString(5);
			String[] split = primeNumbers.split(", ");
			split[0] = split[0].replace("[", "");
			split[0].trim();
			split[split.length - 1] = split[split.length - 1].replace("]", "");
			split[split.length - 1].trim();
			Long[] results = new Long[split.length];
			for (int i = 0; i < split.length; i++) {
				results[i] = Long.valueOf(split[i]);
			}
			return new PrimeBean(rs.getLong(2), rs.getLong(3), rs.getString(4), Arrays.asList(results), rs.getLong(6),
					rs.getLong(7));
		}
		return null;
	}

	/**
	 * This method check for the table if already exists and if not then it
	 * create the new table in database.
	 * 
	 * @throws SQLException
	 */
	public void store() throws SQLException {
		createConnection();
		con.createStatement()
				.executeUpdate(" CREATE TABLE IF NOT EXISTS prime_tbl (id INTEGER IDENTITY PRIMARY KEY,"
						+ "start_range BIGINT NOT NULL," + "end_range BIGINT NOT NULL, " + "algorithm_used VARCHAR(50),"
						+ "result LONGTEXT NOT NULL," + "count INT NOT NULL," + "time_elapsed BIGINT NOT NULL,"
						+ "stamp TIMESTAMP);");
		logger.info("Table is created.");
		insert();
		closeConnection();
	}

	/**
	 * This method close the connection to the database.
	 * @throws SQLException
	 */
	private void closeConnection() throws SQLException {
		con.close();
	}

}
