package server.service;

import java.rmi.*;
import java.util.List;

import server.entities.Bus;
import server.entities.Organization;

public interface TicketService extends Remote {
	
	public List<Bus> getAllBuses() throws RemoteException;
	
	public List<Organization> getAllOrganizations() throws RemoteException;
}
