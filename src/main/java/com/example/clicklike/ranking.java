package main.java.com.example.clicklike;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class ranking {

    private static final String jdbc = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "0000";


    public ranking() {

        JFrame frame = new JFrame("Game Ranking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(new Color(69, 40, 60));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(255, 223, 186));

        JLabel titleLabel = new JLabel("Game Ranking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(69, 40, 60));
        panel.add(titleLabel, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel();
        JTable rankingTable = new JTable(model);
        rankingTable.setFont(new Font("Arial", Font.PLAIN, 20));

        model.addColumn("Rank");
        model.addColumn("Name");
        model.addColumn("Score");

        try {
            Connection conn = DriverManager.getConnection(jdbc, username, password);
            String sql = "SELECT * FROM users ORDER BY scores DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int rank = 1;
            while (rs.next() && rank <= 5) {
                String name = rs.getString("name");
                float scores = rs.getFloat("scores");

                model.addRow(new Object[]{rank, name, scores});
                rank++;
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 셀 가운데 정렬을 위한 렌더러 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < rankingTable.getColumnCount(); i++) {
            rankingTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // 표의 행 높이 설정
        rankingTable.setRowHeight(40); // 행 높이 조정

        // 표의 열 너비 설정
        rankingTable.getColumnModel().getColumn(0).setPreferredWidth(100); // Rank 열 너비 조정
        rankingTable.getColumnModel().getColumn(1).setPreferredWidth(300); // Name 열 너비 조정
        rankingTable.getColumnModel().getColumn(2).setPreferredWidth(200); // Score 열 너비 조정

        JScrollPane scrollPane = new JScrollPane(rankingTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ranking::new);
    }
}