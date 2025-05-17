package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    public String getSearchTerm();

    public String getTypeOfContent();

    String getName();

    public UUID getId();

    default String getStringRepresentation() {
        return getName() + "-" + getTypeOfContent();
    }
}
