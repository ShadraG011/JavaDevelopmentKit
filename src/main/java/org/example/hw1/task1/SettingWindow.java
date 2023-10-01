/*
 * Первое задание – добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты в заданном порядке:
 * JLabel с заголовком «Выберите режим игры», сгруппированные в ButtonGroup
 * переключаемые JRadioButton с указанием режимов «Человек против компьютера» и «Человек против человека», JLabel с заголовком «Выберите размеры
 * поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10,
 * JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:», JSlider со значениями 3..10.
 */
package org.example.hw1.task1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingWindow extends JFrame {
    // ___________________Работа на семенаре_________________
    private int gameMode = 0;
    JLabel gameRegime = new JLabel("Выберите режим игры!");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека", true);
    JRadioButton humanVsAI = new JRadioButton("Человек против компьютера");
    ButtonGroup topButtonGroup = new ButtonGroup();

    JLabel fieldSize = new JLabel("Выберите размер поля!");
    JSlider fieldSizeSlider = new JSlider(3, 10,3);
    JLabel establishedFieldSize = new JLabel("Установленный размер поля: " + fieldSizeSlider.getValue());

    JLabel winSize = new JLabel("Выберите длину для победы!");
    JSlider winSizeSlider = new JSlider(3, 10, 3);
    JLabel establishedWinSize = new JLabel("Установленная длина: " + winSizeSlider.getValue());


    JPanel top = new JPanel(new GridLayout(2,1));
    JPanel topBtn = new JPanel(new GridLayout(2,1));
    JPanel middle = new JPanel(new GridLayout(3,1));

    JPanel bottom = new JPanel(new GridLayout(4,1));

    JPanel grid = new JPanel(new GridLayout(4, 1));

    // ________________________________________________________

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game!");

    SettingWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMode = humanVsHuman.isSelected() ? 0 : 1;
                gameWindow.startNewGame(gameMode, fieldSizeSlider.getValue(), fieldSizeSlider.getValue(), winSizeSlider.getValue());
            }
        });

        topButtonGroup.add(humanVsHuman);
        topButtonGroup.add(humanVsAI);
        topBtn.add(humanVsHuman);
        topBtn.add(humanVsAI);
        top.add(gameRegime);
        top.add(topBtn);

        middle.add(fieldSize);
        middle.add(establishedFieldSize);
        middle.add(fieldSizeSlider);

        fieldSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                establishedFieldSize.setText("Установленный размер поля: " + fieldSizeSlider.getValue());
            }
        });


        bottom.add(winSize);
        bottom.add(establishedWinSize);
        bottom.add(winSizeSlider);
        winSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                establishedWinSize.setText("Установленная длина: " + winSizeSlider.getValue());
            }
        });


        grid.add(top);
        grid.add(middle);
        grid.add(bottom);
        grid.add(btnStart);

        add(grid);


    }
}
