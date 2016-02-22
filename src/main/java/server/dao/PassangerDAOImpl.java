package server.dao;

import java.util.ArrayList;
import java.util.List;

import server.entities.Passanger;

public class PassangerDAOImpl implements PassangerDAO {

	private static ArrayList<Passanger> passangers;
	
	@Override
	public List<Passanger> getAllPassangers() {
		passangers = new ArrayList<Passanger>();
		passangers.add(new Passanger(3, "Test", "KB123", 2));
		return passangers;
	}
}
