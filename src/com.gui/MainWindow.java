package com.gui;

import generator.Lottery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class MainWindow extends JFrame implements ActionListener {

    Lottery lottery;
    private JSpinner first, second, third, fourth, fifth, sixth;
    private JButton generator, submit, clear;

    MainWindow() {
        super("Khushi Lottery");

        //initiate 6 spinner
        first = new JSpinner();
        second = new JSpinner();
        third = new JSpinner();
        fourth = new JSpinner();
        fifth = new JSpinner();
        sixth = new JSpinner();

        // placing all 6 spinners
        first.setBounds(10, 20, 50, 20);
        second.setBounds(70, 20, 50, 20);
        third.setBounds(130, 20, 50, 20);
        fourth.setBounds(190, 20, 50, 20);
        fifth.setBounds(250, 20, 50, 20);
        sixth.setBounds(310, 20, 50, 20);

        //initiate generator, submit, clear button
        generator = new JButton("Quick Pic");
        submit = new JButton("Submit");
        clear = new JButton("Clear");

        // generator button properties
        generator.setBackground(Color.magenta);
        generator.setForeground(Color.white);
        generator.setBounds(30, 80, 100, 40);
        generator.setActionCommand("generate");

        //submit button properties
        submit.setBackground(Color.red);
        submit.setForeground(Color.white);
        submit.setBounds(140, 80, 100, 40);
        submit.setActionCommand("submit");

        //submit button properties
        clear.setBackground(Color.red);
        clear.setForeground(Color.white);
        clear.setBounds(250, 80, 100, 40);
        clear.setActionCommand("clear");

        //added event listener
        generator.addActionListener(this::actionPerformed);
        submit.addActionListener(this::actionPerformed);
        clear.addActionListener(this::actionPerformed);

        // initiate main window frame
        setSize(400, 500);
        setLayout(null);
        setVisible(true);

        /////// add all components to main frame
        //spinners
        add(first);
        add(second);
        add(third);
        add(fourth);
        add(fifth);
        add(sixth);
        //buttons
        add(generator);
        add(submit);
        add(clear);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "generate":
                lottery = new Lottery();
                int[] finalVal = lottery.generateFinalSequence();
                first.setValue(finalVal[0]);
                second.setValue(finalVal[1]);
                third.setValue(finalVal[2]);
                fourth.setValue(finalVal[3]);
                fifth.setValue(finalVal[4]);
                sixth.setValue(finalVal[5]);
                break;
            case "submit":
                System.out.println("Submit Clicked");
                break;
            default:
                first.setValue(0);
                second.setValue(0);
                third.setValue(0);
                fourth.setValue(0);
                fifth.setValue(0);
                sixth.setValue(0);
                break;

        }
    }
}
