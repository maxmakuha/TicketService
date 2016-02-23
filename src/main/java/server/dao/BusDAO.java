package server.dao;

import java.util.List;

import server.entities.Bus;

public interface BusDAO {
	
	public void addBus(Bus bus);
	
	public List<Bus> getAllBuses();
}
