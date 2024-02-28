package exceptions.wrap;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryListPrinter {

    public void printDirectoryList() {
        Path currentDirectory = Paths.get(".");

        for (Path p : getDirectoryFileList(currentDirectory)) {
            String type = p.toFile().isDirectory() ? "dir" : "file";

            System.out.printf("%s, (%s) %s", p, type, System.lineSeparator());
        }
    }

    private DirectoryStream<Path> getDirectoryFileList(Path currentDirectory) {
        try {
            return Files.newDirectoryStream(currentDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
