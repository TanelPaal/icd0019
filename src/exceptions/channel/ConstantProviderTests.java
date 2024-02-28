package exceptions.channel;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConstantProviderTests {

    @Test
    public void returnsConstant() {
        double multiplier = new ConstantProvider().getMultiplier();

        assertThat(multiplier, is(closeTo(1.5)));
    }

    @Test(expected = MissingConstantException.class)
    public void canThrowMissingConstantException() {
        ConstantProvider provider = new ConstantProvider();

        provider.makeItThrowMissingConstantException();

        provider.getMultiplier();
    }

    @Test(expected = CorruptConfigurationException.class)
    public void canThrowCorruptConfigurationException() {
        ConstantProvider provider = new ConstantProvider();

        provider.makeItThrowCorruptConfigurationException();

        provider.getMultiplier();
    }

    private Matcher<Double> closeTo(double value) {
        double precision = 0.001;

        return Matchers.closeTo(value, precision);
    }

}