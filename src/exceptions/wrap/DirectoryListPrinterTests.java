package exceptions.wrap;

import org.junit.Test;

import java.io.IOException;

public class DirectoryListPrinterTests {

    @Test
    public void readingThrowsExample() {
        new DirectoryListPrinter().printDirectoryList();
    }

}
