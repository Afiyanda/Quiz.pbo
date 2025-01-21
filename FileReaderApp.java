import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class FileReaderApp extends JFrame {
    private final JTextArea textArea;
    private final JButton openFileButton;

    public FileReaderApp() {
        // Set judul dan ukuran frame
        setTitle("File Reader Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Membuat komponen GUI
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        openFileButton = new JButton("Open File");

        // Menambahkan komponen ke frame
        add(scrollPane, BorderLayout.CENTER);
        add(openFileButton, BorderLayout.SOUTH);

        // Menambahkan action listener untuk tombol
        openFileButton.addActionListener((ActionEvent e) -> {
            openFile();
        });
    }

    private void openFile() {
        // Membuka file menggunakan JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            readFile(selectedFile);
        }
    }

    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Memproses setiap baris file
                try {
                    int number = Integer.parseInt(line);
                    fileContent.append("Number: ").append(number).append("\n");
                } catch (NumberFormatException e) {
                    fileContent.append("Kesalahan parsing: '").append(line).append("' bukan angka yang valid.\n");
                }
            }

            textArea.setText(fileContent.toString());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + file.getName(), 
                                          "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan I/O saat membaca file: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FileReaderApp frame = new FileReaderApp();
            frame.setVisible(true);
        });
}
}