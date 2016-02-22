package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entities.Bus;

public class BusDAOImpl implements BusDAO {

	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://solrwindow.cloudapp.net:3307/ticket_service?"
			+ "user=next&password=next";

	private static ArrayList<Bus> buses;

	@Override
	public List<Bus> getAllBuses() {
		buses = new ArrayList<Bus>();
		try (Connection conn = DriverManager.getConnection(MYSQL_URL)) {
			PreparedStatement statement = null;
			ResultSet rs = null;
			try {
				statement = conn.prepareStatement("SELECT * from ticket_service.bus");
				rs = statement.executeQuery();
				while (rs.next()) {
					buses.add(new Bus(rs.getInt("id"), rs.getString("mark"), rs.getString("owner"),
							rs.getString("class"), rs.getInt("places_amount")));
				}
			} catch (SQLException se) {
				System.out.println("SQL Error: " + se);
			}
		} catch (SQLException se) {
			System.out.println("Connection failed: " + se);
		}
		return buses;
	}
}
