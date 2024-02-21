package Lessons.LS2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ServerGUI extends JFrame implements ServerView {
    private int WINDOW_HEIGHT = 600;
    private int WINDOW_WIDTH = 400;
    private JTextArea listText;
    public Server server;

    ServerGUI(int POS_X, int POS_Y, Server server) {
        this.server = server;
        serverMenu(POS_X, POS_Y);
    }

    private void serverMenu(int POS_X, int POS_Y) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");

        JButton btnActiveStart = new JButton("Активация");

        JPanel panelAсtiveServer = new JPanel(new GridLayout(1, 1));
        listText = new JTextArea();
        listText.setEditable(false);
        JScrollPane scrollBar = new JScrollPane(listText);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton btnServerOff = new JButton("Выключение");
        panelAсtiveServer.add(btnActiveStart);
        panelAсtiveServer.add(btnServerOff);
        add(panelAсtiveServer, BorderLayout.NORTH);
        add(scrollBar);

        setVisible(true);

        btnActiveStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.setServer(true);
                System.out.println(server.getServer());
                server.readLog();
            }
        });

        btnServerOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.setServer(false);
                listText.setText("Сервер выключен");
                System.out.println(server.getServer());
                server.writerLog("Сервер выключен");
            }
        });
    }

    @Override
    public void readMassage(String massage) {
        listText.setText(massage);
    }
}
