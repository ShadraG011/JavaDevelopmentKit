package org.example.hw1.task2;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Server {
    private String path = "src\\main\\java\\org\\example\\hw1\\task2\\usermessageDB\\";
    private File file;

    public String userLogin(String login, String password, String serverIP) {
        file = new File(path + login + "$" + password + "$" + serverIP);
        try {
            if (!file.exists()) {
                file.createNewFile();
                saveMsg("Чат создан: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/d HH:mm:ss")) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return findUserMsg(login, password, serverIP);
    }

    public void saveMsg(String msg) {
        try (FileWriter writer = new FileWriter(file.getAbsolutePath(), true)) {
            writer.write(msg);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String getMsg(File file) {
        String st;
        String msg = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null)
                msg += st + "\n";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return msg;
    }

    private String findUserMsg(String login, String password, String serverIP) {
        final File folder = new File(path);
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.getName().equals(login + "$" + password + "$" + serverIP))
                return getMsg(fileEntry);
        }
        return "";
    }


}
