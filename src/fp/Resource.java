package fp;

public class Resource {

    private static boolean isOpen = false;
    private static String writtenData = "";

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public void write(String data) {
        if (!isOpen) {
            throw new IllegalStateException("resource is not open");
        }

        writtenData += data;
    }

    public static String getWrittenData() {
        return writtenData;
    }

    public static boolean isOpen() {
        return isOpen;
    }
}
