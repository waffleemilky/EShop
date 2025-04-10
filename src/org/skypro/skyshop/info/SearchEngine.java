package org.skypro.skyshop.info;

public class SearchEngine {
    private final Searchable[] searchables;
    private int itemCount = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[resultCount] = searchable;
                resultCount++;

                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (itemCount < searchables.length) {
            searchables[itemCount] = searchable;
            itemCount++;
        } else {
            System.out.println("Превышено максимальное количество элементов для поиска.");
        }
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
