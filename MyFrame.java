import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    private JButton searchButton;
    private JButton selectFileButton;
    private JButton openFileButton;
    private JLabel label;
    private JTextField textField;
    private JLabel label2;
    private JTextField textField2;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    public MyFrame() {
        // Set up the frame
        setTitle("File Explorer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image.png"));
        setIconImage(icon.getImage());

        // Initialize components
        Font font = new Font("SansSerif", Font.BOLD, 18); // Increased font size

        label = new JLabel("Enter file name:");
        label.setForeground(Color.LIGHT_GRAY);
        label.setFont(font); 

        textField = new JTextField(30); 
        textField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textField.setPreferredSize(new Dimension(250, 30)); // Increased preferred size

        searchButton = new JButton("Search File");
        searchButton.setFont(font); 

        selectFileButton = new JButton("Open File Manually");
        selectFileButton.setFont(font); 

        openFileButton = new JButton("Open File");
        openFileButton.setFont(font); 

        label2 = new JLabel("Enter file path to open:");
        label2.setForeground(Color.LIGHT_GRAY);
        label2.setFont(font); 

        textField2 = new JTextField(30); 
        textField2.setFont(new Font("SansSerif", Font.PLAIN, 18)); 
        textField2.setBackground(Color.DARK_GRAY);
        textField2.setForeground(Color.WHITE);
        textField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textField2.setPreferredSize(new Dimension(250, 30)); 

        
        textArea = new JTextArea(20, 50); 
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 18)); 
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.black);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(650, 400));
        
 
        
        
        
        

        // Create and set up action handlers
        BtnHandler handler = new BtnHandler(textField, textField2, textArea);
        searchButton.addActionListener(handler);
        selectFileButton.addActionListener(handler);
        openFileButton.addActionListener(handler);

        // Add components to frame
        add(label, BorderLayout.NORTH);
        add(textField, BorderLayout.NORTH);
        add(searchButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(label2);
        add(textField2);
        add(openFileButton);
//        add(scrollPane2, BorderLayout.CENTER);
        add(selectFileButton, BorderLayout.NORTH);

        // Set frame properties
        pack();
        getContentPane().setBackground(Color.black);
        setSize(new Dimension(800, 700)); 
        setLocationRelativeTo(null); 
        setResizable(false);
        setVisible(true);
    }
}
