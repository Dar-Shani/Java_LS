package Lessons.LS1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Client> adresaty = new ArrayList<>();

        Server server = new Server(2000, 200);
        adresaty.add(new Client(1600, 200, server, adresaty));
        adresaty.add(new Client(2400, 200, server, adresaty));

    }
}
