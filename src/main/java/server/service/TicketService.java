package server.service;

import java.rmi.*;
import java.util.List;

import server.entities.Bus;
import server.entities.Organization;
import server.entities.Passage;
import server.entities.Passanger;
import server.entities.Route;

public interface TicketService extends Remote {
	
	public List<Bus> getAllBuses() throws RemoteException;
	
	public List<Route> getAllRoutes() throws RemoteException;
	
	public List<Passage> getAllPassages() throws RemoteException;
	
	public List<Passanger> getAllPassangers() throws RemoteException;
	
	public List<Organization> getAllOrganizations() throws RemoteException;
	
}
