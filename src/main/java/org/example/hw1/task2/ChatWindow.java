package org.example.hw1.task2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private JTextArea msgArea = new JTextArea(10, 1);
    JScrollPane scroll = new JScrollPane(msgArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    private JLabel label = new JLabel("Input Message:");
    private JTextField msg = new JTextField();
    private JButton sendBtn = new JButton("Send");
    private JPanel grid = new JPanel(new GridLayout(2, 1));
    private JPanel scrollPanel = new JPanel(new GridLayout(1, 2));


    public ChatWindow(ConnectionWindow connectionWindow) {
        setLocationRelativeTo(connectionWindow);
        setSize(500, 300);

        elementsArrangement();

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (msg.getText().length() > 0) {
                    String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/d HH:mm:ss")) + " | " + msg.getText() + "\n";
                    msgArea.append(message);
                    connectionWindow.sendDataOnServer(message);
                    msg.setText("");
                }
            }
        });
        getRootPane().setDefaultButton(sendBtn);
    }

    private void elementsArrangement() {
        setResizable(false);
        msgArea.setEditable(false);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(5, 5);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(scroll, BorderLayout.NORTH);
        scrollPanel.add(label);
        scrollPanel.add(msg);
        grid.add(scrollPanel);
        grid.add(sendBtn);
        add(grid);
    }

    public JTextArea getMsgArea() {
        return msgArea;
    }

}
