package org.skypro.skyshop.info;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthComparison = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        }
    }

    private final Set<Searchable> searchables = new HashSet<>();

    public SearchEngine() {
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(Objects::nonNull)  // Игнорируем null
                .filter(searchable ->
                        searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())
                )
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(new SearchableComparator())
                ));
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                int occurrences = countOccurrences(searchTerm, query);

                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;


    }

}
