package client.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import client.TicketClient;

@SuppressWarnings("serial")
public class AdminForm extends JFrame implements ActionListener {

	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JTextArea text;
	JTextArea text2;
	JTextArea text3;
	JTextArea text4;
	JTextArea text5;
	JTable allBuses;
	JTable allRoutes;
	JTable allPassages;
	JTable allPassangers;
	JTable allOrganizations;

	JButton addBus;
	JButton removeBus;
	JButton changeBus;
	JButton addRoute;
	JButton removeRoute;
	JButton changeRoute;
	JButton addPassage;
	JButton removePassage;
	JButton changePassage;

	public AdminForm() {
		super("Administrator panel");
		setBounds(0, 0, 1000, 600);
		JTabbedPane tabby = new JTabbedPane();

		panel1 = new JPanel(new BorderLayout());
		allBuses();

		addBus = new JButton("Додати автобус");
		addBus.addActionListener(this);

		removeBus = new JButton("Видалити автобус");
		removeBus.addActionListener(this);

		changeBus = new JButton("Редагувати інформацію про автобус");
		changeBus.addActionListener(this);

		JPanel newPanel = new JPanel();
		newPanel.add(addBus);
		newPanel.add(removeBus);
		newPanel.add(changeBus);

		panel1.add(newPanel, BorderLayout.PAGE_END);

		panel2 = new JPanel(new BorderLayout());
		allRoutes();

		panel3 = new JPanel(new BorderLayout());
		allPassages();

		panel4 = new JPanel(new BorderLayout());
		allPassangers();

		panel5 = new JPanel(new BorderLayout());
		allOrganizations();

		addRoute = new JButton("Додати маршрут");
		addRoute.addActionListener(this);

		removeRoute = new JButton("Видалити маршрут");
		removeRoute.addActionListener(this);

		changeRoute = new JButton("Редагувати інформацію про маршрут");
		changeRoute.addActionListener(this);

		addPassage = new JButton("Додати рейс");
		addPassage.addActionListener(this);

		removePassage = new JButton("Видалити рейс");
		removePassage.addActionListener(this);

		changePassage = new JButton("Редагувати інформацію про рейс");
		changePassage.addActionListener(this);

		JPanel newPanel2 = new JPanel();
		newPanel2.add(addRoute);
		newPanel2.add(removeRoute);
		newPanel2.add(changeRoute);
		panel2.add(newPanel2, BorderLayout.PAGE_END);

		JPanel newPanel3 = new JPanel();
		newPanel3.add(addPassage);
		newPanel3.add(removePassage);
		newPanel3.add(changePassage);
		panel3.add(newPanel3, BorderLayout.PAGE_END);

		JPanel newPanel4 = new JPanel();
		panel4.add(newPanel4, BorderLayout.PAGE_END);

		JPanel newPanel5 = new JPanel();
		panel5.add(newPanel5, BorderLayout.PAGE_END);

		tabby.addTab("Автобуси", panel1);
		tabby.addTab("Маршрути", panel2);
		tabby.addTab("Рейси", panel3);
		tabby.addTab("Пасажири", panel4);
		tabby.addTab("Організації", panel5);
		add(tabby);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void allBuses() {
		allBuses = new JTable();
		allBuses.setPreferredScrollableViewportSize(new Dimension(700,100));
		allBuses.setSize(800, 300);
		
		JScrollPane allBusesPane = new JScrollPane(allBuses);
		allBusesPane.setPreferredSize(new Dimension(700,100));
		allBusesPane.setSize(800, 300);

		panel1.add(allBusesPane, BorderLayout.CENTER);
	}
	
	private void allRoutes() {
		allRoutes = new JTable();
		allRoutes.setPreferredScrollableViewportSize(new Dimension(700,100));
		allRoutes.setSize(800, 300);
		
		JScrollPane allRoutesPane = new JScrollPane(allRoutes);
		allRoutesPane.setPreferredSize(new Dimension(700,100));
		allRoutesPane.setSize(800, 300);

		panel2.add(allRoutesPane, BorderLayout.CENTER);
	}
	
	private void allPassages() {
		allPassages = new JTable();
		allPassages.setPreferredScrollableViewportSize(new Dimension(700,100));
		allPassages.setSize(800, 300);
		
		JScrollPane allPassagesPane = new JScrollPane(allPassages);
		allPassagesPane.setPreferredSize(new Dimension(700,100));
		allPassagesPane.setSize(800, 300);

		panel3.add(allPassagesPane, BorderLayout.CENTER);
	}
	
	private void allPassangers() {
		allPassangers = new JTable();
		allPassangers.setPreferredScrollableViewportSize(new Dimension(700,100));
		allPassangers.setSize(800, 300);
		
		JScrollPane allPassangersPane = new JScrollPane(allPassangers);
		allPassangersPane.setPreferredSize(new Dimension(700,100));
		allPassangersPane.setSize(800, 300);

		panel4.add(allPassangersPane, BorderLayout.CENTER);
	}
	
	private void allOrganizations() {
		allOrganizations = new JTable();
		allOrganizations.setPreferredScrollableViewportSize(new Dimension(700,100));
		allOrganizations.setSize(800, 300);
		
		JScrollPane allOrganizationsPane = new JScrollPane(allOrganizations);
		allOrganizationsPane.setPreferredSize(new Dimension(700,100));
		allOrganizationsPane.setSize(800, 300);

		panel5.add(allOrganizationsPane, BorderLayout.CENTER);
	}
	
	public JTable getAllBusesTable(){
		return this.allBuses;
	}
	
	public JTable getAllRoutesTable(){
		return this.allRoutes;
	}
	
	public JTable getAllPassagesTable(){
		return this.allPassages;
	}
	
	public JTable getAllPassangersTable(){
		return this.allPassangers;
	}
	
	public JTable getAllOrganizationsTable(){
		return this.allOrganizations;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBus) {
			try {
				System.out.println(TicketClient.tickservice.getAllOrganizations());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	}
}