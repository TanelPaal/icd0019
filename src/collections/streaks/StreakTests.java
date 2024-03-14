package collections.streaks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class StreakTests {
    
    @Test
    public void findsStreaks() {

        assertThat(Code.getStreakList("").toString(), is("[]"));

        assertThat(Code.getStreakList("a").toString(), is("[[a]]"));

        assertThat(Code.getStreakList("ab").toString(), is("[[a], [b]]"));

        assertThat(Code.getStreakList("abbc").toString(),
                is("[[a], [b, b], [c]]"));
    }

}
