package com.company;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*;

public class Main {
    private static HashMap<Integer, Mail> mails = new HashMap<Integer, Mail>();
    Stack<type> stk = new Stack<>();  
    private static Robot robot;
    private static Outlook outlook;
    private static Windows windows;
    private static Word word;
    private static int quantity;
    private static Atlas atlas;

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        quantity = 2;
        initialization();
        saveMail();
        input();
        atlas();
    }
    private static void initialization(){
        try {
            atlas = new Atlas("p901pwo", "p901pwo ", "p903pwo+");
            robot = new Robot();
            outlook = new Outlook(robot);
            windows = new Windows(robot);
            word = new Word(robot);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void input() throws IOException {
        for (int i = 0; i < quantity; i++) {
            File file = new File("\\\\fspa.myntet.se\\userdata\\SE-Users4\\p901pwo\\" + i + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String st, pid = null, account = null;

            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {
                if (st.contains("valutakontonummer")) {
                    account = st.replace("valutakontonummer :", "").replace(" ", "");
                    account.replace("\"", "");
                } else if (st.contains("pid-input-field")) {
                    st.replace(" ", "");
                    pid = st.replace("pid-input-field :", "");
                }
            }
            Mail obj = new Mail(pid, Long.parseLong(account));
            mails.put(i, obj);
        }
    }

    private static void atlas(){
        try
        {
            File file = new File("C:\\Users\\P901PWO\\Desktop\\Atlas.zws");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        delay(3);
        windows.write(atlas.getPassword());
        windows.enter();
        delay(2);
        windows.write(atlas.getAccount());
        windows.write(atlas.getPid());
        windows.enter();
        windows.write("VKTOCLOS");
        for (Integer i : mails.keySet()) {
            windows.f10();
            delay(1);
            windows.tab();
            windows.write("h");
            Mail obj = (Mail)mails.get(i);
            windows.write(String.valueOf(obj.getAccount()));
            windows.enter();
            windows.enter();
            windows.write("y");
            windows.enter();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int result = JOptionPane.showConfirmDialog(frame,"Closed?", "Status",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){

            }
            else if (result == JOptionPane.NO_OPTION){

            }
            delay(1);
            windows.control();
        }
        delay(2);
    }

    private static void writeText(String text){
        windows.search();
        delay(1);
        windows.write("word");
        windows.enter();
        delay(1);
        windows.enter();
        delay(1);
        windows.write(text);
        delay(1);
        word.close();
        windows.tab();
        windows.tab();
        windows.tab();
        windows.tab();
        windows.tab();
        windows.enter();
    }

    private static void saveMail(){
        windows.search();
        delay(1);
        windows.write("outlook");
        windows.enter();
        delay(2);
        outlook.switchPane();
        delay(1);
        for (int i = 0; i < 17; i++) {
            outlook.switchMap();
        };
        windows.enter();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quantity = Integer.parseInt(JOptionPane.showInputDialog(f,"Enter Quantity:"));
        for (int i = 0; i < quantity; i++) {
            delay(1);
            outlook.save();
            windows.write(String.valueOf(i));
            if (String.valueOf(i) == String.valueOf(0)) {
                windows.write("0");
            }
            delay(1);
            windows.tab();
            windows.down();
            for (int t = 0; t < 3; t++) {
                windows.up();
            };
            windows.enter();
            delay(1);
            for (int t = 0; t < 3; t++) {
                windows.tab();
            };
            delay(1);
            windows.enter();
            outlook.read();
            windows.down();

        };
        delay(1);
    }

    private static void sendMail(String mail, String text){
        windows.search();
        delay(1);
        windows.write("outlook");
        windows.enter();
        delay(1);
        outlook.switchPane();
        outlook.switchMap();
        outlook.newMail();
        windows.write(mail);
        windows.enter();
        delay(1);
        windows.tab();
        windows.tab();
        windows.tab();
        windows.write(text);
        delay(1);
        outlook.sendMail();
        delay(1);
        outlook.close();
    }

    private static void delay(int time){
        for (int i = 0; i < time; i++) {
            robot.delay(4000);
        }
    }

}
}
