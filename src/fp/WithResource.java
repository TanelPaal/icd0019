package fp;

import org.junit.Test;

import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class WithResource {

    @Test
    public void usesResourceInControlledManner() {
        assertFalse(Resource.isOpen());

        withResource(resource -> resource.write("hello!"));

        assertFalse(Resource.isOpen());

        assertThat(Resource.getWrittenData(), is("hello!"));
    }

    private void withResource(Consumer<Resource> consumer) {
        Resource resource = new Resource();
        try {
            resource.open();

            consumer.accept(resource);
        } finally {
            resource.close();
        }
    }
}
