package junit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class MainTests {

    @Test
    public void findsSpecialNumbers() {
        assertTrue(Code.isSpecial(0));
        assertTrue(Code.isSpecial(1));
        assertTrue(Code.isSpecial(2));
        assertTrue(Code.isSpecial(3));
        assertFalse(Code.isSpecial(4)); // 4 % 11 = 4
    }

    @Test
    public void findsModeFromCharactersInString() {

        assertThat(Code.mode(null), is(nullValue()));
        assertThat(Code.mode(""), is(nullValue()));
        assertThat(Code.mode("a"), is('a'));
        assertThat(Code.mode("abcb"), is('b'));
        assertThat(Code.mode("cbbc"), is('c'));
    }

    @Test
    public void findGetCharacterCount() {
        assertThat(Code.getCharacterCount("a", 'a'), is(1));
        assertThat(Code.getCharacterCount("ab", 'a'), is(1));
        assertThat(Code.getCharacterCount("abb", 'b'), is(2));
        assertThat(Code.getCharacterCount("ab", 'c'), is(0));
        assertThat(Code.getCharacterCount("Aba", 'a'), is(1));
        assertThat(Code.getCharacterCount("", 'a'), is(not(1)));
    }

    @Test
    public void findsLongestStreak() {
        assertThat(Code.longestStreak(null), is(0));
        assertThat(Code.longestStreak(""), is(0));
        assertThat(Code.longestStreak("a"), is(1));
        assertThat(Code.longestStreak("abbcccaaaad"), is(4));
        assertThat(Code.longestStreak("abbcccaaaa"), is(4));
    }

    @Test
    public void removesDuplicates() {
        assertThat(Code.removeDuplicates(arrayOf(1, 1)), is(arrayOf(1)));

        assertThat(Code.removeDuplicates(arrayOf(1, 2, 1, 3, 2)), is(arrayOf(1, 2, 3)));

        assertThat(Code.removeDuplicates(arrayOf(1, 2, 3)), is(arrayOf(1, 2, 3)));

        assertThat(Code.removeDuplicates(arrayOf(100, 0, 3, 100, 0, 4, 562, 4)),
                is(arrayOf(100, 0, 3, 4, 562)));
    }

    @Test
    public void sumsIgnoringDuplicates() {
        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 1)), is(1));

        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 2, 1, 3, 2)), is(6));

        assertThat(Code.sumIgnoringDuplicates(arrayOf(1, 2, 3)), is(6));
    }

    private int[] arrayOf(int... numbers) {
        return numbers;
    }

}
