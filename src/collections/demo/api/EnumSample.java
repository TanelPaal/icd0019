package collections.demo.api;

import org.junit.Test;

public class EnumSample {

    @Test
    public void sample() {

        Folder folder = DriveApp.createFolder("My Folder");

        folder.setSharing("ANYONE", "EDIT");

        folder.setSharing(Constants.ANYONE, Constants.EDIT);

        folder.setSharingBetter(Access.ANYONE, Permission.EDIT);
    }

    @Test
    public void enumCompareTo() {
        System.out.println(
                Access.ANYONE.compareTo(Access.PRIVATE));
    }

    @Test
    public void enumValues() {
        for (Access value : Access.values()) {
            System.out.println(value);
        }
    }

    @Test
    public void enumOrdinal() {
        for (Access value : Access.values()) {
            String string = String.format(
                    "%s (%s)", value.ordinal(), value);
            System.out.println(string);
        }
    }


}

