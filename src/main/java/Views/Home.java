package Views;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    private JButton jbuttonlogout;
    private JButton button1;
    private JButton JbuttonnavbarBlank;
    private JButton JbuttonnavbarAdmin;

    public Home() {
        setTitle("Home");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        // Create a JPanel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0)); // Align to the right

        // Logout Button
        jbuttonlogout = new JButton();
        ImageIcon logoutIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/logout.png"));
        int width = 40; // Adjust as needed
        int height = 30; // Adjust as needed
        Image scaledImage = logoutIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        jbuttonlogout.setIcon(new ImageIcon(scaledImage));
        jbuttonlogout.setText("Logout");
        jbuttonlogout.setPreferredSize(new Dimension(width + 80, height));
        buttonPanel.add(jbuttonlogout);

        // Admin Navbar Button with Setting Image
        JbuttonnavbarAdmin = new JButton();

        ImageIcon settingIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/setting.png"));

        if (settingIcon != null) {
            Image scaledSettingImage = settingIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            JbuttonnavbarAdmin.setIcon(new ImageIcon(scaledSettingImage));
            JbuttonnavbarAdmin.setPreferredSize(new Dimension(width + 80, height));
            buttonPanel.add(JbuttonnavbarAdmin);
        } else {
            System.err.println("Setting icon resource not found");
        }

        // Create an empty component for pushing the buttons to the top
        JPanel topFiller = new JPanel();
        topFiller.setPreferredSize(new Dimension(0, 0));

        // Create a JLabel for the welcome text
        JLabel welcomeLabel = new JLabel("Welcome To CarCare");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text

        // Add components to the frame
        add(topFiller, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.EAST);
        add(welcomeLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }
}
