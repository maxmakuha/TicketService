package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.forms.PassageTable;
import client.forms.PassangerForm;
import client.forms.RouteTable;
import server.service.TicketService;

public class PassangerClient {

	public static PassangerForm passangerForm;

	public static TicketService tickservice;

	public static final String SERVER_NAME = "Server";

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost", 8888);

		tickservice = (TicketService) registry.lookup(SERVER_NAME);

		passangerForm = new PassangerForm();
		passangerForm.getAllRoutesTable().setModel(new RouteTable(tickservice.getAllRoutes()));
		passangerForm.getAllPassagesTable().setModel(new PassageTable(tickservice.getAllPassages()));
	}
}