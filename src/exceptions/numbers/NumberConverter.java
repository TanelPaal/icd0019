package exceptions.numbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class NumberConverter {
    private Properties properties;
    public String lang; // The language of the properties file.

    public NumberConverter(String lang) {
        this.lang = lang;
        this.properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/exceptions/numbers/numbers_" + lang + ".properties");
            InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
            properties.load(reader);
        } catch (IOException e) {
            throw new MissingLanguageFileException(lang, e);
        } catch (IllegalArgumentException e) {
            throw new BrokenLanguageFileException(lang, e);
        } finally {
            close(fis);
        }
    }

    public String numberInWords(Integer number) {
        // Check if a direct translation exists for the number
        if (properties.containsKey(String.valueOf(number))) {
            return properties.getProperty(String.valueOf(number));
        } else {
            // Check for a direct translation for 0-9.
            if (number >= 0 && number <= 9) {
                String result = onesWordGenerator(number);
                return result;
            }

            // Check for a direct translation for 10-99.
            if (number >= 10 && number <= 99) {
                String result = tensWordGenerator(number);
                return result;
            }
            // Check for a direct translation for 100-999.
            if (number >= 100 && number <= 999) {
                String result = hundredsWordGenerator(number);
                return result;
            }
            // If a translation for a component is missing, throw an exception
            throw new MissingTranslationException(String.valueOf(number));
        }
    }

    private String onesWordGenerator(int number) {
        // Check for a direct translation for 0-9.
        if (number >= 0 && number <= 9) {
            String onesWord = properties.getProperty(String.valueOf(number));
            if (onesWord != null) {
                return onesWord;
            }
        }
        throw new MissingTranslationException(String.valueOf(number));
    }

    private String tensWordGenerator(int number) {
        // Check for a direct translation for teens.
        if (number >= 10 && number <= 19) {
            int ones = number % 10; // Get the ones component.
            String result = generateTeensWords(ones);
            return result;
        }

        // Check for a direct translation for tens.
        int remaining = number % 100; // Get the remaining component.
        int tens = remaining / 10; // Get the tens component.
        if (tens > 1 && number % 10 == 0) {
            String result = generateTensWords(tens);
            return result;
        }

        // Check for a direct translation for tens and ones.
        if (tens > 1 && number % 10 > 0) {
            int ones = remaining % 10; // Get the ones component.
            String result = generateTensAndOnesWords(tens, ones);
            return result;
        }
        throw new MissingTranslationException(String.valueOf(number));
    }

    private String generateTeensWords(int ones) {
        String onesWord = properties.getProperty(String.valueOf(ones));
        String teenWord = properties.getProperty("teen");
        if (onesWord != null && teenWord != null) {
            return onesWord + teenWord;
        }
        throw new MissingTranslationException(String.valueOf(ones));
    }

    private String generateTensWords(int tens) {
        String tensWord = properties.getProperty(String.valueOf(tens));
        String tensSuffix = properties.getProperty("tens-suffix");
        if (tensWord != null && tensSuffix != null) {
            return tensWord + tensSuffix;
        }
        throw new MissingTranslationException(String.valueOf(tens));
    }

    private String generateTensAndOnesWords(int tens, int ones) {
        String tensWord = properties.getProperty(String.valueOf(tens * 10)); // Get the translation for the whole tens number.
        String tensWordPrefix = properties.getProperty(String.valueOf(tens)); // Get the prefix for the tens number.
        String tensWordSuffix = properties.getProperty("tens-suffix"); // Get the suffix for the tens number.
        String onesWord = properties.getProperty(String.valueOf(ones));
        String delimiter = properties.getProperty("tens-after-delimiter");
        // If the language is Estonian or Custom, the tens word is a combination of the prefix and the suffix.
        if (tensWord == null) {
            tensWord = tensWordPrefix + tensWordSuffix;
        }
        if (tensWord != null && onesWord != null && delimiter != null) {
            return tensWord + delimiter + onesWord;
        }
        throw new MissingTranslationException(String.valueOf(tens * 10 + ones));
    }

    private String hundredsWordGenerator(int number) {
        int hundreds = number / 100; // Get the hundreds component.
        int remaining = number % 100; // Get the remaining component.

        // Check for a direct translation for hundreds.
        if (hundreds > 0) {
            String hundredsWord = properties.getProperty(String.valueOf(hundreds));
            String hundredWord = properties.getProperty("hundred");
            String beforeDelimiter = properties.getProperty("hundred-before-delimiter");
            String afterDelimiter = properties.getProperty("hundred-after-delimiter");
            if (hundredsWord != null && hundredWord != null && beforeDelimiter != null && afterDelimiter != null) {
                String remainingWord = remaining == 0 ? "" : numberInWords(remaining);
                return hundredsWord + beforeDelimiter + hundredWord + (remainingWord.isEmpty() ? "" : afterDelimiter + remainingWord);
            }
        }
        throw new MissingTranslationException(String.valueOf(number));
    }

    private void close(FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException ignore) {}
        }
    }
}