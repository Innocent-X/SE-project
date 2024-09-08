
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BtnHandler implements ActionListener {

    private JTextField textField;
    private JTextField textField2;
    private JTextArea textArea;
   

    public BtnHandler(JTextField textField, JTextField textField2, JTextArea textArea) {
        this.textField = textField;
        this.textField2 = textField2;
        this.textArea = textArea;
    }

    private void OpeningFile(Path path) {
        File file = path.toFile();
        if (!file.exists()) {
            System.out.println("The file does not exist.");
            return;
        }

        // Check if the Desktop class is supported on this platform
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);  // Open the file using the default application
                System.out.println("File opened successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("An error occurred while opening the file.");
            }
        } else {
            System.out.println("Desktop is not supported on this platform.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case "Search File":
                    String input = textField.getText();
                    if (input.isEmpty()) {
                        textArea.setText("Please enter a file name.\n");
                        return;
                    }
                    File[] roots = File.listRoots();
                    for (File root : roots) {
                        Path file = Paths.get(root.getAbsolutePath());
                        textArea.setText(""); // Clear the text area before each search

                        try {
                            PathVisitor pathVisitor = new PathVisitor(input, textArea);
                            Set<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
                            Files.walkFileTree(file, options, 5, pathVisitor);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            textArea.append("An error occurred during the search.\n");
                        }

                    }
                    if(textArea.getText().trim().isEmpty()){
                        textArea.append("No result found.\n");
                    }
                    break;
                case "Open File Manually":
                    JFileChooser fileChooser = new JFileChooser();
                    int response = fileChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        OpeningFile(Paths.get(fileChooser.getSelectedFile().getAbsolutePath()));
                        
                    }
                    break;
                case "Open File":
                    String input2 = textField2.getText();
                    if (input2.isEmpty()) {
                        textArea.setText("Please enter a file name.\n");
                        return;
                    }
                    Path path=Paths.get(input2);
                    OpeningFile(path);

                    break;
            }
        }
    }
}