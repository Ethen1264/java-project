package main.java.com.example.clicklike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test2 {
	public test2() {
        String playerName = test.name;
        float playerScore = ClickerGame.avg;

        JFrame frame = new JFrame("Player Score");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel nameValueLabel = new JLabel(playerName);
        nameValueLabel.setFont(new Font("Arial", Font.PLAIN, 28));

        JLabel scoreLabel = new JLabel("Score: ");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel scoreValueLabel = new JLabel(String.valueOf(playerScore));
        scoreValueLabel.setFont(new Font("Arial", Font.PLAIN, 28));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.LINE_END;

        panel.add(nameLabel, gbc);
        gbc.gridy++;
        panel.add(scoreLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(nameValueLabel, gbc);

        gbc.gridy++;
        panel.add(scoreValueLabel, gbc);

        JButton backButton = new JButton("Go Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // ���� �޴� �������� ����
                new GameMenu();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(240, 240, 240));

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
	}
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(test2::new);
    }
}
