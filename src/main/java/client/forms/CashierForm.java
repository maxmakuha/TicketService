package client.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import server.entities.Organization;
import server.entities.Passage;
import server.entities.Passanger;
import server.entities.Route;

@SuppressWarnings("serial")
public class CashierForm extends JFrame implements ActionListener {

	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JTextArea text;
	JTextArea text2;
	JTextArea text3;
	JTextArea text4;
	JTextArea text5;
	JTable allRoutes;
	JTable allPassages;
	JTable allPassangers;
	JTable allOrganizations;

	JButton addPassanger;
	JButton changePassanger;
	JButton removePassanger;
	JButton addOrganization;
	JButton changeOrganization;
	JButton removeOrganization;
	JButton showPlacesButton;

	JButton userStatistic;
	JButton orgStatistic;

	List<Passanger> passangers;
	List<Organization> organizations;

	private JTextField jtfFilterRoutes = new JTextField();
	private TableRowSorter<TableModel> rowSorterRoutes;

	private JTextField jtfFilterPassages = new JTextField();
	private TableRowSorter<TableModel> rowSorterPassages;

	private JTextField jtfFilterPassangers = new JTextField();
	private TableRowSorter<TableModel> rowSorterPassangers;

	private JTextField jtfFilterOrganizations = new JTextField();
	private TableRowSorter<TableModel> rowSorterOrganizations;

	public CashierForm(List<Route> routes, List<Passage> passages, List<Passanger> passangers,
			List<Organization> organizations) {
		super("Cashier panel");
		setBounds(0, 0, 1000, 600);

		JTabbedPane tabby = new JTabbedPane();

		this.passangers = passangers;
		this.organizations = organizations;

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

		addPassanger = new JButton("Додати клієнта");
		addPassanger.addActionListener(this);

		changePassanger = new JButton("Редагувати інформацію про клієнта");
		changePassanger.addActionListener(this);

		removePassanger = new JButton("Видалити клієнта");
		removePassanger.addActionListener(this);

		addOrganization = new JButton("Додати організацію");
		addOrganization.addActionListener(this);

		changeOrganization = new JButton("Редагувати інформацію про організацію");
		changeOrganization.addActionListener(this);

		removeOrganization = new JButton("Видалити організацію");
		removeOrganization.addActionListener(this);

		showPlacesButton = new JButton("Показати місця");
		showPlacesButton.addActionListener(this);

		userStatistic = new JButton("Пасажири за останній місяць");
		userStatistic.addActionListener(this);

		orgStatistic = new JButton("Організації за останній місяць");
		orgStatistic.addActionListener(this);

		JPanel newPanel2 = new JPanel(new BorderLayout());
		panel2.add(newPanel2, BorderLayout.PAGE_END);

		JPanel SearchPanel2 = new JPanel(new BorderLayout());
		SearchPanel2.add(new JLabel("Пошук: "), BorderLayout.WEST);
		SearchPanel2.add(jtfFilterRoutes, BorderLayout.CENTER);
		newPanel2.add(SearchPanel2, BorderLayout.AFTER_LAST_LINE);

		JPanel newPanel3 = new JPanel(new BorderLayout());
		newPanel3.add(showPlacesButton, BorderLayout.CENTER);
		panel3.add(newPanel3, BorderLayout.PAGE_END);

		JPanel SearchPanel3 = new JPanel(new BorderLayout());
		SearchPanel3.add(new JLabel("Пошук: "), BorderLayout.WEST);
		SearchPanel3.add(jtfFilterPassages, BorderLayout.CENTER);
		newPanel3.add(SearchPanel3, BorderLayout.AFTER_LAST_LINE);

		JPanel newPanel4 = new JPanel(new BorderLayout());
		newPanel4.add(addPassanger, BorderLayout.WEST);
		newPanel4.add(changePassanger, BorderLayout.CENTER);
		newPanel4.add(removePassanger, BorderLayout.EAST);
		newPanel4.add(userStatistic, BorderLayout.NORTH);
		panel4.add(newPanel4, BorderLayout.PAGE_END);

		JPanel SearchPanel4 = new JPanel(new BorderLayout());
		SearchPanel4.add(new JLabel("Пошук: "), BorderLayout.WEST);
		SearchPanel4.add(jtfFilterPassangers, BorderLayout.CENTER);
		newPanel4.add(SearchPanel4, BorderLayout.AFTER_LAST_LINE);

		JPanel newPanel5 = new JPanel(new BorderLayout());
		newPanel5.add(addOrganization, BorderLayout.WEST);
		newPanel5.add(changeOrganization, BorderLayout.CENTER);
		newPanel5.add(removeOrganization, BorderLayout.EAST);
		newPanel5.add(orgStatistic, BorderLayout.NORTH);
		panel5.add(newPanel5, BorderLayout.PAGE_END);

		JPanel SearchPanel5 = new JPanel(new BorderLayout());
		SearchPanel5.add(new JLabel("Пошук: "), BorderLayout.WEST);
		SearchPanel5.add(jtfFilterOrganizations, BorderLayout.CENTER);
		newPanel5.add(SearchPanel5, BorderLayout.AFTER_LAST_LINE);

		tabby.addTab("Маршрути", panel2);
		tabby.addTab("Рейси", panel3);
		tabby.addTab("Пасажири", panel4);
		tabby.addTab("Організації", panel5);
		add(tabby);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
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
		if (e.getSource() == addPassanger) {
			new AddPassangerForm();
		} else if (e.getSource() == addOrganization) {
			new AddOrganizationForm();
		} else if (e.getSource() == removePassanger) {
			new RemovePassangerForm();
		} else if (e.getSource() == userStatistic) {
			new UserStatisticForm(passangers);
		} else if (e.getSource() == orgStatistic) {
			new OrgStatisticForm(organizations);
		} else if (e.getSource() == removeOrganization) {
			new RemoveOrganizationForm();
		} else if (e.getSource() == changePassanger) {
			Passanger passanger;
			int[] rows = allPassangers.getSelectedRows();
			if (rows.length > 0) {
				passanger = new Passanger((Integer) allPassangers.getValueAt(rows[0], 0),
						(String) allPassangers.getValueAt(rows[0], 1), (String) allPassangers.getValueAt(rows[0], 2),
						(Integer) allPassangers.getValueAt(rows[0], 3));
				new ChangePassangerForm(passanger);
			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати клієнта!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == changeOrganization) {
			Organization organization;
			int[] rows = allOrganizations.getSelectedRows();
			if (rows.length > 0) {
				organization = new Organization((Integer) allOrganizations.getValueAt(rows[0], 0),
						(String) allOrganizations.getValueAt(rows[0], 1));
				new ChangeOrganizationForm(organization);
			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати організацію!", "",
						JOptionPane.INFORMATION_MESSAGE);
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