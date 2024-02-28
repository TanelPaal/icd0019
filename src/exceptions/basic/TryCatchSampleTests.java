package exceptions.basic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TryCatchSampleTests {

    @Test
    public void readingSucceeds() {
        Resource resource = new Resource().setData("stuff");

        String data = new TryCatchSample().readDataFrom(resource);

        assertThat(data, is("stuff"));
        assertThat("opened resources must be closed",
                resource.isClosed(), is(true));
    }

    @Test
    public void readingThrows() {
        Resource resource = new Resource().throwOnRead();

        String data = new TryCatchSample().readDataFrom(resource);

        assertThat(data, is("someDefaultValue"));
        assertThat("opened resources must be closed",
                resource.isClosed(), is(true));
    }

}
