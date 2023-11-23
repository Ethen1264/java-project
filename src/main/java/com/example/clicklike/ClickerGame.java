package main.java.com.example.clicklike;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class ClickerGame {
	static JFrame frame;
    public float clicknum = 0;

    static float avg = 0;
    public float timeLimit = 10; // ���� �ð� (��)
    public float time = timeLimit;

    private JProgressBar progressBar;
    private JLabel timeLabel;
    private JButton clickButton;
    private Timer timer;

    String jdbc = "jdbc:mysql://localhost:3306/jdbc";
    String username = "root";
    String password = "0000";

    public ClickerGame() {

        JFrame frame = new JFrame("Clicker Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 20);
        progressBar.setStringPainted(true);
        progressBar.setString(String.format("%.2f", clicknum / timeLimit));
        progressBar.setForeground(new Color(0, 204, 0)); // ������ �� ����
        progressBar.setFont(new Font("Arial", Font.BOLD, 48));
        frame.add(progressBar, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(255, 255, 204)); // ���� ����

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // ���� ����

        timeLabel = new JLabel("Time: " + String.format("%.2f", timeLimit));
        timeLabel.setForeground(new Color(204, 0, 0)); // �ð� ���̺� �ؽ�Ʈ ����
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        centerPanel.add(timeLabel, gbc);

        gbc.gridy = 1;
        clickButton = new JButton("Click Me!");
        clickButton.setForeground(Color.BLACK);
        clickButton.setBorderPainted(false);
        clickButton.setContentAreaFilled(false);
        clickButton.setBackground(new Color(255, 255, 204));
        clickButton.setFont(new Font("Arial", Font.BOLD, 80));
        clickButton.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        clickButton.addActionListener(e -> increaseScore());
        clickButton.setPreferredSize(new Dimension(400, 150)); // ��ư�� ũ�� ����
        centerPanel.add(clickButton, gbc);

        frame.add(centerPanel, BorderLayout.CENTER);

        timer = new Timer(10, e -> updateTime());
        timer.start();

        frame.setVisible(true);
    }

    private void increaseScore() {
        clicknum += 1;
    }

    private void updateTime() {
        timeLimit -= 0.01;
        DecimalFormat decimalFormat = new DecimalFormat("0.##"); // �Ҽ��� �� �ڸ����� ǥ��
        timeLabel.setText("Time: " + decimalFormat.format(timeLimit)); // �Ҽ��� �� �ڸ����� ǥ��
        System.out.println(decimalFormat.format(timeLimit));
        progressBar.setString(String.format("%.1f", avg = clicknum / (time - timeLimit)));

        if (timeLimit <= 0) {
            timer.stop();
            clickButton.setEnabled(false);
            System.out.println("�ȵǳ�?");
            if (frame != null) {
                frame.dispose(); // ���� â�� ����
                System.out.println("�ȵǳ�?");
            }

            SwingUtilities.invokeLater(() -> {
                new test();
            });
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClickerGame::new);
    }
}
