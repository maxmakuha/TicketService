package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.entities.Organization;

public class OrganizationDAOImpl implements OrganizationDAO {
	
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://solrwindow.cloudapp.net:3307/ticket_service?"
			+ "user=next&password=next";

	private static ArrayList<Organization> organizations;

	@Override
	public List<Organization> getAllOrganizations() {
		organizations = new ArrayList<Organization>();
		try (Connection conn = DriverManager.getConnection(MYSQL_URL)) {
			PreparedStatement statement = null;
			ResultSet rs = null;
			try {
				statement = conn.prepareStatement("SELECT * from ticket_service.organizations");
				rs = statement.executeQuery();
				while (rs.next()) {
					organizations.add(new Organization(rs.getInt("id"), rs.getString("name")));
				}
			} catch (SQLException se) {
				System.out.println("SQL Error: " + se);
			}
		} catch (SQLException se) {
			System.out.println("Connection failed: " + se);
		}
		return organizations;
	}
}