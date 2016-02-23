package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import client.forms.AdminForm;
import client.forms.BusTable;
import client.forms.OrganizationTable;
import client.forms.PassageTable;
import client.forms.PassangerTable;
import client.forms.RouteTable;
import server.service.TicketService;

public class TicketClient {

	public static AdminForm adminForm;

	public static TicketService tickservice;

	public static final String SERVER_NAME = "Server";

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost", 8888);

		tickservice = (TicketService) registry.lookup(SERVER_NAME);

		adminForm = new AdminForm();
		adminForm.getAllBusesTable().setModel(new BusTable(tickservice.getAllBuses()));
		adminForm.getAllRoutesTable().setModel(new RouteTable(tickservice.getAllRoutes()));
		adminForm.getAllPassagesTable().setModel(new PassageTable(tickservice.getAllPassages()));
		adminForm.getAllPassangersTable().setModel(new PassangerTable(tickservice.getAllPassangers()));
		adminForm.getAllOrganizationsTable().setModel(new OrganizationTable(tickservice.getAllOrganizations()));
	}
}