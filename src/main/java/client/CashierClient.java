package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.forms.CashierForm;
import client.forms.OrganizationTable;
import client.forms.PassageTable;
import client.forms.PassangerTable;
import client.forms.RouteTable;
import server.service.TicketService;

public class CashierClient {

	public static CashierForm cashierForm;

	public static TicketService tickservice;

	public static final String SERVER_NAME = "Server";

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost", 8888);

		tickservice = (TicketService) registry.lookup(SERVER_NAME);

		cashierForm = new CashierForm();
		cashierForm.getAllRoutesTable().setModel(new RouteTable(tickservice.getAllRoutes()));
		cashierForm.getAllPassagesTable().setModel(new PassageTable(tickservice.getAllPassages()));
		cashierForm.getAllPassangersTable().setModel(new PassangerTable(tickservice.getAllPassangers()));
		cashierForm.getAllOrganizationsTable().setModel(new OrganizationTable(tickservice.getAllOrganizations()));
	}
}