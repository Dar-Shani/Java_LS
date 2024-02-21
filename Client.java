package Lessons.LS2;

import java.util.ArrayList;

public class Client {
    private String name;
    private ArrayList<Client> adresaty;
    private ClientView clientView;
    private Server server;

    Client(int POS_X, int POS_Y, Server server, ArrayList<Client> client) {
        adresaty = client;
        this.server = server;
        clientView = new ClientGUI(POS_X, POS_Y, this);
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public boolean connectionServer() {
        return server.getServer();
    }

    public void conveyMessage(String message) {
        server.writerLog(getUserName() + ": " + message);
        server.readLog();
    }

    public void runningToAddresses() {
        for (Client adresat : adresaty) {
            if (adresat.getUserName() != null) {
                adresat.readMassage();
            }
        }
    }

    public void readMassage() {
        server.readLog(clientView);
    }

}
