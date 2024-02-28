package exceptions.basic;

public class Resource {

    private boolean isOpen = false;
    private boolean throwOnRead = false;
    private String data;

    public void open() {
        isOpen = true;
    }

    public String read() {
        if (!isOpen) {
            throw new IllegalStateException("resource is not open");
        }

        if (throwOnRead) {
            throw new RuntimeException("error while reading");
        }

        return data;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isClosed() {
        return !isOpen;
    }


    public Resource throwOnRead() {
        throwOnRead = true;
        return this;
    }

    public Resource setData(String data) {
        this.data = data;
        return this;
    }
}
