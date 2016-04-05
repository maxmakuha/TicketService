package client.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;

import server.entities.Bus;
import server.entities.Passage;
import server.entities.Route;

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
	JButton showPlacesButton;

	public AdminForm() {
		super("Administrator panel");
		setBounds(0, 0, 1000, 600);

		JTabbedPane tabby = new JTabbedPane();

		panel1 = new JPanel(new BorderLayout());
		try {
			allBuses();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		try {
			allRoutes();
		} catch (IOException e) {
			e.printStackTrace();
		}

		panel3 = new JPanel(new BorderLayout());
		try {
			allPassages();
		} catch (IOException e) {
			e.printStackTrace();
		}

		panel4 = new JPanel(new BorderLayout());
		try {
			allPassangers();
		} catch (IOException e) {
			e.printStackTrace();
		}

		panel5 = new JPanel(new BorderLayout());
		try {
			allOrganizations();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

		showPlacesButton = new JButton("Показати місця");
		showPlacesButton.addActionListener(this);

		JPanel newPanel2 = new JPanel();
		newPanel2.add(addRoute);
		newPanel2.add(removeRoute);
		newPanel2.add(changeRoute);
		panel2.add(newPanel2, BorderLayout.PAGE_END);

		JPanel newPanel3 = new JPanel();
		newPanel3.add(addPassage);
		newPanel3.add(removePassage);
		newPanel3.add(changePassage);
		newPanel3.add(showPlacesButton);
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

	private void allBuses() throws MalformedURLException, IOException {
		final Image image = getImage("images/bus1.jpg");
		allBuses = new JTable();

		allBuses.setOpaque(false);
		allBuses.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			{
				setOpaque(false);
			}
		});

		allBuses.setPreferredScrollableViewportSize(new Dimension(700, 100));
		allBuses.setSize(800, 300);

		JScrollPane allBusesPane = new JScrollPane(new JScrollPane(allBuses) {
			{
				setOpaque(false);
				getViewport().setOpaque(false);
			}

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		});
		allBusesPane.setPreferredSize(new Dimension(700, 100));
		allBusesPane.setSize(800, 300);
		panel1.add(allBusesPane, BorderLayout.CENTER);
	}

	private void allRoutes() throws IOException {
		final Image image = getImage("images/bus2.jpg");
		allRoutes = new JTable();

		allRoutes.setOpaque(false);
		allRoutes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			{
				setOpaque(false);
			}
		});

		allRoutes.setPreferredScrollableViewportSize(new Dimension(700, 100));
		allRoutes.setSize(800, 300);

		JScrollPane allRoutesPane = new JScrollPane(new JScrollPane(allRoutes) {
			{
				setOpaque(false);
				getViewport().setOpaque(false);
			}

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		});
		allRoutesPane.setPreferredSize(new Dimension(700, 100));
		allRoutesPane.setSize(800, 300);

		panel2.add(allRoutesPane, BorderLayout.CENTER);
	}

	private void allPassages() throws IOException {
		final Image image = getImage("images/bus3.png");
		allPassages = new JTable();

		allPassages.setOpaque(false);
		allPassages.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			{
				setOpaque(false);
			}
		});

		allPassages.setPreferredScrollableViewportSize(new Dimension(700, 100));
		allPassages.setSize(800, 300);

		JScrollPane allPassagesPane = new JScrollPane(new JScrollPane(allPassages) {
			{
				setOpaque(false);
				getViewport().setOpaque(false);
			}

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		});
		allPassagesPane.setPreferredSize(new Dimension(700, 100));
		allPassagesPane.setSize(800, 300);

		panel3.add(allPassagesPane, BorderLayout.CENTER);
	}

	private void allPassangers() throws IOException {
		final Image image = getImage("images/bus4.jpg");
		allPassangers = new JTable();

		allPassangers.setOpaque(false);
		allPassangers.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			{
				setOpaque(false);
			}
		});

		allPassangers.setPreferredScrollableViewportSize(new Dimension(700, 100));
		allPassangers.setSize(800, 300);

		JScrollPane allPassangersPane = new JScrollPane(new JScrollPane(allPassangers) {
			{
				setOpaque(false);
				getViewport().setOpaque(false);
			}

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		});
		allPassangersPane.setPreferredSize(new Dimension(700, 100));
		allPassangersPane.setSize(800, 300);

		panel4.add(allPassangersPane, BorderLayout.CENTER);
	}

	private void allOrganizations() throws IOException {
		final Image image = getImage("images/bus5.jpg");
		allOrganizations = new JTable();

		allRoutes.setOpaque(false);
		allRoutes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			{
				setOpaque(false);
			}
		});

		allOrganizations.setPreferredScrollableViewportSize(new Dimension(700, 100));
		allOrganizations.setSize(800, 300);

		JScrollPane allOrganizationsPane = new JScrollPane(new JScrollPane(allOrganizations) {
			{
				setOpaque(false);
				getViewport().setOpaque(false);
			}

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		});
		allOrganizationsPane.setPreferredSize(new Dimension(700, 100));
		allOrganizationsPane.setSize(800, 300);

		panel5.add(allOrganizationsPane, BorderLayout.CENTER);
	}

	public JTable getAllBusesTable() {
		return this.allBuses;
	}

	public JTable getAllRoutesTable() {
		return this.allRoutes;
	}

	public JTable getAllPassagesTable() {
		return this.allPassages;
	}

	public JTable getAllPassangersTable() {
		return this.allPassangers;
	}

	public JTable getAllOrganizationsTable() {
		return this.allOrganizations;
	}
	
	public static Image getImage(final String pathAndFileName) {
	    final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    return Toolkit.getDefaultToolkit().getImage(url);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBus) {
			new AddBusForm();
		} else if (e.getSource() == addRoute){
			new AddRouteForm();
		} else if (e.getSource() == addPassage){
			new AddPassageForm();
		} else if (e.getSource() == removeBus){
			new RemoveBusForm();
		} else if (e.getSource() == removeRoute){
			new RemoveRouteForm();
		} else if (e.getSource() == removePassage){
			new RemovePassageForm();
		} else if (e.getSource() == changeBus){
			Bus bus;
			int[] rows = allBuses.getSelectedRows();
			if (rows.length > 0){
				bus = new Bus((Integer)allBuses.getValueAt(rows[0], 0),(String)allBuses.getValueAt(rows[0], 1),(String)allBuses.getValueAt(rows[0], 2),(String)allBuses.getValueAt(rows[0], 3),(Integer)allBuses.getValueAt(rows[0], 4));
				new ChangeBusForm(bus);
			}else{
				JOptionPane.showMessageDialog(null, "Потрібно вибрати автобус!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == changeRoute){
			Route route;
			int[] rows = allRoutes.getSelectedRows();
			if (rows.length > 0){
				route = new Route((Integer)allRoutes.getValueAt(rows[0], 0),(Integer)allRoutes.getValueAt(rows[0], 1),(String)allRoutes.getValueAt(rows[0], 2),(String)allRoutes.getValueAt(rows[0], 3),(String)allRoutes.getValueAt(rows[0], 4));
				new ChangeRouteForm(route);
			}else{
				JOptionPane.showMessageDialog(null, "Потрібно вибрати маршрут!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == changePassage){
			Passage passage;
			int[] rows = allPassages.getSelectedRows();
			if (rows.length > 0){
				passage = new Passage((Integer)allPassages.getValueAt(rows[0], 0),(Integer)allPassages.getValueAt(rows[0], 1),(String)allPassages.getValueAt(rows[0], 2),(String)allRoutes.getValueAt(rows[0], 3),(Integer)allPassages.getValueAt(rows[0], 4), (Integer)allPassages.getValueAt(rows[0], 5));
				new ChangePassageForm(passage);
			}else{
				JOptionPane.showMessageDialog(null, "Потрібно вибрати рейс!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == showPlacesButton) {
			Route route;
			int[] rows = allPassages.getSelectedRows();
			if (rows.length > 0){
				route = new Route((Integer)allRoutes.getValueAt(rows[0], 0),(Integer)allRoutes.getValueAt(rows[0], 1),(String)allRoutes.getValueAt(rows[0], 2),(String)allRoutes.getValueAt(rows[0], 3),(String)allRoutes.getValueAt(rows[0], 4));

				String routeName = route.getDeparture() + " - " + route.getDestination();
				//TODO
				int numberOfSeats = 20;
				ShowPlacesForm form = new ShowPlacesForm(routeName, numberOfSeats);
				form.setVisible(true);

			}else{
				JOptionPane.showMessageDialog(null, "Потрібно вибрати рейс!", "", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}