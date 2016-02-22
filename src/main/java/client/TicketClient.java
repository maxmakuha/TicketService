package client;

import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.naming.NamingException;
import client.forms.AdminForm;
import client.forms.BusTable;
import server.service.TicketService;

public class TicketClient {
	
	private static AdminForm adminForm;
	
	public static TicketService tickservice;

	public static final String SERVER_NAME = "Server";

	public static void main(String[] args)
			throws RemoteException, NamingException, MalformedURLException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost", 8888);

		tickservice = (TicketService) registry.lookup(SERVER_NAME);
		
		adminForm = new AdminForm();
		adminForm.getAllBusesTable().setModel(new BusTable(tickservice.getAllBuses()));
	}
}