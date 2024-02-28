package exceptions.numbers;

public class MissingTranslationException extends RuntimeException {

    public MissingTranslationException(String key) {
        super(String.format("Translation for %s is missing ", key));
    }


}
