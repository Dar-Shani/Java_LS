package Lessons.LS1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Authorization extends JFrame {
    private JPanel panelAuthorization;
    private Client client;

    Authorization(Client client) {
        this.client = client;
        JButton btnStart = new JButton("Войти");
        JTextField login = new JTextField();
        JLabel loginMenu = new JLabel("Логин");
        panelAuthorization = new JPanel(new GridLayout(1, 2));

        panelAuthorization.add(loginMenu);
        panelAuthorization.add(login);
        panelAuthorization.add(btnStart);

        this.client.add(panelAuthorization, BorderLayout.NORTH);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Server.activeServer == true) {
                    System.out.println("Авторизация " + login.getText());
                    client.setUserName(login.getText());
                    client.setTitle("Client пользователь " + client.getUserName());
                    panelAuthorization.setVisible(!panelAuthorization.isVisible());
                    client.runningToAddresses();
                    client.activeMassage();
                } else {
                    System.out.println("Нет связи с сервером");
                }
            }
        });
    }

    public void authorizationOn() {
        panelAuthorization.setVisible(true);
        this.client.activeMassage();
    }
}
