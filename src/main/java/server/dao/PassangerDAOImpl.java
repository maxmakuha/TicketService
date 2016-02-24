package server.dao;

import java.util.ArrayList;
import java.util.List;

import server.entities.Passanger;

public class PassangerDAOImpl implements PassangerDAO {

	private static ArrayList<Passanger> passangers;
	
	@Override
	public List<Passanger> getAllPassangers() {
		passangers = new ArrayList<Passanger>();
		passangers.add(new Passanger(1, "Makukha Max", "KB123", 1));
		passangers.add(new Passanger(2, "Lysenko Vlad", "KB456", 2));
		passangers.add(new Passanger(3, "Kucyk Vasya", "KB789", 3));
		passangers.add(new Passanger(4, "Malykh Yana", "KB333", 4));
		passangers.add(new Passanger(5, "Krut Kostya", "KB233", 5));
		return passangers;
	}
}
