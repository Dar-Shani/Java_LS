package Lessons.LS2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClientGUI extends JFrame implements ClientView {
    private int WINDOW_HEIGHT = 600;
    private int WINDOW_WIDTH = 400;

    private JTextArea listTextClient;
    private JScrollPane scrollBar;

    private JPanel panelAuthorization;
    private JPanel panelSendMessages;

    public Client client;

    ClientGUI(int POS_X, int POS_Y, Client client) {
        this.client = client;
        settingWindow(POS_X, POS_Y);
        authorization();
        sendMassages();
        panelMessage();
    }

    private void settingWindow(int POS_X, int POS_Y) {
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Client");

        listTextClient = new JTextArea();
        listTextClient.setEditable(false);
        scrollBar = new JScrollPane(listTextClient);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollBar);
        scrollBar.setVisible(false);

        setVisible(true);
    }

    private void authorization() {
        JButton btnStart = new JButton("Войти");
        JTextField login = new JTextField();
        JLabel loginMenu = new JLabel("Логин");
        panelAuthorization = new JPanel(new GridLayout(1, 2));

        panelAuthorization.add(loginMenu);
        panelAuthorization.add(login);
        panelAuthorization.add(btnStart);

        add(panelAuthorization, BorderLayout.NORTH);

        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (client.connectionServer() == true) {
                    System.out.println("Авторизация " + login.getText());
                    client.setUserName(login.getText());
                    setTitle("Client пользователь " + client.getUserName());
                    panelAuthorization.setVisible(!panelAuthorization.isVisible());
                    panelSendMessages.setVisible(!panelSendMessages.isVisible());
                    scrollBar.setVisible(!scrollBar.isVisible());
                    client.runningToAddresses();

                } else {
                    System.out.println("Нет связи с сервером");
                }
            }
        });
    }

    @Override
    public void sendMassages() {
        JButton btnSend = new JButton("Отправка");
        JTextField textMessages = new JTextField();
        panelSendMessages = new JPanel(new GridLayout(1, 2));
        panelSendMessages.add(textMessages);
        panelSendMessages.add(btnSend);
        add(panelSendMessages, BorderLayout.SOUTH);
        panelSendMessages.setVisible(false);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!client.connectionServer()) {
                    authorization();
                    showMassage("Сервер не отвечает");
                    panelSendMessages.setVisible(false);
                    System.out.println("Сервер не отвечает");
                } else {
                    System.out.println("жмяк отправка");
                    client.conveyMessage(textMessages.getText());
                    client.runningToAddresses();
                    textMessages.setText("");
                }
            }
        });
    }

    private void panelMessage() {
        listTextClient = new JTextArea();
        listTextClient.setEditable(false);
        scrollBar = new JScrollPane(listTextClient);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollBar);
        scrollBar.setVisible(false);
    }

    @Override
    public void showMassage(String message) {
        listTextClient.setText(message);
    }
}
