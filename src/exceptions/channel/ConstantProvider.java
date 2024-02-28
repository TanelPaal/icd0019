package exceptions.channel;

import java.io.IOException;

public class ConstantProvider {

    private boolean throwCorruptConfiguration = false;
    private boolean throwMissingConstant = false;

    public double getMultiplier() {
        if (throwMissingConstant) {
            throw new MissingConstantException();
        } else if (throwCorruptConfiguration) {
            throw new CorruptConfigurationException();
        }

        return 1.5;
    }

    public double getMultiplier2() throws IOException {
        throw new IOException("can't find configuration file");
    }

    public void makeItThrowCorruptConfigurationException() {
        throwCorruptConfiguration = true;
    }

    public void makeItThrowMissingConstantException() {
        throwMissingConstant = true;
    }

}
