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

import server.entities.Route;

@SuppressWarnings("serial")
public class PassangerForm extends JFrame implements ActionListener {

	JPanel panel2;
	JPanel panel3;
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

	JButton showPlacesButton;

	public PassangerForm() {
		super("Passanger panel");
		setBounds(0, 0, 1000, 600);

		JTabbedPane tabby = new JTabbedPane();

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

		showPlacesButton = new JButton("Показати місця");
		showPlacesButton.addActionListener(this);

		JPanel newPanel2 = new JPanel();
		panel2.add(newPanel2, BorderLayout.PAGE_END);

		JPanel newPanel3 = new JPanel();
		newPanel3.add(showPlacesButton);
		panel3.add(newPanel3, BorderLayout.PAGE_END);

		tabby.addTab("Маршрути", panel2);
		tabby.addTab("Рейси", panel3);
		add(tabby);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void allRoutes() throws IOException {
		final Image image = getImage("images/bus2.jpg");
		allRoutes = new JTable();

		allRoutes.setOpaque(false);
		allRoutes.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
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
		allPassages.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
					{
						setOpaque(false);
					}
				});

		allPassages.setPreferredScrollableViewportSize(new Dimension(700, 100));
		allPassages.setSize(800, 300);

		JScrollPane allPassagesPane = new JScrollPane(new JScrollPane(
				allPassages) {
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
		final URL url = Thread.currentThread().getContextClassLoader()
				.getResource(pathAndFileName);
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == showPlacesButton) {
			Route route;
			int[] rows = allPassages.getSelectedRows();
			if (rows.length > 0) {
				route = new Route((Integer) allRoutes.getValueAt(rows[0], 0),
						(Integer) allRoutes.getValueAt(rows[0], 1),
						(String) allRoutes.getValueAt(rows[0], 2),
						(String) allRoutes.getValueAt(rows[0], 3),
						(String) allRoutes.getValueAt(rows[0], 4));

				String routeName = route.getDeparture() + " - "
						+ route.getDestination();
				// TODO
				int numberOfSeats = 20;
				ShowPlacesForm form = new ShowPlacesForm(routeName,
						numberOfSeats);
				form.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "Потрібно вибрати рейс!",
						"", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}