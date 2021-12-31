package com.company;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.*;

public class Robot {
    private static Robot robot;
    private static Outlook outlook;
    private static Windows windows;
    private static Word word;

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        String textB = "Hello World Bobby in the house";
        String mail = "philip.wingemo@outlook.com";
        String text = "Hello World";
        String textC = "Im alive";

        initialization();
        writeText(textB);
        sendMail(mail, text);
        writeText(textC);
    }

    private static void initialization(){
        try {
            robot = new Robot();
            outlook = new Outlook(robot);
            windows = new Windows(robot);
            word = new Word(robot);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void writeText(String text){
        windows.search();
        delay();
        windows.write("word");
        windows.enter();
        delay();
        windows.enter();
        delay();
        windows.write(text);
        delay();
        word.close();
        windows.tab();
        windows.tab();
        windows.tab();
        windows.tab();
        windows.tab();
        windows.enter();
    }

    private static void sendMail(String mail, String text){
        windows.search();
        delay();
        windows.write("outlook");
        windows.enter();
        delay();
        outlook.switchPane();
        outlook.switchMap();
        outlook.newMail();
        windows.write(mail);
        windows.enter();
        delay();
        windows.tab();
        windows.tab();
        windows.write(text);
        delay();
        outlook.sendMail();
        delay();
        outlook.close();
    }

    private static void delay(){
        robot.delay(2000);
    }

}
