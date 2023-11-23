package main.java.com.example.clicklike;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameMenu {
    static JFrame frame;

    public GameMenu() {
    	frame = new JFrame("게임 메뉴");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        ImageIcon backgroundImage = new ImageIcon("background.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        frame.setContentPane(backgroundLabel);
        backgroundLabel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("game menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.BLACK);

        JButton startButton = new JButton("game start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // ���� �޴� �������� ����
                new ClickerGame();
            }
        });

        JButton scoreButton = new JButton("ranking");
        scoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreButton.setFont(new Font("Arial", Font.PLAIN, 20));
        scoreButton.setBackground(Color.BLUE);
        scoreButton.setForeground(Color.WHITE);
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // ���� �޴� �������� ����
                new ranking();
            }
        });

        JButton exitButton = new JButton("exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        menuPanel.add(titleLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        menuPanel.add(startButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(scoreButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(exitButton);

        backgroundLabel.add(menuPanel, BorderLayout.CENTER);

        frame.setVisible(true);
	}

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(GameMenu::new);
    }
}


