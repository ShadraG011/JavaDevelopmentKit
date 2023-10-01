package org.example.hw1.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionWindow extends JFrame {
    private JTextField login = new JTextField();
    private JLabel loginLabel = new JLabel("Login: ");

    private JTextField password = new JTextField();
    private JLabel passwordLabel = new JLabel("Password: ");

    private JTextField server = new JTextField();
    private JLabel serverIPLabel = new JLabel("Server: ");

    private JButton checkConnect = new JButton("Log in!");
    private JPanel grid = new JPanel(new GridLayout(4, 1));
    private JPanel loginGrid = new JPanel(new GridLayout(1, 2));
    private JPanel passwordGrid = new JPanel(new GridLayout(1, 2));
    private JPanel serverGrid = new JPanel(new GridLayout(1, 2));
private Server serverDB = new Server();

    ChatWindow chatWindow;

    public ConnectionWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(700, 400);
        setSize(500, 180);

        chatWindow = new ChatWindow(this);

        checkConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatWindow.getMsgArea().setText(serverDB.userLogin(login.getText(), password.getText(), server.getText()));
                chatWindow.setVisible(true);
            }
        });
        getRootPane().setDefaultButton(checkConnect);

        elementsArrangement();
        setVisible(true);
    }

    private void elementsArrangement() {
        setResizable(false);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginGrid.add(loginLabel);
        loginGrid.add(login);

        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        passwordGrid.add(passwordLabel);
        passwordGrid.add(password);

        serverIPLabel.setHorizontalAlignment(JLabel.CENTER);
        serverGrid.add(serverIPLabel);
        serverGrid.add(server);

        grid.add(loginGrid);
        grid.add(passwordGrid);
        grid.add(serverGrid);
        grid.add(checkConnect);
        add(grid);
    }

    public void sendDataOnServer(String msg) {
        serverDB.saveMsg(msg);
    }
}
