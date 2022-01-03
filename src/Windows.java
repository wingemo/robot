package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Windows {
    private static Robot robot;

    public Windows(Robot robot)
    {
        this.robot = robot;
    }
    
    public static Robot getRobot() {
        return robot;
    }

    public static void setRobot(Robot robot) {
        Outlook.robot = robot;
    }


    public static void search(){
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }

    public static void enter(){
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void tab(){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    public static void capslock(){
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
    }

    public static void f10(){
        robot.keyPress(KeyEvent.VK_F10);
        robot.keyRelease(KeyEvent.VK_F10);
    }

    public static void down(){
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
    }

    public static void up(){
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
    }

    public static void control(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void write(String keys) {
        char ch = '@';
        for (char c : keys.toCharArray()) {
            if(c == ch){
                robot.keyPress(KeyEvent.VK_ALT_GRAPH);
                robot.keyPress(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
                robot.keyRelease(KeyEvent.VK_2);
            } else {
                if (Character.isUpperCase(c)) {
                    int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                    capslock();
                    robot.keyPress(keyCode);
                    robot.delay(100);
                    robot.keyRelease(keyCode);
                    capslock();
                }else {
                    int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                    robot.keyPress(keyCode);
                    robot.delay(100);
                    robot.keyRelease(keyCode);;
                }
            }
        }
    }

}
