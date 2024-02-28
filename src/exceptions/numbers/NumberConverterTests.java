package exceptions.numbers;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberConverterTests {

    @Test(expected = MissingLanguageFileException.class)
    public void selectingMissingLanguageThrows() {
        new NumberConverter("ru");
    }

    @Test(expected = BrokenLanguageFileException.class)
    public void selectingBrokenLanguageFileThrows() {
        new NumberConverter("fr");
    }

    @Test(expected = MissingTranslationException.class)
    public void missingEssentialTranslationThrows() {
        new NumberConverter("es").numberInWords(1);
    }

    @Test
    public void canConvertNumbersToEnglish() {
        NumberConverter converter = new NumberConverter("en");

        assertThat(converter.numberInWords(0), is("zero"));

        assertThat(converter.numberInWords(1), is("one"));

        assertThat(converter.numberInWords(13), is("thirteen"));

        assertThat(converter.numberInWords(19), is("nineteen"));

        assertThat(converter.numberInWords(20), is("twenty"));

        assertThat(converter.numberInWords(21), is("twenty-one"));

        assertThat(converter.numberInWords(100), is("one hundred"));

        assertThat(converter.numberInWords(200), is("two hundred"));

        assertThat(converter.numberInWords(123), is("one hundred twenty-three"));

        assertThat(converter.numberInWords(999), is("nine hundred ninety-nine"));
    }

    @Test
    public void canConvertNumbersUpTo130ToEnglish() {
        assertCanConvertNumbersUpTo(130, "en");
    }

    @Test
    public void canConvertNumbersUpTo130ToEstonian() {
         assertCanConvertNumbersUpTo(130, "et");
    }

    @Test
    public void canConvertNumbersUpTo130ToCustomLanguage() {
        assertCanConvertNumbersUpTo(130, "cu");
    }

    @Test
    public void canHandleNumbersUpToOneBillion() {
        NumberConverter c = new NumberConverter("et");

        int[] testValues = {
                1000, 2321, 654000, 1000000, 2000432, 9634000, 1000000000 };

        for (int number : testValues) {
            assertThat(c.numberInWords(number), is(getExpectedLarge(number)));
        }
    }

    private void assertCanConvertNumbersUpTo(int upperBound, String lang) {
        for (int i = 0; i <= upperBound; i++) {
            String numberInWords = new NumberConverter(lang).numberInWords(i);

            assertThat(numberInWords, is(getExpected(lang, i)));
        }
    }

    private String getExpectedLarge(int number) {
        if (!largeMap.containsKey(number)) {
            throw new RuntimeException("missing entry for " + number);
        }

        return largeMap.get(number);
    }

    private String getExpected(String lang, int index) {
        List<String> strings = map.get(lang);

        if (strings == null) {
            throw new RuntimeException("unexpected language: " + lang);
        }

        if (index < 0 || index >= strings.size()) {
            throw new RuntimeException("no test data for number: " + index);
        }

        return strings.get(index);
    }

    private final Map<String, List<String>> map = new HashMap<>();
    private final Map<Integer, String> largeMap = new HashMap<>();

    @Before
    public void setUp() throws IOException {
        setUpSmallNumbers();

        setUpLargeNumbers();
    }

    public void setUpSmallNumbers() throws IOException {
        String template = "src/exceptions/numbers/expected-%s.txt";

        map.put("en", getAllLines(template, "en"));
        map.put("et", getAllLines(template, "et"));
        map.put("cu", getAllLines(template, "cu"));
    }

    private static List<String> getAllLines(String template, String lang) throws IOException {
        return Files.readAllLines(Paths.get(String.format(template, lang)),
                StandardCharsets.ISO_8859_1);
    }

    public void setUpLargeNumbers() throws IOException {
        String path = "src/exceptions/numbers/expected-et-large.txt";

        List <String> lines = Files.readAllLines(Paths.get(path),
                StandardCharsets.ISO_8859_1);

        for (String line : lines) {
            String[] parts = line.split("=");
            largeMap.put(Integer.parseInt(parts[0]), parts[1]);
        }
    }
}
