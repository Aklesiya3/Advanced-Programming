package Chatapp;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Client implements ActionListener {

    JTextField msgTxt;
    static JPanel chatPanel;
    static Box msgBox = Box.createVerticalBox();

    static JFrame win = new JFrame();
    static DataOutputStream out;

    public Client() {

        win.setLayout(null);

        JPanel top = new JPanel();
        top.setBackground(Color.GRAY);
        top.setBounds(0, 0, 450, 50);
        top.setLayout(null);
        win.add(top);

        JLabel head = new JLabel("Client");
        head.setBounds(195, 10, 100, 25);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Arial", Font.BOLD, 18));
        top.add(head);

        chatPanel = new JPanel();
        chatPanel.setBounds(5, 50, 440, 580);
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
        win.setLocation(900, 50);
        win.setUndecorated(true);
        win.getContentPane().setBackground(Color.LIGHT_GRAY);
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

        JLabel lbl = new JLabel("<html><p style=\"width:150px;\">" + txt + "</p></html>");
        lbl.setFont(new Font("Arial", Font.PLAIN, 15));
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

        new Client();

        try {
            Socket socket = new Socket("127.0.0.1", 6006);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                chatPanel.setLayout(new BorderLayout());
                String txt = in.readUTF();
                JPanel p = makeMsg(txt);

                JPanel left = new JPanel(new BorderLayout());
                left.add(p, BorderLayout.LINE_START);

                msgBox.add(left);
                msgBox.add(Box.createVerticalStrut(10));

                chatPanel.add(msgBox, BorderLayout.PAGE_START);

                win.validate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
