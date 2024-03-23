package generics.recursion;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public List<String> getParts(Path path) {
        List<String> parts = new ArrayList<>();

        Path runner = path;

        while (runner != null) {
            parts.addFirst(runner.getFileName().toString());
            runner = runner.getParent();
        }

        return parts;
    }

    public List<String> getParts2(Path path) {
        // "a/b/c/d.txt"

        if (path == null) {
            return null;
        }

        getParts2(path.getParent());

        System.out.println(path.getFileName().toString());

        return null;
    }

    public List<String> getParts3(Path path) {
        List<String> parts = new ArrayList<>();

        getParts3(path, parts);

        return parts;
    }

    private List<String> getParts3(Path path, List<String> parts) {

        if (path == null) {
            return null;
        }

        getParts3(path.getParent(), parts);

        parts.add(path.getFileName().toString());

        return null;
    }

    public List<String> getParts4(Path path) {
//      "a/b/c/d.txt"

        if (path == null) {
            return new ArrayList<>();
        }

        List<String> parts = getParts4(path.getParent());

        parts.add(path.getFileName().toString());

        return parts;
    }
}
