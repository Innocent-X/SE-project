// PathVisitor.java
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import javax.swing.JTextArea;

public class PathVisitor extends SimpleFileVisitor<Path> {
    private String input;
    private JTextArea textArea;

    public PathVisitor(String input, JTextArea textArea) {
        this.input = input;
        this.textArea = textArea;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (file.getFileName().toString().contains(input)) {
            textArea.append("File found: " + file + "\n");
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path p, IOException e) {
       // textArea.append("Error: "+ e +"\n");
        return FileVisitResult.CONTINUE;
    }
}