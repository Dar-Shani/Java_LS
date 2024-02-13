package Lessons.LS1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Server extends JFrame {
    private int WINDOW_HEIGHT = 600;
    private int WINDOW_WIDTH = 400;
    public static boolean activeServer = false;
    private JTextArea listText;

    Server(int POS_X, int POS_Y) {
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
                activeServer = true;
                scrollBar.setVisible(true);
                System.out.println("Server " + Server.activeServer);
                readLog();
            }
        });

        btnServerOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeServer = false;
                addMessages("Сервер выключен");
                listText.setText("Сервер выключен");
                System.out.println("Server " + Server.activeServer);
            }
        });
    }

    public void addMessages(String messages) {
        writerLog(messages);
    }

    private void writerLog(String text) {
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
                text.append(line).append("\n");
            }
            listText.setText(text.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении" + e);
        }
    }

    public void readLog(JTextArea lText) {
        try (BufferedReader read = new BufferedReader(new FileReader("log.txt"))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                text.append(line).append("\n");
            }
            lText.setText(text.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении" + e);
        }
    }
}
