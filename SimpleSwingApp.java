import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Aplikasi GUI Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Membuat label awal
        JLabel label = new JLabel("Halo, selamat datang!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(label, BorderLayout.CENTER);

        // Membuat tombol
        JButton button = new JButton("Klik Saya");
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(button, BorderLayout.SOUTH);

        // Menambahkan ActionListener pada tombol
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }
}