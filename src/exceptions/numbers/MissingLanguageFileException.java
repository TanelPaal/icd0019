package exceptions.numbers;

public class MissingLanguageFileException extends RuntimeException {

    public MissingLanguageFileException(String language, Throwable cause) {
        super(String.format("Language file for %s is missing ", language), cause);
    }
}
