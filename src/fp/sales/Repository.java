package fp.sales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private static final String FILE_PATH = "src/fp/sales/sales-data.csv";

    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");


    public List<Entry> getEntries() {

        // reads lines form the file and creates entry objects for each line.
        try {
            return Files.readAllLines(Paths.get(FILE_PATH)).stream()
                    .skip(1) // skip the header
                    .map(line -> line.split("\t"))
                    .map(this::createEntry)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Entry createEntry(String[] parts) {
        Entry entry = new Entry();
        entry.setDate(LocalDate.parse(parts[0], formatter));
        entry.setState(parts[1]);
        entry.setProductId(parts[2]);
        entry.setCategory(parts[3]);
        entry.setAmount(Double.parseDouble(parts[5].replace(",", ".")));

        return entry;
    }
}
