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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import server.entities.Bus;
import server.entities.Organization;
import server.entities.Passage;
import server.entities.Passanger;
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
	JButton classPrice;
	JButton addRoute;
	JButton removeRoute;
	JButton changeRoute;
	JButton addPassage;
	JButton removePassage;
	JButton changePassage;
	JButton showPlacesButton;
	
	JButton userStatistic;
	JButton orgStatistic;
	
	List<Passanger> passangers;
	List<Organization> organizations;

	private JTextField jtfFilterBuses = new JTextField();
	private TableRowSorter<TableModel> rowSorterBuses;
	
	private JTextField jtfFilterRoutes = new JTextField();
	private TableRowSorter<TableModel> rowSorterRoutes;
	
	private JTextField jtfFilterPassages = new JTextField();
	private TableRowSorter<TableModel> rowSorterPassages;
	
	private JTextField jtfFilterPassangers = new JTextField();
	private TableRowSorter<TableModel> rowSorterPassangers;
	
	private JTextField jtfFilterOrganizations = new JTextField();
	private TableRowSorter<TableModel> rowSorterOrganizations;

	public AdminForm(List<Bus> buses, List<Route> routes, List<Passage> passages, List<Passanger> passangers, List<Organization> organizations) {
		super("Administrator panel");
		
		setBounds(0, 0, 1000, 600);

		JTabbedPane tabby = new JTabbedPane();
		
		this.passangers = passangers;
		this.organizations = organizations;

		panel1 = new JPanel(new BorderLayout());
		try {
			allBuses();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		allBuses.setModel(new BusTable(buses));
		rowSorterBuses = new TableRowSorter<>(allBuses.getModel());
		allBuses.setRowSorter(rowSorterBuses);

		jtfFilterBuses.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfFilterBuses.getText();

				if (text.trim().length() == 0) {
					rowSorterBuses.setRowFilter(null);
				} else {
					rowSorterBuses.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfFilterBuses.getText();

				if (text.trim().length() == 0) {
					rowSorterBuses.setRowFilter(null);
				} else {
					rowSorterBuses.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		addBus = new JButton("Додати автобус");
		addBus.addActionListener(this);

		removeBus = new JButton("Видалити автобус");
		removeBus.addActionListener(this);

		changeBus = new JButton("Редагувати інформацію про автобус");
		changeBus.addActionListener(this);
		
		classPrice = new JButton("Класи автобусів");
		classPrice.addActionListener(this);

		JPanel newPanel = new JPanel(new BorderLayout());
		newPanel.add(addBus, BorderLayout.WEST);
		newPanel.add(removeBus, BorderLayout.CENTER);
		newPanel.add(changeBus, BorderLayout.EAST);
		newPanel.add(classPrice, BorderLayout.NORTH);
		
		JPanel SearchPanel1 = new JPanel(new BorderLayout()); 
		SearchPanel1.add(new JLabel("Пошук: "), BorderLayout.WEST); 
		SearchPanel1.add(jtfFilterBuses, BorderLayout.CENTER); 
		newPanel.add(SearchPanel1, BorderLayout.AFTER_LAST_LINE);

		panel1.add(newPanel, BorderLayout.PAGE_END);

		panel2 = new JPanel(new BorderLayout());
		try {
			allRoutes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		allRoutes.setModel(new RouteTable(routes));
		rowSorterRoutes = new TableRowSorter<>(allRoutes.getModel());
		allRoutes.setRowSorter(rowSorterRoutes);

		jtfFilterRoutes.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfFilterRoutes.getText();

				if (text.trim().length() == 0) {
					rowSorterRoutes.setRowFilter(null);
				} else {
					rowSorterRoutes.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfFilterRoutes.getText();

				if (text.trim().length() == 0) {
					rowSorterRoutes.setRowFilter(null);
				} else {
					rowSorterRoutes.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		panel3 = new JPanel(new BorderLayout());
		try {
			allPassages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		allPassages.setModel(new PassageTable(passages));
		rowSorterPassages = new TableRowSorter<>(allPassages.getModel());
		allPassages.setRowSorter(rowSorterPassages);

		jtfFilterPassages.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfFilterPassages.getText();

				if (text.trim().length() == 0) {
					rowSorterPassages.setRowFilter(null);
				} else {
					rowSorterPassages.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfFilterPassages.getText();

				if (text.trim().length() == 0) {
					rowSorterPassages.setRowFilter(null);
				} else {
					rowSorterPassages.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		panel4 = new JPanel(new BorderLayout());
		try {
			allPassangers();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		allPassangers.setModel(new PassangerTable(passangers));
		rowSorterPassangers = new TableRowSorter<>(allPassangers.getModel());
		allPassangers.setRowSorter(rowSorterPassangers);

		jtfFilterPassangers.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfFilterPassangers.getText();

				if (text.trim().length() == 0) {
					rowSorterPassangers.setRowFilter(null);
				} else {
					rowSorterPassangers.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfFilterPassangers.getText();

				if (text.trim().length() == 0) {
					rowSorterPassangers.setRowFilter(null);
				} else {
					rowSorterPassangers.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		panel5 = new JPanel(new BorderLayout());
		try {
			allOrganizations();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		allOrganizations.setModel(new OrganizationTable(organizations));
		rowSorterOrganizations = new TableRowSorter<>(allOrganizations.getModel());
		allOrganizations.setRowSorter(rowSorterOrganizations);

		jtfFilterOrganizations.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfFilterOrganizations.getText();

				if (text.trim().length() == 0) {
					rowSorterOrganizations.setRowFilter(null);
				} else {
					rowSorterOrganizations.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfFilterOrganizations.getText();

				if (text.trim().length() == 0) {
					rowSorterOrganizations.setRowFilter(null);
				} else {
					rowSorterOrganizations.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

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
		
		userStatistic = new JButton("Пасажири за останній місяць");
		userStatistic.addActionListener(this);
		
		orgStatistic = new JButton("Організації за останній місяць");
		orgStatistic.addActionListener(this);
		
		JPanel newPanel2 = new JPanel(new BorderLayout());
		newPanel2.add(addRoute, BorderLayout.WEST);
		newPanel2.add(removeRoute, BorderLayout.CENTER);
		newPanel2.add(changeRoute, BorderLayout.EAST);
		panel2.add(newPanel2, BorderLayout.PAGE_END);
		
		JPanel SearchPanel2 = new JPanel(new BorderLayout()); 
		SearchPanel2.add(new JLabel("Пошук: "), BorderLayout.WEST); 
		SearchPanel2.add(jtfFilterRoutes, BorderLayout.CENTER); 
		newPanel2.add(SearchPanel2, BorderLayout.AFTER_LAST_LINE);

		JPanel newPanel3 = new JPanel(new BorderLayout());
		newPanel3.add(addPassage, BorderLayout.WEST);
		newPanel3.add(removePassage, BorderLayout.CENTER);
		newPanel3.add(changePassage, BorderLayout.EAST);
		newPanel3.add(showPlacesButton, BorderLayout.NORTH);
		panel3.add(newPanel3, BorderLayout.PAGE_END);
		
		JPanel SearchPanel3 = new JPanel(new BorderLayout()); 
		SearchPanel3.add(new JLabel("Пошук: "), BorderLayout.WEST); 
		SearchPanel3.add(jtfFilterPassages, BorderLayout.CENTER); 
		newPanel3.add(SearchPanel3, BorderLayout.AFTER_LAST_LINE);

		JPanel newPanel4 = new JPanel(new BorderLayout());
		newPanel4.add(userStatistic, BorderLayout.CENTER);
		panel4.add(newPanel4, BorderLayout.PAGE_END);

		JPanel SearchPanel4 = new JPanel(new BorderLayout()); 
		SearchPanel4.add(new JLabel("Пошук: "), BorderLayout.WEST); 
		SearchPanel4.add(jtfFilterPassangers, BorderLayout.CENTER); 
		newPanel4.add(SearchPanel4, BorderLayout.AFTER_LAST_LINE);
		
		JPanel newPanel5 = new JPanel(new BorderLayout());
		newPanel5.add(orgStatistic, BorderLayout.CENTER);
		panel5.add(newPanel5, BorderLayout.PAGE_END);
		
		JPanel SearchPanel5 = new JPanel(new BorderLayout()); 
		SearchPanel5.add(new JLabel("Пошук: "), BorderLayout.WEST); 
		SearchPanel5.add(jtfFilterOrganizations, BorderLayout.CENTER); 
		newPanel5.add(SearchPanel5, BorderLayout.AFTER_LAST_LINE);

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
		} else if (e.getSource() == addRoute) {
			new AddRouteForm();
		} else if (e.getSource() == classPrice) {
			new ClassPriceForm();
		} else if (e.getSource() == userStatistic) {
			new UserStatisticForm(passangers);
		} else if (e.getSource() == orgStatistic) {
			new OrgStatisticForm(organizations);
		} else if (e.getSource() == addPassage) {
			new AddPassageForm();
		} else if (e.getSource() == removeBus) {
			new RemoveBusForm();
		} else if (e.getSource() == removeRoute) {
			new RemoveRouteForm();
		} else if (e.getSource() == removePassage) {
			new RemovePassageForm();
		} else if (e.getSource() == changeBus) {
			Bus bus;
			int[] rows = allBuses.getSelectedRows();
			if (rows.length > 0) {
				bus = new Bus((Integer) allBuses.getValueAt(rows[0], 0), (String) allBuses.getValueAt(rows[0], 1),
						(String) allBuses.getValueAt(rows[0], 2), (String) allBuses.getValueAt(rows[0], 3),
						(Integer) allBuses.getValueAt(rows[0], 4));
				new ChangeBusForm(bus);
			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати автобус!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == changeRoute) {
			Route route;
			int[] rows = allRoutes.getSelectedRows();
			if (rows.length > 0) {
				route = new Route((Integer) allRoutes.getValueAt(rows[0], 0),
						(Integer) allRoutes.getValueAt(rows[0], 1), (String) allRoutes.getValueAt(rows[0], 2),
						(String) allRoutes.getValueAt(rows[0], 3), (String) allRoutes.getValueAt(rows[0], 4));
				new ChangeRouteForm(route);
			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати маршрут!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == changePassage) {
			Passage passage;
			int[] rows = allPassages.getSelectedRows();
			if (rows.length > 0) {
				passage = new Passage((Integer) allPassages.getValueAt(rows[0], 0),
						(Integer) allPassages.getValueAt(rows[0], 1), (String) allPassages.getValueAt(rows[0], 2),
						(String) allRoutes.getValueAt(rows[0], 3), (Integer) allPassages.getValueAt(rows[0], 4),
						(Integer) allPassages.getValueAt(rows[0], 5));
				new ChangePassageForm(passage);
			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати рейс!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == showPlacesButton) {
			Route route;
			int[] rows = allPassages.getSelectedRows();
			if (rows.length > 0) {
				route = new Route((Integer) allRoutes.getValueAt(rows[0], 0),
						(Integer) allRoutes.getValueAt(rows[0], 1), (String) allRoutes.getValueAt(rows[0], 2),
						(String) allRoutes.getValueAt(rows[0], 3), (String) allRoutes.getValueAt(rows[0], 4));

				String routeName = route.getDeparture() + " - " + route.getDestination();
				// TODO
				int numberOfSeats = 20;
				ShowPlacesForm form = new ShowPlacesForm(routeName, numberOfSeats);
				form.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати рейс!", "", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}