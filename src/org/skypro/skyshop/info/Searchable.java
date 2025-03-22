package org.skypro.skyshop.info;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}
