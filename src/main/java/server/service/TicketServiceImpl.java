package server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.dao.BusDAO;
import server.dao.BusDAOImpl;
import server.dao.OrganizationDAO;
import server.dao.OrganizationDAOImpl;
import server.entities.Bus;
import server.entities.Organization;

@SuppressWarnings("serial")
public class TicketServiceImpl extends UnicastRemoteObject implements TicketService {
	
	private OrganizationDAO organizationDAO;
	private BusDAO busDAO;

	public TicketServiceImpl() throws RemoteException {
		busDAO = new BusDAOImpl();
		organizationDAO = new OrganizationDAOImpl();
	}
	
	@Override
	public List<Bus> getAllBuses() throws RemoteException {
		return busDAO.getAllBuses();
	}
	
	@Override
	public List<Organization> getAllOrganizations() throws RemoteException{
		return organizationDAO.getAllOrganizations();	
	}
}