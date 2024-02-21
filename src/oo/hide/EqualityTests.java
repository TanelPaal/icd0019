package oo.hide;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;

public class EqualityTests {

    @Test
    public void testsEquality() {

        assertFalse(new Point(1, 2) == new Point(1, 2));

        assertTrue(new Point(1, 2).equals(new Point(1, 2)));

        assertThat(new Point(1, 2), is(new Point(1, 2)));

        assertThat(new Point(1, 1), is(not(new Point(1, 2))));

        assertThat(new Point(1, 1), is(notNullValue()));
    }
}
