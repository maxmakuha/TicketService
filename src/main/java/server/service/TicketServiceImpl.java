package server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.dao.BusDAO;
import server.dao.BusDAOImpl;
import server.dao.OrganizationDAO;
import server.dao.OrganizationDAOImpl;
import server.dao.PassageDAO;
import server.dao.PassageDAOImpl;
import server.dao.PassangerDAO;
import server.dao.PassangerDAOImpl;
import server.dao.RouteDAO;
import server.dao.RouteDAOImpl;
import server.entities.Bus;
import server.entities.Organization;
import server.entities.Passage;
import server.entities.Passanger;
import server.entities.Route;

@SuppressWarnings("serial")
public class TicketServiceImpl extends UnicastRemoteObject implements TicketService {
	
	private BusDAO busDAO;
	private RouteDAO routeDAO;
	private PassageDAO passageDAO;
	private PassangerDAO passangerDAO;
	private OrganizationDAO organizationDAO;

	public TicketServiceImpl() throws RemoteException {
		busDAO = new BusDAOImpl();
		organizationDAO = new OrganizationDAOImpl();
		passageDAO = new PassageDAOImpl();
		passangerDAO = new PassangerDAOImpl();
		routeDAO = new RouteDAOImpl();
	}
	
	@Override
	public List<Bus> getAllBuses() throws RemoteException {
		return busDAO.getAllBuses();
	}
	
	@Override
	public List<Organization> getAllOrganizations() throws RemoteException{
		return organizationDAO.getAllOrganizations();	
	}

	@Override
	public List<Route> getAllRoutes() throws RemoteException {
		return routeDAO.getAllRoutes();
	}

	@Override
	public List<Passage> getAllPassages() throws RemoteException {
		return passageDAO.getAllPassages();
	}

	@Override
	public List<Passanger> getAllPassangers() throws RemoteException {
		return passangerDAO.getAllPassangers();
	}

	@Override
	public void addBus(Bus bus) throws RemoteException {
		busDAO.addBus(bus);
	}
}