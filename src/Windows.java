package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Windows {
    private static Robot robot;

    public Windows(Robot robot)
    {
        this.robot = robot;
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
