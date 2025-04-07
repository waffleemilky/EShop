package org.skypro.skyshop.info;

import java.io.IOException;

public class BestResultNotFound extends IOException {
    private final String searchQuery;

    public BestResultNotFound(String searchQuery) {
        super("Не удалось найти наилучший результат для поискового запроса: " + searchQuery);
        this.searchQuery = searchQuery;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

}
