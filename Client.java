package Lessons.LS1;

import javax.swing.*;
import java.util.ArrayList;

public class Client extends JFrame {
    private int WINDOW_HEIGHT = 600;
    private int WINDOW_WIDTH = 400;
    private String name;
    private SendingMessages sMessages = new SendingMessages(this);
    private Authorization authorization = new Authorization(this);
    private JTextArea listTextClient;
    private JScrollPane scrollBar;
    private ArrayList<Client> adresaty;
    public Server server;

    Client(int POS_X, int POS_Y, Server server, ArrayList<Client> adresaty) {
        this.server = server;
        this.adresaty = adresaty;
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

    public String getUserName() {
        return this.name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void activeMassage() {
        sMessages.MessagessOnOff();
    }

    public void connectionServerrOff(String text) {
        setUserName("null");
        authorization.authorizationOn();
        listTextClient.setText(text);
    }

    public void openMassages() {
        scrollBar.setVisible(true);
        server.readLog(listTextClient);
    }

    public void runningToAddresses() {
        for (Client adresat : adresaty) {
            adresat.openMassages();
        }
    }
}
