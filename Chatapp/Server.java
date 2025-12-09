package Chatapp;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Server implements ActionListener {

    JTextField msgTxt;
    JPanel chatPanel;
    static Box msgBox = Box.createVerticalBox();
    static JFrame win = new JFrame();
    static DataOutputStream out;

    public Server() {

        win.setLayout(null);

        JPanel top = new JPanel();
        top.setBackground(new Color(0, 80, 180));
        top.setBounds(0, 0, 450, 70);
        top.setLayout(null);
        win.add(top);

        JLabel head = new JLabel("Server");
        head.setBounds(190, 20, 100, 25);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Arial", Font.BOLD, 18));
        top.add(head);

        chatPanel = new JPanel();
        chatPanel.setBounds(5, 75, 440, 570);
        chatPanel.setBackground(new Color(220, 240, 255));
        win.add(chatPanel);

        msgTxt = new JTextField();
        msgTxt.setBounds(5, 650, 310, 40);
        msgTxt.setFont(new Font("Arial", Font.PLAIN, 16));
        win.add(msgTxt);

        JButton sendBtn = new JButton("Send");
        sendBtn.setBounds(320, 650, 123, 40);
        sendBtn.setBackground(new Color(255, 140, 0));
        sendBtn.setForeground(Color.WHITE);
        sendBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        sendBtn.addActionListener(this);
        win.add(sendBtn);

        win.setSize(450, 700);
        win.setLocation(100, 50);
        win.setUndecorated(true);
        win.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String txt = msgTxt.getText();

            JPanel p = makeMsg(txt);

            chatPanel.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p, BorderLayout.LINE_END);

            msgBox.add(right);
            msgBox.add(Box.createVerticalStrut(10));

            chatPanel.add(msgBox, BorderLayout.PAGE_START);

            out.writeUTF(txt);

            msgTxt.setText("");

            win.repaint();
            win.validate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static JPanel makeMsg(String txt) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lbl = new JLabel("<html><p style=\"width: 150px\">" + txt + "</p></html>");
        lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        lbl.setBackground(new Color(200, 255, 200));
        lbl.setOpaque(true);
        lbl.setBorder(new EmptyBorder(10, 10, 10, 40));
        panel.add(lbl);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel(sdf.format(new Date()));
        panel.add(time);

        return panel;
    }

    public static void main(String[] args) {

        new Server();

        try {
            ServerSocket server = new ServerSocket(6006);

            while (true) {
                Socket s = server.accept();
                DataInputStream in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());

                while (true) {
                    String txt = in.readUTF();
                    JPanel p = makeMsg(txt);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(p, BorderLayout.LINE_START);

                    msgBox.add(left);
                    win.validate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
