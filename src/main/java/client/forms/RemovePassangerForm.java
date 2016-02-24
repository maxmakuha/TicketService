package client.forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RemovePassangerForm extends JFrame {

    JPanel panel;
    JPanel buttonPanel;
    
    JButton ok;
    JButton cancel;
    
    public RemovePassangerForm() {
    	
        this.setSize(200,200);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Видалити клієнта");

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Видалити клієнта?"));
        
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