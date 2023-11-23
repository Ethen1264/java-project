package main.java.com.example.clicklike;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;




public class test {
	static JFrame frame;

    static String name;

	public test() {


            String jdbc = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "0000";



        JFrame frame = new JFrame("Name Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("Your Name");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setPreferredSize(new Dimension(200, 30));



        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DriverManager.getConnection(jdbc, username, password);

                    String sql = "INSERT INTO users (name, scores) VALUES (?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, name = nameField.getText());
                    pstmt.setFloat(2, ClickerGame.avg);

                    int affectedRows = pstmt.executeUpdate();

                    pstmt.close();
                    conn.close();
                } catch (Exception g) {
                    g.printStackTrace();
                }
                frame.setVisible(false); // ���� �޴� �������� ����
                new test2();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(nameLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
	}
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(test::new);
    }
}
