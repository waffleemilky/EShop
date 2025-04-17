package org.skypro.skyshop.info;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public SearchEngine() {
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(searchable.getName(), searchable);
            }
        }

        return results;
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
