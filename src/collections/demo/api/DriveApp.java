package collections.demo.api;

public class DriveApp {

    public static Folder createFolder(String folderName) {
        Folder folder = new Folder();

        folder.setName(folderName);

        return folder;
    }

}
