package client.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RemoveOrganizationForm extends JFrame {

    JPanel panel;
    JPanel buttonPanel;
    
    JButton ok;
    JButton cancel;
    
    public RemoveOrganizationForm() {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	int sizeWidth = 300;
		int sizeHeight = 200;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Видалити організацію");

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Видалити організацію?"));
        
        ok = new JButton("Так");
        ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					removeNotify();
				}
			});
        
        buttonPanel.add(ok, BorderLayout.PAGE_END);
        
        cancel = new JButton("Ні");
        cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					removeNotify();
				}
			});
        
        buttonPanel.add(cancel, BorderLayout.PAGE_END);
        
        this.add(panel);
        this.add(buttonPanel);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }
}