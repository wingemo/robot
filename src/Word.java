package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Word {
    private static Robot robot;

    public Word(Robot robot)
    {
        this.robot = robot;
    }

    public static void close(){
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);
    }
}
