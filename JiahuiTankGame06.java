package com.jiahui.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author jiahui
 * @version 1.0
 */
public class HspTankGame06 extends JFrame {

    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        HspTankGame06 hspTankGame01 = new HspTankGame06();
    }

    public HspTankGame06() {
        System.out.println("Select 1: New Game 2: Continue");
        String key = scanner.next();
        mp = new MyPanel(key);
      
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);

        this.setSize(1300, 950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
