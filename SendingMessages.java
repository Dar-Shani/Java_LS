package Lessons.LS1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SendingMessages extends JFrame {
    private JPanel panelSendMessages;

    SendingMessages(Client client) {

        JButton btnSend = new JButton("Отправка");
        JTextField textMessages = new JTextField();
        panelSendMessages = new JPanel(new GridLayout(1, 2));
        panelSendMessages.add(textMessages);
        panelSendMessages.add(btnSend);
        client.add(panelSendMessages, BorderLayout.SOUTH);
        panelSendMessages.setVisible(false);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Server.activeServer) {
                    client.connectionServerrOff("Сервер не отвечает");
                } else {
                    client.server.addMessages(client.getUserName() + ": " + textMessages.getText());
                    client.server.readLog();
                    textMessages.setText("");
                    client.runningToAddresses();
                }
            }
        });
    }

    public void MessagessOnOff() {
        if (!Server.activeServer) {
            panelSendMessages.setVisible(false);
        } else {
            panelSendMessages.setVisible(true);
        }
    }

}
