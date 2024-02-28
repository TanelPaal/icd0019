package exceptions.bad;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BadTryCatchTest {

    @Test
    public void findsStringsWithNoDuplicateLetters() {

        assertTrue(new BadTryCatch().containsSingleLetters("a"));

        assertTrue(new BadTryCatch().containsSingleLetters("abc"));

        assertFalse(new BadTryCatch().containsSingleLetters("aabc"));
    }

    @Test
    public void nullDoesNotContainSingleLetters() {

        assertFalse(new BadTryCatch().containsSingleLetters(null));
    }

}
