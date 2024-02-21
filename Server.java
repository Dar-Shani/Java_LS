package Lessons.LS2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Server {
    private boolean activeServer = false;
    public ServerView serverView;

    Server(int POS_X, int POS_Y) {
        serverView = new ServerGUI(POS_X, POS_Y, this);
    }

    public boolean getServer() {
        return activeServer;
    }

    public void setServer(boolean activeServer) {
        this.activeServer = activeServer;
    }

    public void writerLog(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка при записи" + e);
        }
    }

    public void readLog() {
        try (BufferedReader read = new BufferedReader(new FileReader("log.txt"))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                serverView.readMassage(text.append(line).append("\n").toString());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении" + e);
        }
    }

    public void readLog(ClientView clientView) {
        try (BufferedReader read = new BufferedReader(new FileReader("log.txt"))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                clientView.showMassage(text.append(line).append("\n").toString());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении" + e);
        }
    }
}
