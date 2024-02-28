package exceptions.basic;

public class TryCatchSample {
    public String readDataFrom(Resource resource) {
        String data;
        try {
            resource.open();
            data = resource.read();
        } catch (Exception e) {
            data = "someDefaultValue";
        } finally {
            resource.close();
        }

        return data;
    }
}
