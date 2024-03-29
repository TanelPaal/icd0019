package fp.sales;

import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;


public class Analyser {

    private final Repository repository;

    public Analyser(Repository repository) {
        this.repository = repository;
    }

    public Double getTotalSales() {
        return repository.getEntries().stream()
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public Double getSalesByCategory(String category) {
        return repository.getEntries().stream()
                .filter(entry -> entry.getCategory().equals(category))
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public Double getSalesBetween(LocalDate start, LocalDate end) {
        return repository.getEntries().stream()
                .filter(entry -> !entry.getDate().isBefore(start) && !entry.getDate().isAfter(end))
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public String mostExpensiveItems() {
        return repository.getEntries().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Entry::getAmount)))
                .limit(3)
                .map(Entry::getProductId)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public String statesWithBiggestSales() {
        return repository.getEntries().stream()
                .collect(Collectors.groupingBy(Entry::getState, Collectors.summingDouble(Entry::getAmount)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));
    }
}
