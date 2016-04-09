package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import java.awt.Font;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.forms.CashierForm;
import client.forms.OrganizationTable;
import client.forms.PassageTable;
import client.forms.PassangerTable;
import client.forms.RouteTable;
import server.entities.Organization;
import server.entities.Passage;
import server.entities.Passanger;
import server.entities.Route;
import server.service.TicketService;

public class CashierClient {

	public static CashierForm cashierForm;

	public static TicketService tickservice;

	public static final String SERVER_NAME = "Server";

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry("localhost", 8888);

		tickservice = (TicketService) registry.lookup(SERVER_NAME);

		FontUIResource f = new FontUIResource(new Font("Georgia", 0, 15));
		Enumeration<Object> keys = UIManager.getDefaults().keys();
				while (keys.hasMoreElements()) {
					Object key = keys.nextElement();
					Object value = UIManager.get(key);
					if (value instanceof FontUIResource) {
						FontUIResource orig = (FontUIResource) value;
						Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
						UIManager.put(key, new FontUIResource(font));
					}
				}
		
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//		} catch (Exception e) {
//		}
		
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
		}
		
		List<Route> routes = tickservice.getAllRoutes();
		List<Passage> passages = tickservice.getAllPassages();
		List<Passanger> passangers = tickservice.getAllPassangers();
		List<Organization> organizations = tickservice.getAllOrganizations();
		cashierForm = new CashierForm(routes, passages, passangers, organizations);
	}
}