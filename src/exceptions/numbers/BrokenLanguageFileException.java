package exceptions.numbers;

public class BrokenLanguageFileException extends RuntimeException {
    public BrokenLanguageFileException(String language, Throwable cause) {
        super(String.format("Language file for %s is broken ", language), cause);
    }
}
