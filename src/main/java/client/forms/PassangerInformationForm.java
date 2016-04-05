package client.forms;

import server.entities.Passanger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Random;

@SuppressWarnings("serial")
public class PassangerInformationForm extends JFrame {

	Passanger passanger;
    JPanel panel;
    JPanel buttonPanel;
    JTextField id;
    JTextField pib;
    JTextField passport;
    JTextField organizationId;
    JButton addPassanger;

    public PassangerInformationForm() {
        String[] a = new String[10];
        a[0] = "Владислав Лисенко";
        a[1] = "Круть Костянтин";
        a[2] = "Макуха Максим";
        a[3] = "Куцик Василь";
        a[4] = "Владислав Нікіфоров";
        a[5] = "Олег Шелаєв";
        a[6] = "Віктор Петренко";
        a[7] = "Яна Малих";
        a[8] = "Ірина Коваль";
        a[9] = "Олена Кирилюк";

        // Инициализируем генератор
        Random rnd = new Random(System.currentTimeMillis());
        // Получаем случайное число в диапазоне от min до max (включительно)
        int first = 1 + rnd.nextInt(9);

        this.setSize(700,350);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Інформація про клієнта");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(new JLabel(a[first]));


        this.add(panel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}