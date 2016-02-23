package server;

import server.service.TicketService;
import server.service.TicketServiceImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TicketServer {

	private static final String SERVER_NAME = "Server";

	private String port;

	public TicketServer(String port) {
		this.port = port;
	}

	public void runServer() throws IllegalArgumentException, NotBoundException, RemoteException {
		TicketService ticketImpl = new TicketServiceImpl();
		Registry registry = LocateRegistry.createRegistry(Integer.parseInt(port, 10));
		registry.rebind(SERVER_NAME, ticketImpl);
	}

	public static void main(String[] args) throws RemoteException, IllegalArgumentException, NotBoundException {

		TicketServer server = new TicketServer("8888");
		server.runServer();
		System.out.println("Server started on port 8888");
	}
}