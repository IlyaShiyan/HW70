import java.io.File;
import java.io.IOException;
import java.lang.module.Configuration;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:/Test").toAbsolutePath();
        Files.walkFileTree(Path.of("C:/Test"), new MyFileVisitor());
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName() + ", " + file.toFile().length() + ", " +
                file.toFile().isDirectory());
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException e)
            throws IOException{
        System.out.println(dir.getFileName() + ", " + dir.toFile().length() + ", " +
                dir.toFile().isDirectory());
        return FileVisitResult.CONTINUE;
    }

}

